package com.foodApp.daoImpl;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.dao.UserDAO;
import com.foodApp.model.User;
import com.tap.secret.Secret.Decrypt;




public class UserDAOImpl implements UserDAO
{
	
	List <User>userList=new ArrayList<User>();
	private final String INSERT_QUERY="insert into `user`(`username`,`email`,`password`,`mobile`) values(?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from `user`";
	private final String FETCH_QUERY="select * from `user` where `uid`=?";
	private final String UPDATE_QUERY="update `user` set `email`=? where `uid`=?";
	private final String SELECT_ON_EMAIL="select * from `user` where `email`=?";
	private final String DELETE_QUERY="delete from  `user` where `uid`=?";
	private String url="jdbc:mysql://localhost:3306/fooddelivery";
	private String username="root";
	private String password="root";
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	
	private ResultSet resultSet;
	private Statement stmt;
	private User u;
	private User user;
	
	public UserDAOImpl()
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
	public void insert(User u) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getMobile());
			
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
	public List<User> fetchAll()
	{
		try 
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_QUERY);
			userList=extractStudentListFromResultSet(resultSet);
			
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return userList;
	}
	
	List<User> extractStudentListFromResultSet( ResultSet resultSet)
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
				
				userList.add( new User(resultSet.getInt("uid"),
						Decrypt.decrypt(resultSet.getString("username")),
						Decrypt.decrypt(resultSet.getString("email")),
						Decrypt.decrypt(resultSet.getString("password")),
						resultSet.getString("mobile")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}


	@Override
	public User fetchSpecific(int id)
	{
		try
		{
			pstmt=con.prepareStatement(FETCH_QUERY);
			pstmt.setInt(1, id);
			
			resultSet=pstmt.executeQuery();
			
			
			
			
			
			userList=extractStudentListFromResultSet(resultSet);
//			u=userList.get(0);
			
//			u=extractStudentListFromResultSet(resultSet).get(0);
			
			if(!userList.isEmpty())
			{
				u=userList.get(0);
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
		return u;
	}


	@Override
	public int update(User s)
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, s.getEmail());
			pstmt.setInt(2, s.getUid());
			
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


	@Override
	public User getUser(String email) {
		try 
		{
			pstmt=con.prepareStatement(SELECT_ON_EMAIL);
			pstmt.setString(1,email);
			
			resultSet=pstmt.executeQuery();
			while(resultSet.next())
			{
				user=new User(
						   resultSet.getInt("uid"),resultSet.getString("username"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("mobile"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}


	public boolean registerUser(User user) {
	    boolean isRegistered = false;


	    try {
	        pstmt = con.prepareStatement(INSERT_QUERY);
	        pstmt.setString(1, user.getUsername());
	        pstmt.setString(2, user.getEmail());
	        pstmt.setString(3, user.getPassword());
	        pstmt.setString(4, user.getMobile());
	        
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            isRegistered = true; // Registration successful if at least one row is affected
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return isRegistered;
	}


	
}