package com.fooddelivery;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.daoImpl.MenuDAOImpl;
import com.foodApp.model.Menu;

/**
 * Servlet implementation class ShowMenu
 */
@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet {



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = req.getParameter("restID");
		int id = Integer.parseInt(result);
		MenuDAOImpl mimpl = new MenuDAOImpl();
		List<Menu> menuList=mimpl.fetchOnRid(id); 

		HttpSession session = req.getSession();
		session.setAttribute("menuList", menuList);
		resp.sendRedirect("menuAll.jsp");

		
		
		
		
		
		
//		menuList=mimpl.fetchAll(); 
//		resp.sendRedirect("menuAll.jsp");
		 
	}

}
