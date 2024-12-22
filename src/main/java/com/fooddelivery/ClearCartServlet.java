package com.fooddelivery;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.model.CartItem;

/**
 * Servlet implementation class ClearCartServlet
 */
@WebServlet("/ClearCartServlet")
public class ClearCartServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the current cart from the session
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");

        // Check if the cart exists in the session
        if (cart != null) {
            cart.clear(); // Clear all items from the cart
            req.getSession().setAttribute("cart", cart); // Update the session with the cleared cart
        }

        // Redirect to the cart page or any other page after clearing the cart
        resp.sendRedirect("cart.jsp");
    }
}
