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
import com.foodApp.daoImpl.OrdersDAOImpl;
import com.foodApp.model.CartItem;
import com.foodApp.model.OrderHistory;
@WebServlet("/ViewOrderDetailsServlet")
public class ViewOrderDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get orderId from query parameter
        int orderId = Integer.parseInt(request.getParameter("orderID"));

        // Initialize DAOs
        OrderHistoryDAOImpl orderHistoryDAO = new OrderHistoryDAOImpl();
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();

        // Fetch the order details
        

        // Fetch order items associated with the orderId
        List<CartItem> orderItems = ordersDAO.getOrderItemsByOrderId(orderId);

        HttpSession session = request.getSession();
        OrderHistory orderHistory = orderHistoryDAO.fetchSpecifics(orderId);
        System.out.print(orderHistory);
        session.setAttribute("orderHistory", orderHistory);  // Set the object in the session

        // Set data in request
        
        request.setAttribute("orderItems", orderItems);

        // Forward to the order details JSP
        request.getRequestDispatcher("orderDetails.jsp").forward(request, response);
    }
}
