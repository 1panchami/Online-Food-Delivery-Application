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
import com.foodApp.daoImpl.MenuDAOImpl;
import com.foodApp.model.CartItem;
import com.foodApp.model.Menu;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the cart from the session as a Map, or initialize it if it doesn't exist
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            req.getSession().setAttribute("cart", cart);  // Save back to the session
            System.out.println("Cart is created");
        } else {
            System.out.println("Existing cart is there");
        }

        // Retrieve item details from request
        String menuIdParam = req.getParameter("menuId");
        String quantityParam = req.getParameter("quantity");

        int menuId;
        int quantity;

        try {
            menuId = Integer.parseInt(menuIdParam);
            quantity = Integer.parseInt(quantityParam);
        } catch (NumberFormatException e) {
            resp.sendRedirect("error.jsp");
            return;
        }

        // Fetch menu item details
        MenuDAOImpl mimpl = new MenuDAOImpl();
        Menu menu = mimpl.fetchSpecific(menuId);

        if (menu != null) {
            CartItem cartItem = new CartItem(
                menuId,
                menu.getRestaurantid(),
                menu.getName(),
                quantity,
                menu.getPrice(),
                menu.getImage() // Include the image URL
            );

            CartDAOImpl cdaoi = new CartDAOImpl();
            cart = cdaoi.addItem(cartItem, cart);  // Add item to the existing cart
            req.getSession().setAttribute("cart", cart);  // Save updated cart back to the session
        } else {
            resp.sendRedirect("error.jsp");
            return;
        }

        resp.sendRedirect("cart.jsp");
    }
}
