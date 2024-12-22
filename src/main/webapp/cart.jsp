<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.model.CartItem"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>
/* Existing Styles for Cart */
.cart-container {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background-color: #f0f4f7;
	border-radius: 10px;
	box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
	font-family: 'Arial', sans-serif;
	color: #333;
	border-top: 5px solid #6c757d;
	position: relative;
	max-height: 600px; /* Increase max height */
	overflow-y: auto; /* Add scroll if content overflows */
}

/* Styling each cart item */

/* Item details */

/* Total price styling */
.cart-item p .total-price {
	color: #d9534f;
	font-weight: bold;
	font-size: 1.1em;
}
 /* Button styling */
 .btn {
     background-color: #28a745;
     color: white;
     padding: 10px 15px;
     border: none;
     border-radius: 5px;
     cursor: pointer;
     font-size: 1em;
     font-weight: 600;
     transition: background-color 0.3s ease, transform 0.1s ease;
     margin-top: 10px;
     border: 1px solid #218838;
     text-align: center;
 }
 .btn:hover {
     background-color: #218838;
     transform: scale(1.05);
 }
 .btn:focus {
     outline: none;
 }

 .btn-remove {
     background-color: #dc3545;
     border: 1px solid #c82333;
 }

 .btn-remove:hover {
     background-color: #c82333;
 }
 /* Buttons container */
 .cart-item .button-container {
     display: flex;
     justify-content: space-around;
     align-items: center;
     margin-top: 15px;
 }
 /* Empty cart message */
 .empty-cart-message {
     text-align: center;
     color: #777;
     font-style: italic;
     font-size: 1.2em;
     margin-top: 20px;
 }
 /* Cart footer for total amount */
 .cart-footer {
     text-align: right;
     font-size: 1.2em;
     font-weight: bold;
     margin-top: 20px;
     padding-top: 15px;
     border-top: 2px solid #ddd;
     color: #333;
     background-color: #f9f9f9;
 }
 /* Heading Styling */
 .cart-container h1 {
     font-size: 1.8em;
     color: #495057;
     text-align: center;
     margin-bottom: 20px;
     font-weight: 700;
 }
 /* Clear Cart button at top-right */
 .clear-btn {
     position: absolute;
     top: 35px;
     right: 60px;
     background-color: #ff5733;
     color: white;
     padding: 10px 15px;
     border: none;
     border-radius: 5px;
     cursor: pointer;
     font-size: 1em;
     font-weight: 600;
     transition: background-color 0.3s ease, transform 0.1s ease;
     text-decoration: none;
 }

 .clear-btn:hover {
     background-color: #e64528;
     transform: scale(1.05);
 }

.header {
    display: flex;
    justify-content: space-between; /* Ensure space between Home and Previous buttons */
    align-items: center; /* Vertically center the items */
    margin-bottom: 20px;
    padding: 10px 0;
}

.navigation-buttons {
    display: flex;
    justify-content: flex-start; /* Align buttons to the left */
    gap: 10px; /* Space between buttons */
    align-items: center; /* Vertically center the buttons */
}

.home-icon {
    font-size: 20px;
    color: white;
    background-color: #005a87;
    padding: 8px;
    border-radius: 50%;
    text-decoration: none;
    display: inline-block;
    margin-right: 10px; /* Add space between home and previous buttons */
    transition: background-color 0.3s ease;
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

.nav-btn:focus {
    outline: none; /* Removes focus outline */
}

 .cart-items {
     display: flex;
     background-color: #f5f5f5;
     padding: 20px;
     margin-bottom: 20px;
     border-radius: 12px;
     box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
 }

 /* Image styling */
 .cart-items img {
     width: 180px;
     height: 180px;
     border-radius: 8px;
     margin-right: 20px;
     object-fit: cover;
 }

 .cart-item {
     flex: 1;
 }

 /* Text styling within item */
 .cart-item p {
     margin: 5px 0;
     line-height: 1.6;
 }

 /* Text styling within item */
 .cart-item p strong {
     color: #222; /* Darker shade for better contrast */
     font-weight: 600; /* Increased weight */
 }

 .checkout-btn-container {
     text-align: center; /* Center the button horizontally */
   
     margin-top: 20px;   /* Space between total amount and button */
 }
 .check
 {
 background-color: #343a40;
     color: white;
     padding: 10px 15px;
     border: none;
     border-radius: 5px;
     cursor: pointer;
     font-size: 1em;
     font-weight: 600;
     transition: background-color 0.3s ease, transform 0.1s ease;
     margin-top: 10px;
     border: 1px solid #218838;
     text-align: center;
 }
 

 .home-icon:hover {
     background-color: #004c74;
 }

 .home-icon i {
     font-size: 24px;
 }

</style>
</head>
<body>
	<div class="cart-container">
		<div class="header">
			<div class="navigation-buttons">
			<a href="welcome.jsp" class="home-icon">
			<i class="fas fa-home"></i> <!-- Font Awesome home icon -->
		</a>
				<a href="menuAll.jsp" class="nav-btn">Previous</a>
			</div>

			<a href="ClearCartServlet" class="clear-btn">Clear Cart</a>
		</div>

		<!-- Home Icon -->
		

		<h1>Your Cart</h1>

		<% 
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        double totalAmount = 0.0;
        
        if (cart != null && !cart.isEmpty()) {
            for (CartItem item : cart.values()) { 
                totalAmount += item.getQuantity() * item.getPrice();
    %>
		<!-- Form for each cart item to submit cartItemID and selected quantity -->
		<div class="cart-items">
			<img src="<%= item.getImage() %>" alt="<%= item.getName() %>">
			<form action="UpdateCartServlet" method="post" class="cart-item">
				<p>
					<strong>Item ID:</strong>
					<%= item.getItemId() %></p>
				<p>
					<strong>Name:</strong>
					<%= item.getName() %></p>
				<p>
					<strong>Price:</strong> ₹<%= item.getPrice() %></p>
				<p>
					<strong>Total:</strong> <span class="total-price">₹<%= item.getQuantity() * item.getPrice() %></span>
				</p>

				<!-- Dropdown for Quantity -->
				<p>
					<strong>Quantity:</strong> <select name="quantity">
						<% for (int i = 1; i <= 10; i++) { %>
						<option value="<%= i %>"
							<%= (i == item.getQuantity() ? "selected" : "") %>><%= i %></option>
						<% } %>
					</select>
				</p>

				<!-- Hidden input for cartItemID -->
				<input type="hidden" name="cartItemID"
					value="<%= item.getItemId() %>">

				<div class="button-container">
					<button type="submit" class="btn">Update</button>
					<a href="RemoveCartItemServlet?cartItemID=<%= item.getItemId() %>">
						<button type="button" class="btn btn-remove">Remove</button>
					</a>
				</div>
			</form>
		</div>
		<% 
            }
    %>

		<div class="cart-footer">
			<p>
				Total Cart Amount: ₹<%= totalAmount %></p>
		</div>
		<div class="checkout-btn-container">
			<a href="checkout.jsp">
				<button class="check">Checkout</button>
			</a>
		</div>

		<% 
        } else { 
    %>
		<p class="empty-cart-message">Your cart is empty.</p>
		<% } %>
	</div>

</body>
</html>
