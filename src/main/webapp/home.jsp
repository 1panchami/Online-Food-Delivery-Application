<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foodApp.model.Restaurant" %>
<%@ page import="com.tap.secret.Secret.Decrypt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');

    /* Global Styles */
    body {
        font-family: 'Poppins', sans-serif;
        background-color: #f0f4f8;
        color: #333;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 1200px;
        margin: 20px auto;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
        padding: 10px 0;
    }

    .navigation-buttons {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    .nav-btn, .home-icon {
        padding: 8px 14px;
        background-color: #1a237e;
        color: white;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        font-size: 14px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .nav-btn:hover, .home-icon:hover {
        background-color: #0056b3;
    }

    .home-icon {
        font-size: 18px;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 10px;
        border-radius: 50%;
        background-color: #1a237e;
        transition: background-color 0.3s ease;
    }

    .home-icon:hover {
        background-color: #0056b3;
    }

    .go-to-cart {
        background-color: #1a237e;
        color: white;
        padding: 8px 14px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 14px;
        font-weight: 600;
        text-decoration: none;
        transition: background-color 0.2s ease;
    }

    .go-to-cart:hover {
        background-color: #0d47a1;
    }

    /* Welcome message */
    .welcome-message {
        font-size: 1.8em;
        margin-bottom: 20px;
        text-align: center;
        color: #333;
        font-weight: 600;
    }

    /* Restaurant Grid */
    .restaurant-grid {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 20px;
    }

    .restaurant-card {
        background-color: #ffffff;
        border-radius: 12px;
        overflow: hidden;
        box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s ease-in-out;
        color: #333;
        font-size: 0.9em;
    }

    .restaurant-card img {
        width: 100%;
        height: 200px;
        object-fit: cover;
    }

    .card-content {
        padding: 15px;
    }

    .restaurant-card p {
        margin: 5px 0;
        line-height: 1.5;
    }

    .restaurant-card p strong {
        color: #1a237e;
    }

    .btn {
        background-color: #1a237e;
        color: white;
        padding: 8px 14px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 0.9em;
        text-transform: uppercase;
        font-weight: 600;
        margin-top: 10px;
        transition: background-color 0.2s ease;
        display: block;
        text-align: center;
        text-decoration: none;
    }

    .btn:hover {
        background-color: #0d47a1;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .restaurant-grid {
            grid-template-columns: repeat(2, 1fr);
        }
    }

    @media (max-width: 480px) {
        .restaurant-grid {
            grid-template-columns: 1fr;
        }
    }
</style>
<!-- Font Awesome for Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>

<% User user = (User) session.getAttribute("loggedInUser"); %>

<div class="container">
    <div class="header">
        <div class="navigation-buttons">
            <!-- Home Icon -->
            <a href="welcome.jsp" class="home-icon">
                <i class="fas fa-home"></i>
            </a>
            <!-- Previous Button -->
            <a href="login.jsp" class="nav-btn">Previous</a>
        </div>
        <div class="navigation-buttons">
        <!-- Order History Button -->
        <a href="OrderHistoryServlet" class="go-to-cart">
            <i class="fas fa-history"></i> Order History
        </a>
        <!-- Go to Cart Button -->
        <a href="cart.jsp" class="go-to-cart">
            <i class="fas fa-shopping-cart"></i> Go to Cart
        </a>
    </div>
    </div>

    <div class="welcome-message">
        Welcome, <strong><%= Decrypt.decrypt(user.getUsername()) %></strong>!
    </div>

    <div class="restaurant-grid">
        <% 
            ArrayList<Restaurant> rList = (ArrayList<Restaurant>) session.getAttribute("resturantList");
            if (rList != null) {
                for (Restaurant res : rList) { 
        %>
            <div class="restaurant-card">
                <!-- Display restaurant image -->
                <img src="<%= res.getImage() %>" alt="<%= res.getName() %>">

                <!-- Display restaurant details -->
                <div class="card-content">
                    <p><strong>ID:</strong> <% out.println(res.getRestaurantid()); %></p>
                    <p><strong>Name:</strong> <% out.println(res.getName()); %></p>
                    <p><strong>Cuisine Type:</strong> <% out.println(res.getCusineType()); %></p>
                    <p><strong>Address:</strong> <% out.println(res.getAddress()); %></p>
                    <p><strong>Ratings:</strong> <% out.println(res.getRatings()); %></p>

                    <!-- View Menu button -->
                    <a href="ShowMenu?restID=<%= res.getRestaurantid() %>" class="btn">View Menu</a>
                </div>
            </div>
        <% 
                }
            } else { 
        %>
            <p>No restaurants available to display.</p>
        <% } %>
    </div>
</div>

</body>
</html>
