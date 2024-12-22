package com.foodApp.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.dao.RestaurantDAO;
import com.foodApp.model.Restaurant;

public class RestaurantDAOImpl  implements RestaurantDAO
{
	
	List <Restaurant>restaurantList=new ArrayList<Restaurant>();
	private final String INSERT_QUERY="insert into `restaurant`(`name`,`cusineType`,`address`,`ratings`) values(?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from `restaurant`";
	private final String FETCH_QUERY="select * from `restaurant` where `restaurantid`=?";
	private final String UPDATE_QUERY="update `restaurant` set `cusineType`=? where `restaurantid`=?";
	private final String DELETE_QUERY="delete from  `restaurant` where `restaurantid`=?";
	
	private String url="jdbc:mysql://localhost:3306/fooddelivery";
	private String username="root";
	private String password="root";
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	
	private ResultSet resultSet;
	private Restaurant r;
	private Statement stmt;
	
	public RestaurantDAOImpl()
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
	public void insert(Restaurant r) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getCusineType());
			pstmt.setString(3, r.getAddress());
			pstmt.setInt(4, r.getRatings());
			
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
	public List<Restaurant> fetchAll() 
	{
		try 
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_QUERY);
			restaurantList=extractStudentListFromResultSet(resultSet);
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return restaurantList;
	}
	
	List<Restaurant> extractStudentListFromResultSet( ResultSet resultSet)
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
				
				restaurantList.add( new Restaurant(resultSet.getInt("restaurantid"),
						resultSet.getString("name"),
						resultSet.getString("cusineType"),
						resultSet.getString("address"),
						resultSet.getInt("ratings"),
						resultSet.getString("image")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return restaurantList;
	}


	@Override
	public Restaurant fetchSpecific(int id) 
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
				
				
				
			restaurantList=extractStudentListFromResultSet(resultSet);
//				s=studentList.get(0);
				
//				r=extractStudentListFromResultSet(resultSet).get(0);
				
				
				if(!restaurantList.isEmpty())
				{
					r=restaurantList.get(0);
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
		return r;
	}


	@Override
	public int update(Restaurant r) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, r.getCusineType());
			pstmt.setInt(2, r.getRestaurantid());
			
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
}


