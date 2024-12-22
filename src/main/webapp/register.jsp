<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
/* General Reset */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: Arial, sans-serif;
}

/* Body Styling */
body {
  display: flex;
  justify-content: flex-start; /* Align form to the left */
  align-items: center;
  min-height: 100vh;
  padding-left: 250px; /* Add space from the left edge */
  background-image: url('https://t4.ftcdn.net/jpg/04/05/83/49/360_F_405834980_q7kToQNejjuNc9MVaLvP0yaiD08Z2Kli.jpg'); 
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  background-repeat: no-repeat;
  color: #fff;
}

/* Home Button Styling */
.home-btn {
  position: absolute;
  top: 20px;
  left: 20px;
  padding: 10px;
  background-color: rgba(0, 0, 0, 0.5); /* Transparent black background */
  color: #fff; /* White icon */
  border: 2px solid #fff; /* White border */
  border-radius: 50%;
  font-size: 1.5rem;
  cursor: pointer;
  transition: background-color 0.3s ease, border-color 0.3s ease;
  text-decoration: none;
  display: flex;
  justify-content: center;
  align-items: center;
}

.home-btn:hover {
  background-color: rgba(74, 144, 226, 0.8); /* Blue background on hover */
  border-color: rgba(74, 144, 226, 0.8); /* Blue border on hover */
}

/* Form Container Styling */
.form-container {
  width: 100%;
  max-width: 350px; /* Reduced width */
  padding: 1.5rem; /* Compact height */
  background: rgba(0, 0, 0, 0.4); /* Transparent dark background */
  border-radius: 10px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.37); /* Frosted shadow */
  text-align: center;
  border: 1px solid rgba(255, 255, 255, 0.18); /* Glass effect border */
  backdrop-filter: blur(10px); /* Frosted glass effect */
}

.form-container h2 {
  font-size: 1.8rem; /* Slightly smaller heading */
  color: #f2f2f2; /* Light gray for contrast */
  margin-bottom: 1rem;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.form-container label {
  display: block;
  text-align: left;
  font-weight: bold;
  margin: 0.8rem 0 0.4rem; /* Reduced margins for compactness */
  color: #ccc; /* Soft gray for labels */
}

.form-container input[type="text"],
.form-container input[type="email"],
.form-container input[type="password"],
.form-container input[type="tel"] {
  width: 100%;
  padding: 0.7rem; /* Reduced padding */
  margin-bottom: 0.8rem; /* Reduced margin */
  border: 1px solid rgba(255, 255, 255, 0.4); /* Transparent white border */
  border-radius: 5px;
  font-size: 0.9rem; /* Slightly smaller font size */
  color: #000; /* White text */
  background-color: rgba(255, 255, 255, 0.6); /* Light transparent background */
}

.form-container input:focus {
  outline: none;
  border-color: #aaa; /* Medium gray border on focus */
  box-shadow: 0 0 5px rgba(255, 255, 255, 0.4); /* Subtle glow effect */
}

/* Button Styling */
.form-container button {
  width: 100%;
  padding: 0.7rem; /* Reduced padding */
  background-color: rgba(255, 255, 255, 0.2); /* Semi-transparent button */
  color: #fff; /* White text */
  border: 1px solid rgba(255, 255, 255, 0.4); /* Light border */
  border-radius: 5px;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s;
}

.form-container button:hover {
  background-color: rgba(255, 255, 255, 0.4); /* Brighter on hover */
  transform: scale(1.03); /* Slight zoom effect */
}

/* Responsive Design */
@media (max-width: 500px) {
  body {
    padding-left: 20px; /* Adjust padding for smaller screens */
  }

  .form-container {
    padding: 1rem; /* Adjusted padding for smaller screens */
  }

  .form-container h2 {
    font-size: 1.5rem;
  }
}
</style>
</head>
<body>
  <!-- Home Button -->
  <a href="welcome.jsp" class="home-btn">
    <i class="fas fa-home"></i> <!-- Home icon -->
  </a>

  <!-- Form Container -->
  <div class="form-container">
    <h2>Register</h2>
    <form action="Register">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>
      
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>
      
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>
      
      <label for="confirmPassword">Confirm Password:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" required>
      
      <label for="mobile">Mobile:</label>
      <input type="text" id="mobile" name="mobile" pattern="[0-9]{10}" placeholder="Enter your mobile number" required> 
      
      <button type="submit">Register</button>
    </form>
  </div>
</body>
</html>
