package com.fooddelivery;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.daoImpl.OrderHistoryDAOImpl;
import com.foodApp.model.OrderHistory;
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid"); // Assumes userID is stored in session
        
        OrderHistoryDAOImpl orderHistoryDAO = new OrderHistoryDAOImpl();
        List<OrderHistory> orderHistoryList = orderHistoryDAO.getOrderHistoryByUserID(uid);
        
        // Set data in session
        session.setAttribute("orderHistoryList", orderHistoryList);

        // Redirect to JSP
        response.sendRedirect("orderHistory.jsp");
    }
}
