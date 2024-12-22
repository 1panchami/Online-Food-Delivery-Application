package com.fooddelivery;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.daoImpl.RestaurantDAOImpl;
import com.foodApp.model.Restaurant;


@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet 
{
	
private List<Restaurant> resturantList;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	RestaurantDAOImpl rdimpl=new RestaurantDAOImpl();
	resturantList=rdimpl.fetchAll();
	req.getSession().setAttribute("resturantList", resturantList);
	resp.sendRedirect("home.jsp");
}
}
