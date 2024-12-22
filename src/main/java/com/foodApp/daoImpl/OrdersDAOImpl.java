package com.foodApp.daoImpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.dao.OrdersDAO;
import com.foodApp.database.DatabaseConnection;
import com.foodApp.model.CartItem;
import com.foodApp.model.Orders;



public class OrdersDAOImpl implements OrdersDAO {
	
	List <Orders>ordersList=new ArrayList<Orders>();
	private final String INSERT_QUERY="insert into `orders`(`uid`,`restaurantid`,`menuid`,`quantity`,`total_amount`,`payment_mode`,`status`) values(?,?,?,?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from `orders`";
	private final String FETCH_QUERY="select * from `orders` where `orderid`=?";
	private final String UPDATE_QUERY="update `orders` set `quantity`=? where `orderid`=?";
	private final String DELETE_QUERY="delete from  `orders` where `orderid`=?";
	
	
	
	private String url="jdbc:mysql://localhost:3306/fooddelivery";
	private String username="root";
	private String password="root";
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	private Orders o;
	private Connection connection;
	
	
	public OrdersDAOImpl()
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
	}
	
	
	
	
	@Override
	public void insert(Orders o) {
		
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1,o.getUid());
			pstmt.setInt(2, o.getRestaurantid());
			pstmt.setInt(3, o.getMenuid());
			pstmt.setInt(4, o.getQuantity());
			pstmt.setInt(5, o.getTotal_amount());
			pstmt.setString(6, o.getPayment_mode());
			pstmt.setString(7, o.getStatus());
			
			
			status=pstmt.executeUpdate();
			if(status!=0)
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("Failure");
			}
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}




	@Override
	public List<Orders> fetchAll()
	{
		
		try 
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_QUERY);
			ordersList=extractStudentListFromResultSet(resultSet);
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return ordersList;
	}
	
	List<Orders> extractStudentListFromResultSet( ResultSet resultSet)
	{
		try
		{
			while(resultSet.next()==true)
			{
//				System.out.println(resultSet.getInt("sid")+" "+
//							resultSet.getString("fname")+" "
//							+resultSet.getString("lname")+" "
//							+resultSet.getString("email")+" "
//							+resultSet.getInt("mobile"));
				
				ordersList.add( new Orders(resultSet.getInt("orderid"),
						resultSet.getInt("uid"),
						resultSet.getInt("restaurantid"),
						resultSet.getInt("menuid"),
						resultSet.getInt("quantity"),
						resultSet.getInt("total_amount"),
						resultSet.getString("payment_mode"),
						resultSet.getString("status")
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ordersList;
	}




	@Override
	public Orders fetchSpecific(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCH_QUERY);
			pstmt.setInt(1, id);
			
			resultSet=pstmt.executeQuery();
//			
//			while(resultSet.next())
//			{
//				s= new Student(resultSet.getInt("sid"),
//						resultSet.getString("fname"),
//						resultSet.getString("lname"),
//						resultSet.getString("email"),
//						resultSet.getInt("mobile"));
				
				
				
			ordersList=extractStudentListFromResultSet(resultSet);
//				s=studentList.get(0);
				
//				r=extractStudentListFromResultSet(resultSet).get(0);
				
				
				if(!ordersList.isEmpty())
				{
					o=ordersList.get(0);
				}
				else
				{
					System.out.println("No Record");
					System.exit(0);
				}
				
//			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}




	@Override
	public int update(Orders o) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, o.getQuantity());
			pstmt.setInt(2, o.getOrderid());
			
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status;
	}




	@Override
	public int delete(int id)
	{
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,id);
			status=pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status;
	}

	 public List<CartItem> getOrderItemsByOrderId(int orderId) {
	        List<CartItem> items = new ArrayList<>();
	        String query = "SELECT oi.menuid, m.name, m.price,m.image, oi.quantity " +
	                       "FROM orderitems oi " +
	                       "JOIN menu m ON oi.menuid = m.menuid " +
	                       "WHERE oi.orderid = ?";

	        try  {
	        	connection = DatabaseConnection.initializeDatabase();
	             PreparedStatement stmt = connection.prepareStatement(query);

	            stmt.setInt(1, orderId);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                CartItem item = new CartItem();
	                item.setName(rs.getString("name"));  // Item name from menu table
	                item.setPrice(rs.getInt("price"));     // Price from order_items table
	                item.setQuantity(rs.getInt("quantity"));  // Quantity from order_items table
	                item.setImage(rs.getString("image"));
	                items.add(item);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return items;
	    }
	 
}
