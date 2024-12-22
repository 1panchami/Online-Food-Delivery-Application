<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.foodApp.model.OrderHistory" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <style>
        /* General body styles */
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f7fc;
            color: #333;
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }

        /* Container for the order history list */
        .container {
            max-width: 1200px;
            margin: 40px auto;
            padding: 30px;
            background-color: #ffffff;
            box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            position: relative; /* Allow absolute positioning of the icon inside */
        }

        /* Restaurant icon (inside the container) */
        .restaurant-icon {
            font-size: 36px;
            color: #1a237e;
            cursor: pointer;
            transition: transform 0.3s ease;
            position: absolute;
            top: 20px;
            left: 20px;
        }

        .restaurant-icon:hover {
            transform: scale(1.1);
        }

        /* Aligning the heading */
        h2 {
            text-align: center;
            font-size: 2.8em;
            color: #2c3e50;
            margin-bottom: 40px;
            padding-bottom: 15px;
            border-bottom: 2px solid #ddd;
        }

        /* Grid for displaying order history blocks */
        .order-history-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
        }

        /* Order history card styles */
        .order-history-card {
            position: relative;
            background-color: #ffffff;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0px 8px 18px rgba(0, 0, 0, 0.12);
            padding: 25px;
            color: #333;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            font-size: 1.1em;
        }

        /* Hover effect on card */
        .order-history-card:hover {
            transform: translateY(-12px);
            box-shadow: 0px 18px 36px rgba(0, 0, 0, 0.15);
        }

        /* Order details text styles */
        .order-history-card p {
            margin: 12px 0;
        }

        .order-history-card p strong {
            color: #1a237e;
            font-weight: 600;
        }

        /* View Details button styles */
        .view-details-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 12px 16px;
            background-color: #1a237e;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .view-details-btn:hover {
            background-color: #0d47a1;
            transform: scale(1.05);
        }

        /* Responsive grid for smaller screens */
        @media (max-width: 1024px) {
            .order-history-grid {
                grid-template-columns: repeat(2, 1fr);
            }
        }

        @media (max-width: 768px) {
            .order-history-grid {
                grid-template-columns: 1fr;
            }
        }

        /* Styling for "No order history available" */
        .no-history {
            text-align: center;
            font-size: 1.3em;
            color: #888;
            margin-top: 30px;
        }

    </style>
    <!-- Font Awesome for the icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

<div class="container">
    <!-- Restaurant Icon (Top Left Corner inside the container) -->
    <a href="home.jsp">
        <i class="fas fa-store restaurant-icon"></i>
    </a>

    <h2>Order History</h2>
    
    <!-- Grid of order history cards -->
    <div class="order-history-grid">
        <% 
            List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("orderHistoryList");
            if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
                for (OrderHistory order : orderHistoryList) { 
        %>
            <div class="order-history-card">
                <!-- Order details -->
                <p><strong>Order ID:</strong> <%= order.getOrderid() %></p>
                <p><strong>Restaurant:</strong> <%= order.getRestaurantname() %></p>
                <p><strong>Amount:</strong> ₹<%= order.getTotal() %></p>
                <p><strong>Status:</strong> <%= order.getStatus() %></p>
                <p><strong>Order Date:</strong> <%= order.getOrderDate() %></p>
                <!-- View Details Button -->
                <a href="ViewOrderDetailsServlet?orderID=<%= order.getOrderid() %>" class="view-details-btn">View Details</a>
            </div>
        <% 
                }
            } else { 
        %>
            <p class="no-history">No order history available.</p>
        <% } %>
    </div>
</div>

</body>
</html>
