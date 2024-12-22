package com.foodApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.daoImpl.UserDAOImpl;
import com.foodApp.model.User;
import com.tap.secret.Secret.Encrypt;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = Encrypt.encrypt(req.getParameter("username"));
		String email = Encrypt.encrypt(req.getParameter("email"));
		String password = Encrypt.encrypt(req.getParameter("password"));
		String confirmPassword = Encrypt.encrypt(req.getParameter("confirmPassword"));
		
		String mobile = Encrypt.encrypt(req.getParameter("mobile"));
		

		if(password.equals(confirmPassword)) {
			UserDAOImpl udaoi = new UserDAOImpl();
			User existingUser = udaoi.getUser(email);

			
			if(existingUser == null) {
				
				User newUser = new User();
				newUser.setUsername(username);
				newUser.setEmail(email);
				newUser.setPassword(password);
				newUser.setMobile(mobile);

			
				boolean isRegistered = udaoi.registerUser(newUser);
				if(isRegistered) {
					resp.sendRedirect("login.jsp"); 
				} else {
					resp.sendRedirect("registerFailed.jsp"); 
				}
			} else {
				resp.sendRedirect("userExists.jsp");
			}
		} else {
			resp.sendRedirect("pwdIncorrect.jsp"); 
		}
	}
}
