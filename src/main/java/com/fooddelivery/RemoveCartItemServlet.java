package com.fooddelivery;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.model.CartItem;

@WebServlet("/RemoveCartItemServlet")
public class RemoveCartItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the cartItemID parameter
        String cartItemIdStr = req.getParameter("cartItemID");
        
        if (cartItemIdStr != null && !cartItemIdStr.isEmpty()) {
            try {
                int cartItemId = Integer.parseInt(cartItemIdStr);
                
                // Retrieve the session
                HttpSession session = req.getSession();
                Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
                
                if (cart != null && cart.containsKey(cartItemId)) {
                    // Remove the item from the cart
                    cart.remove(cartItemId);
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid cartItemID format: " + cartItemIdStr);
            }
        }
        
        // Redirect to cart.jsp to show the updated cart
        resp.sendRedirect("cart.jsp");
    }
}
