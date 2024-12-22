package com.foodApp.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.dao.MenuDAO;
import com.foodApp.model.Menu;



public class MenuDAOImpl implements MenuDAO
{
	List<Menu> menuList=new ArrayList<Menu>();
	private final String INSERT_QUERY="insert into `menu`(`restaurantid`,`name`,`description`,`price`,`ratings`) values(?,?,?,?,?)";
	private final String FETCH_ALL_QUERY="select * from `menu`";
	private final String FETCH_QUERY="select * from `menu` where `menuid`=?";
	private final String FETCH_ON_RID="select * from `menu` where `restaurantid`=?";
	private final String UPDATE_QUERY="update `menu` set `name`=? where `menuid`=?";
	private final String DELETE_QUERY="delete from  `menu` where `menuid`=?";
	
	
	private String url="jdbc:mysql://localhost:3306/fooddelivery";
	private String username="root";
	private String password="root";
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	private Menu m;

	public MenuDAOImpl()
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
	public void insert(Menu m) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, m.getRestaurantid());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getDescription());
			pstmt.setInt(4, m.getPrice());
			pstmt.setInt(5, m.getRatings());


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
	public List<Menu> fetchAll() 
	{
		
		try 
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_QUERY);
			menuList=extractStudentListFromResultSet(resultSet);
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return menuList;
	}
	
	List<Menu> extractStudentListFromResultSet( ResultSet resultSet)
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
				
				menuList.add( new Menu(resultSet.getInt("menuid"),
						resultSet.getInt("restaurantid"),
						resultSet.getString("name"),
						resultSet.getString("description"),
						resultSet.getInt("price"),
						resultSet.getInt("ratings"),
						resultSet.getString("image")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}


	@Override
	public Menu fetchSpecific(int id) 
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
				
				
				
			menuList=extractStudentListFromResultSet(resultSet);
//				s=studentList.get(0);
				
//				r=extractStudentListFromResultSet(resultSet).get(0);
				
				
				if(!menuList.isEmpty())
				{
					m=menuList.get(0);
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
		return m;
	}

	
	public List<Menu> fetchOnRid(int id) 
	{
		try
		{
			pstmt=con.prepareStatement(FETCH_ON_RID);
			pstmt.setInt(1, id);
			
			resultSet=pstmt.executeQuery();

			menuList=extractStudentListFromResultSet(resultSet);
			

			
			

		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}
	
	
	
	

	@Override
	public int update(Menu m)
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getMenuid());
			
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

