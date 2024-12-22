<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.model.Menu" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Menu Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>
    /* Import Google Fonts */
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');

    /* Basic styling */
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f9fbfd;
        color: #333;
        margin: 0;
        padding: 0;
    }

    /* Header styling */
    .header {
        display: flex;
        justify-content: space-between; /* Align items to both ends */
        align-items: center; /* Vertically align the items */
        margin-bottom: 20px;
        padding: 10px 20px;
    }

    /* Navigation buttons container */
    .navigation-buttons {
        display: flex;
        align-items: center; /* Align items vertically centered */
        gap: 10px; /* Add spacing between the buttons */
    }

    .nav-btn {
        padding: 4px 10px;
        background-color: #005a87;
        color: white;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        font-size: 12px;
        height: 30px;
        display: flex;
        justify-content: center;
        align-items: center;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .nav-btn:hover {
        background-color: #0073a6;
    }

    /* Home icon styling */
    .home-icon {
        font-size: 14px;
        color: white;
        background-color: #005a87;
        padding: 8px;
        border-radius: 50%;
        text-decoration: none;
        display: inline-block;
        transition: background-color 0.3s ease;
    }

    .home-icon:hover {
        background-color: #004c74;
    }

    .home-icon i {
        font-size: 18px;
    }

    /* Main container */
    .container {
        max-width: 800px;
        margin: 30px auto;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }

    /* Welcome message */
    .welcome-message {
        font-size: 2em;
        margin-bottom: 20px;
        text-align: center;
        color: #333;
        font-weight: 700;
    }

    /* Single column for menu items */
    .menu-item {
        display: flex;
        background-color: #f5f5f5;
        padding: 20px;
        margin-bottom: 20px;
        border-radius: 12px;
        box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
    }

    /* Image styling */
    .menu-item img {
        width: 180px;
        height: 180px;
        border-radius: 8px;
        margin-right: 20px;
        object-fit: cover;
    }

    /* Text container styling */
    .menu-details {
        flex: 1;
    }

    /* Text styling within item */
    .menu-details p {
        margin: 5px 0;
        line-height: 1.6;
    }

    .menu-details p strong {
        color: #222; /* Darker shade for better contrast */
        font-weight: 600;
    }

    /* Button styling */
    .btn {
        background-color: #005a87;
        color: white;
        padding: 10px 18px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 1em;
        font-weight: 500;
        text-transform: uppercase;
        transition: background-color 0.3s ease;
    }

    .btn:hover {
        background-color: #0073a6;
    }

    /* Dropdown styling */
    .quantity-select {
        font-size: 1em;
        padding: 8px;
        border-radius: 6px;
        border: 1px solid #ccc;
        margin-left: 10px;
        background-color: #ffffff;
        font-weight: 500;
    }
</style>
</head>
<body>

<div class="container">
    <div class="header">
        <div class="navigation-buttons">
            <a href="welcome.jsp" class="home-icon">
                <i class="fas fa-home"></i> <!-- Font Awesome home icon -->
            </a>
            <a href="home.jsp" class="nav-btn">Previous</a>
        </div>
    </div>
    <h1 class="welcome-message">Our Menu</h1>

    <% 
        ArrayList<Menu> mList = (ArrayList<Menu>) session.getAttribute("menuList");
        if (mList != null) {
            for (Menu res : mList) { 
    %>
    <div class="menu-item">
        <img src="<%= res.getImage() %>" alt="<%= res.getName() %>">
        <div class="menu-details">
            <p><strong>Menu ID:</strong> <%= res.getMenuid() %></p>
            <p><strong>Restaurant ID:</strong> <%= res.getRestaurantid() %></p>
            <p><strong>Name:</strong> <%= res.getName() %></p>
            <p><strong>Description:</strong> <%= res.getDescription() %></p>
            <p><strong>Price:</strong> ₹<%= res.getPrice() %></p>
            <p><strong>Ratings:</strong> <%= res.getRatings() %> ★</p>

            <!-- Quantity Dropdown and Add to Cart Button -->
            <form action="CartServlet" method="GET">
                <input type="hidden" name="menuId" value="<%= res.getMenuid() %>">
                <label for="quantity">Quantity:</label>
                <select name="quantity" class="quantity-select">
                    <% for (int i = 1; i <= 10; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                <input type="submit" class="btn" value="Add to Cart">
            </form>
        </div>
    </div>
    <% 
            }
        } else { 
    %>
        <p>No Menus available to display.</p>
    <% } %>
</div>

</body>
</html>
