<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Roboto', sans-serif; /* Modern font */
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-image: url('https://png.pngtree.com/thumb_back/fw800/background/20240405/pngtree-asian-food-background-with-various-ingredients-on-rustic-stone-image_15700117.jpg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  position: relative;
}

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

.form-container {
  width: 100%;
  max-width: 400px;
  padding: 2.5rem;
  background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black background */
  border-radius: 15px;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
  text-align: center;
  color: #fff;
  height: 400px; /* Reduced height */
  margin-top: 100px; /* Push the container lower */
  backdrop-filter: blur(8px); /* Optional blur effect */
}

.form-container h2 {
  font-size: 1.8rem;
  margin-bottom: 1.5rem;
}

.form-container label {
  display: block;
  text-align: left;
  font-weight: bold;
  margin: 1rem 0 0.5rem;
  color: #fff;
}

.form-container input[type="text"],
.form-container input[type="email"],
.form-container input[type="password"] {
  width: 100%;
  padding: 0.8rem;
  margin-bottom: 1rem;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 1rem;
  color: #333;
  background-color: rgba(255, 255, 255, 0.9); /* Slightly transparent white background */
}

.form-container input[type="text"]:focus,
.form-container input[type="email"]:focus,
.form-container input[type="password"]:focus {
  outline: none;
  border-color: #4a90e2;
  box-shadow: 0 0 5px rgba(74, 144, 226, 0.5);
}

.form-container button {
  width: 100%;
  padding: 0.8rem;
  background-color: #4a90e2; /* Bright blue */
  color: #ffffff; /* White text */
  border: none;
  border-radius: 5px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.form-container button:hover {
  background-color: #357abd; /* Darker blue on hover */
}

@media (max-width: 500px) {
  .form-container {
    padding: 1.5rem;
  }
}

</style>
<!-- Font Awesome for Home Icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>

<a href="welcome.jsp" class="home-btn">
  <i class="fas fa-home"></i> <!-- Home icon -->
</a>

<div class="form-container">
    <h2>Login</h2>
    <form action="Login">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" placeholder="Enter your email" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>
