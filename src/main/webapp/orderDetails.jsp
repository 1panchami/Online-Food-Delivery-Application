<%@ page import="java.util.List" %>
<%@ page import="com.foodApp.model.CartItem" %>
<%@ page import="com.foodApp.model.OrderHistory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>
    <style>
        /* Container for the entire order details */
        .container {
            max-width: 800px; /* Adjusted container width for better experience */
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            position: relative; /* Allow absolute positioning of the icon inside */
        }

        /* Restaurant Icon (inside the container) */
        .restaurant-icon {
            font-size: 27px;
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

        /* Center the heading */
        h2 {
            text-align: center;
            font-size: 2.5em;
            color: #333;
            margin-bottom: 20px;
            padding: 10px;
            background-color: #e8f0fe;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }

        /* Order details section */
        .order-details {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
            margin-bottom: 25px;
        }

        /* Order info */
        .order-info p {
            font-size: 1.2em;
            margin: 10px 0;
        }

        .order-info p strong {
            color: #2c3e50;
        }

        /* Styling for the total amount */
        .total-amount {
            font-size: 1.4em;
            color: #1a237e;
            font-weight: bold;
            margin-top: 10px;
        }

        /* Order items section */
        h3 {
            font-size: 1.8em;
            color: #2c3e50;
            margin-bottom: 15px;
            padding-bottom: 5px;
            border-bottom: 2px solid #ddd;
        }

        .order-item-block {
            background-color: #f8f8f8;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 1px 6px rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: center;
            justify-content: flex-start; /* Ensure items are aligned left */
        }

        /* Image styling for order items */
        .order-item-block img {
            width: 150px; /* Set a smaller image size for better balance */
            height: 150px; /* Set a smaller image size for better balance */
            border-radius: 8px;
            object-fit: cover;
            margin-right: 20px;
        }

        /* Order item details styling */
        .order-item-block div {
            flex: 1;
            padding-left: 20px; /* Space between image and text */
        }

        .order-item-block p {
            margin: 10px 0;
            font-size: 1.2em; /* Increased font size for better visibility */
            color: #555;
        }

        .order-item-block p strong {
            color: #333;
        }

        /* Styling for empty order items message */
        .no-items-message {
            font-size: 1.2em;
            color: #e53935;
            text-align: center;
            margin-top: 20px;
        }

        /* Responsive styling */
        @media (max-width: 768px) {
            .container {
                padding: 15px;
                width: 95%;
            }

            h2 {
                font-size: 2em;
            }

            .order-item-block {
                flex-direction: column;
                align-items: flex-start;
            }

            .order-item-block img {
                margin-bottom: 10px;
            }

            .order-item-block div {
                padding-left: 0; /* Remove left padding for smaller screens */
            }
        }
         .nav-btn {
    position: absolute; /* Position the button relative to the container */
    top: 10px; /* Distance from the top of the container */
    left: 20px; /* Distance from the left of the container */
    padding: 4px 10px;
    background-color: #005a87;
    color: white;
    border: none;
    border-radius: 5px;
    text-decoration: none;
    font-size: 12px;
    height: 30px;
    display: flex;
    justify-content: center; /* Center-align text horizontally */
    align-items: center; /* Center-align text vertically */
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.nav-btn:hover {
    background-color: #0073a6;
}

    </style>
    <!-- Font Awesome for the icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

<div class="container">
    <!-- Restaurant Icon (Top Left Corner inside the container) -->
    
        
	<a href="orderHistory.jsp" class="nav-btn">Previous</a>
    

    <h2>Order Details</h2>

    

    <!-- Order Items Section -->
    <h3>Order Items</h3>
    <% 
        List<CartItem> orderItems = (List<CartItem>) request.getAttribute("orderItems");
        if (orderItems != null && !orderItems.isEmpty()) {
            for (CartItem item : orderItems) {
    %>
        <div class="order-item-block">
            <img src="<%= item.getImage() %>" alt="<%= item.getName() %>">
            <div>
                <p><strong>Item:</strong> <%= item.getName() %></p>
                <p><strong>Quantity:</strong> <%= item.getQuantity() %></p>
                <p><strong>Price:</strong> ₹<%= item.getPrice() %></p>
            </div>
        </div>
    <% 
            }
        } else {
    %>
        <p class="no-items-message">No items found for this order.</p>
    <% } %>

    
</div>

</body>
</html>
