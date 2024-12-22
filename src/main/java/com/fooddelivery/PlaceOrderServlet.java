package com.fooddelivery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.database.DatabaseConnection;
import com.foodApp.model.CartItem;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("uid") == null) {
            response.getWriter().println("<script>alert('User not logged in!'); window.location='login.jsp';</script>");
            return;
        }

        Integer uid = (Integer) session.getAttribute("uid");

        // Finalize address
        String addressType = request.getParameter("address");
        String otherAddress = request.getParameter("otherAddress");
        String finalAddress = "home".equals(addressType) ? "Home Address"
                : "office".equals(addressType) ? "Office Address"
                : otherAddress;

        // Get payment mode from the form
        String paymentMode = request.getParameter("paymentMode");  // Add this to your form as <select name="paymentMode">
        if (paymentMode == null || paymentMode.isEmpty()) {
            paymentMode = "Not Provided";  // Default if not selected
        }

        // Fetch cart data from session (assuming it's a HashMap)
        @SuppressWarnings("unchecked")
        HashMap<Integer, CartItem> cartItems = (HashMap<Integer, CartItem>) session.getAttribute("cart");

        if (cartItems == null || cartItems.isEmpty()) {
            response.getWriter().println("<script>alert('Cart is empty!'); window.location='cart.jsp';</script>");
            return;
        }

        // Calculate total amount
        int totalAmount = cartItems.values().stream()
                .mapToInt(item -> item.getQuantity() * item.getPrice())
                .sum();

        Connection connection = null;
        try {
            connection = DatabaseConnection.initializeDatabase();
            connection.setAutoCommit(false); // Start transaction

            // Step 1: Insert into orders table
            String insertOrderQuery = "INSERT INTO orders (uid, menuid, restaurantid, quantity, total_amount, status, payment_mode) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement orderStmt = connection.prepareStatement(insertOrderQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            CartItem firstItem = cartItems.values().iterator().next(); // Fetch the first item
            int restaurantId = firstItem.getRestId();
            int totalQuantity = cartItems.values().stream().mapToInt(CartItem::getQuantity).sum();

            orderStmt.setInt(1, uid);
            orderStmt.setInt(2, firstItem.getItemId()); // Use the first item's menu ID for reference
            orderStmt.setInt(3, restaurantId);
            orderStmt.setInt(4, totalQuantity);
            orderStmt.setInt(5, totalAmount);
            orderStmt.setString(6, "Order Placed");
            orderStmt.setString(7, paymentMode);  // Store the payment mode in the orders table
            orderStmt.executeUpdate();

            ResultSet orderKeys = orderStmt.getGeneratedKeys();
            orderKeys.next();
            int orderId = orderKeys.getInt(1); // Get the generated order ID

            // Step 2: Insert into orderitems table
            String insertOrderItemsQuery = "INSERT INTO orderitems (orderid, menuid, quantity, item_total) VALUES (?, ?, ?, ?)";
            PreparedStatement orderItemsStmt = connection.prepareStatement(insertOrderItemsQuery);

            for (CartItem item : cartItems.values()) {
                orderItemsStmt.setInt(1, orderId);
                orderItemsStmt.setInt(2, item.getItemId());
                orderItemsStmt.setInt(3, item.getQuantity());
                orderItemsStmt.setInt(4, item.getQuantity() * item.getPrice());
                orderItemsStmt.addBatch();
            }
            orderItemsStmt.executeBatch();

            // Step 3: Insert into orderhistory table
            String insertOrderHistoryQuery = "INSERT INTO orderhistory (orderid, uid, restaurantid, total, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement orderHistoryStmt = connection.prepareStatement(insertOrderHistoryQuery);
            orderHistoryStmt.setInt(1, orderId);
            orderHistoryStmt.setInt(2, uid);
            orderHistoryStmt.setInt(3, restaurantId);
            orderHistoryStmt.setInt(4, totalAmount);
            orderHistoryStmt.setString(5, "Order Placed");
            orderHistoryStmt.executeUpdate();

            connection.commit(); // Commit transaction

            // Clear cart items from session
            session.setAttribute("cart", null);

            // Send success response
            response.getWriter().println("<script>alert('Order placed successfully!'); window.location='ordersuccess.jsp';</script>");
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            response.getWriter().println("<script>alert('Error placing the order.');</script>");
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
