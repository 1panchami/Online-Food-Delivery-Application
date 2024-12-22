package com.foodApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.daoImpl.UserDAOImpl;
import com.foodApp.model.User;
import com.tap.secret.Secret.Encrypt;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = Encrypt.encrypt(req.getParameter("email"));
		String password = Encrypt.encrypt(req.getParameter("password"));
		UserDAOImpl udaoi=new UserDAOImpl();
		User u=udaoi.getUser(email);
		if(u!=null)
		{
			if(u.getPassword() != null&&u.getPassword().equals(password))
			{
				HttpSession session=req.getSession();
				session.setAttribute("loggedInUser",u);
				session.setAttribute("uid", u.getUid()); 
				System.out.print(u.getUid());
				resp.sendRedirect("GetRestaurant");
			}
			else
			{
				resp.sendRedirect("pwdIncorrect.jsp");
			}
		}
		else
		{
			resp.sendRedirect("invalidUser.jsp");
		}
	}
}
