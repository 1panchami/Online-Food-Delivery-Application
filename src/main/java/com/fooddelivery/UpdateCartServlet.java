package com.fooddelivery;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodApp.daoImpl.CartDAOImpl;
import com.foodApp.model.CartItem;
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the cart from the session; initialize it if it's not already present
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();  // Initialize a new cart
            req.getSession().setAttribute("cart", cart);  // Save it back to the session
        }

        int cartItemId;
        int quantity;

        try {
            // Retrieve and parse parameters
            String cartItemIdParam = req.getParameter("cartItemID");
            String quantityParam = req.getParameter("quantity");

            // Debug: Print the parameter values to the server logs
            System.out.println("cartItemID (raw param): " + cartItemIdParam);
            System.out.println("quantity (raw param): " + quantityParam);

            // Check if parameters are null or empty
            if (cartItemIdParam == null || cartItemIdParam.isEmpty() || quantityParam == null || quantityParam.isEmpty()) {
                throw new NumberFormatException("Empty parameter");
            }

            // Parse parameters
            cartItemId = Integer.parseInt(cartItemIdParam);
            quantity = Integer.parseInt(quantityParam);

            // Debug: Print the parsed values
            System.out.println("cartItemID (parsed): " + cartItemId);
            System.out.println("quantity (parsed): " + quantity);

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
            resp.sendRedirect("error.jsp");  // Redirect to an error page if parsing fails
            return;
        }

        // Use CartDAOImpl to update the item in the cart
        CartDAOImpl cdaoi = new CartDAOImpl();

        // Debug: Log the cart contents before updating
        System.out.println("Cart contents before update: " + cart);

        // Update the cart using the updateItem method from DAO
        cart = cdaoi.updateItem(cart, cartItemId, quantity);

        // Check if the update was successful
        if (cart == null) {
            // If update fails, redirect to an error page
            resp.sendRedirect("error.jsp");
            return;
        }

        // Save the updated cart back to the session
        req.getSession().setAttribute("cart", cart);

        // Redirect to the cart page to display the updated cart
        resp.sendRedirect("cart.jsp");
    }
}
