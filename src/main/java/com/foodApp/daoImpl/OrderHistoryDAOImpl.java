package com.foodApp.daoImpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.dao.OrderHistoryDAO;
import com.foodApp.database.DatabaseConnection;
import com.foodApp.model.OrderHistory;





public class OrderHistoryDAOImpl implements OrderHistoryDAO
{

	 List<OrderHistory>orderHistoryList=new ArrayList<OrderHistory>();
	private final String INSERT_QUERY="insert into `orderhistory`(`orderid`,`uid`,`restaurantid`,`total`,`status`) values(?,?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from `orderhistory`";
	private final String FETCH_QUERY="select * from `orderhistory` where `orderid`=?";
	private final String UPDATE_QUERY="update `orderhistory` set `total`=? where `orderhistoryid`=?";
	private final String DELETE_QUERY="delete from  `orderhistory` where `orderhistoryid`=?";
	private static final  String SQL = "SELECT oh.*, o.date_time, r.name " +
            "FROM orderhistory oh " +
            "JOIN orders o ON oh.orderid = o.orderid " +
            "JOIN restaurant r ON oh.restaurantid = r.restaurantid " +
            "WHERE oh.uid = ?";
	private String url="jdbc:mysql://localhost:3306/fooddelivery";
	private String username="root";
	private String password="root";
	private Connection con;
	private PreparedStatement pstmt;
	private int status1;
	private Statement stmt;
	private ResultSet resultSet;
	private OrderHistory ohi;
	private Connection connection;
	
	
	
	
	public OrderHistoryDAOImpl()
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
	public void insert(OrderHistory ohi) {
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, ohi.getOrderid());
			pstmt.setInt(2, ohi.getUid());
			pstmt.setInt(3, ohi.getRestaurantid());
			pstmt.setInt(4, ohi.getTotal());
			pstmt.setString(5, ohi.getStatus());
			status1=pstmt.executeUpdate();
			if(status1!=0)
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
	public List<OrderHistory> fetchAll()
	{
		try 
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_QUERY);
			orderHistoryList=extractStudentListFromResultSet(resultSet);
			
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return orderHistoryList;
	}
	
	List<OrderHistory> extractStudentListFromResultSet( ResultSet resultSet)
	{
		try
		{
			while(resultSet.next()==true)
			{
//				System.out.println(resultSet.getInt("uid")+" "+
//				resultSet.getString("username")+" "
//				+resultSet.getString("email")+" "
//				+resultSet.getString("password")+" "
//				+resultSet.getInt("mobile"));
				
				orderHistoryList.add( new OrderHistory(resultSet.getInt("orderhistoryid"),
						resultSet.getInt("orderid"),
						resultSet.getInt("uid"),
						resultSet.getInt("restaurantid"),
						resultSet.getInt("total"),
						resultSet.getString("status")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderHistoryList;
	}





	@Override
	public OrderHistory fetchSpecific(int id) {
		try
		{
			pstmt=con.prepareStatement(FETCH_QUERY);
			pstmt.setInt(1, id);
			
			resultSet=pstmt.executeQuery();
			
			
			
			
			
			orderHistoryList=extractStudentListFromResultSet(resultSet);
//			u=userList.get(0);
			
//			u=extractStudentListFromResultSet(resultSet).get(0);
			
			if(!orderHistoryList.isEmpty())
			{
				ohi=orderHistoryList.get(0);
			}
			else
			{
				System.out.println("No Record");
				System.exit(0);
			}
			
			
			
			
			
//			while(resultSet.next())
//			{
//				u=new User(resultSet.getInt("uid"),
//						resultSet.getString("username"),
//						resultSet.getString("email"),
//						resultSet.getString("password"),
//						resultSet.getInt("mobile"));
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ohi;
	}





	@Override
	public int update(OrderHistory ohi)
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, ohi.getTotal());
			pstmt.setInt(2, ohi.getOrderhistoryid());
			
			status1=pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status1;
		
	}





	@Override
	public int delete(int id)
	{
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,id);
			status1=pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status1;
	}
	
	public List<OrderHistory> getOrderHistoryByUserID(int userID) {
        List<OrderHistory> orderHistoryList = new ArrayList<>();
        Connection connection = null;
        try {
        	connection = DatabaseConnection.initializeDatabase();
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderHistory order = new OrderHistory();
                order.setOrderid(rs.getInt("orderid"));
                order.setRestaurantid(rs.getInt("restaurantid"));
                order.setTotal(rs.getInt("total"));
                order.setStatus(rs.getString("status"));
                order.setRestaurantname(rs.getString("name"));
             // Convert the Timestamp to String
                Timestamp timestamp = rs.getTimestamp("date_time");
                if (timestamp != null) {
                    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
                    order.setOrderDate(formattedDate); // Set the formatted string
                }// Dynamically fetched
                
                orderHistoryList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderHistoryList;
    }
	public OrderHistory fetchSpecifics(int orderId) {
	    OrderHistory orderHistory = new OrderHistory();
	    String query = "SELECT o.orderid, o.status, o.total, r.name, ord.date_time " +
	                   "FROM orderhistory o " +
	                   "JOIN restaurant r ON o.restaurantid = r.restaurantid " +
	                   "JOIN orders ord ON o.orderid = ord.orderid " +
	                   "WHERE o.orderid = ?";

	    try {
	    	connection = DatabaseConnection.initializeDatabase();
            PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setInt(1, orderId);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // Set fields for OrderHistory
	            orderHistory.setOrderid(rs.getInt("orderid"));
	            orderHistory.setStatus(rs.getString("status"));
	            orderHistory.setTotal(rs.getInt("total"));

	            // Set restaurant name
	            orderHistory.setRestaurantname(rs.getString("name"));

	            // Set order date
	            Timestamp timestamp = rs.getTimestamp("date_time");
	            if (timestamp != null) {
	                orderHistory.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return orderHistory;
	}

}


