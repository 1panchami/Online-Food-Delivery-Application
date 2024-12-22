<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to FoodFleet</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:wght@400;700&display=swap" rel="stylesheet">
    <style>
        /* Reset CSS */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Lora', serif; /* Changed font family to Lora */
            color: #333;
            scroll-behavior: smooth;
            line-height: 1.8;
        }

        /* Navbar Styling */
        .navbar {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #1C1F26;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            z-index: 100;
        }

        .navbar .logo {
            font-size: 24px;
            font-weight: bold;
            color: white;
        }

        .navbar ul {
            list-style: none;
            display: flex;
        }

        .navbar ul li {
            margin: 0 15px;
        }

        .navbar ul li a {
            text-decoration: none;
            color: white;
            font-size: 18px;
            display: flex;
            align-items: center;
            transition: color 0.3s ease;
        }

        .navbar ul li a:hover {
            color: #87ceeb;
        }

        .navbar ul li a i {
            margin-right: 8px;
            font-size: 20px;
        }

        /* Search Bar Styling */
        .search-bar {
            display: flex;
            align-items: center;
            background-color: white;
            border-radius: 5px;
            padding: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .search-bar input[type="text"] {
            padding: 8px;
            border: none;
            outline: none;
            border-radius: 5px;
            font-size: 16px;
            width: 200px;
        }

        .search-bar button {
            padding: 8px 12px;
            background-color: #4a4a4a;
            border: none;
            color: white;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .search-bar button:hover {
            background-color: #333333;
        }

        /* Home Section */
        .content {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
            background-image: url('https://t4.ftcdn.net/jpg/02/92/20/37/360_F_292203735_CSsyqyS6A4Z9Czd4Msf7qZEhoxjpzZl1.jpg');
            background-size: cover;
            background-position: center;
            height: 660px;
            color: white;
            padding: 20px;
        }

        .content h1 {
            font-size: 50px;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 20px;
        }

        /* Content Sections */
        .content-section {
            padding: 80px 20px;
            margin-top: 50px;
            min-height: 100vh;
        }

        .about,
        .contact {
            max-width: 900px;
            margin: 0 auto;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            color: #333;
            margin-bottom: 80px;
        }

        .about h2,
        .contact h2 {
            text-align: center;
            color: #1C1F26;
            margin-bottom: 20px;
            font-size: 36px;
            font-weight: 700; /* Made heading bold */
        }

        .about p,
        .contact p {
            font-size: 18px;
            line-height: 1.8;
            margin-bottom: 20px;
            color: #555;
            text-align: justify;
        }

        .about p strong,
        .contact p strong {
            font-weight: 600;
        }

        /* Extra Space Between About Section and Content Above */
        #about {
            margin-top: 100px;
        }

        /* Contact Form */
        .contact form label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            font-size: 18px;
        }

        .contact form input,
        .contact form textarea,
        .contact form button {
            width: 100%;
            padding: 12px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .contact form textarea {
            resize: none;
            height: 150px;
        }

        .contact form button {
            background-color: #1C1F26;
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
            margin-top: 15px;
            transition: background-color 0.3s ease;
        }

        .contact form button:hover {
            background-color: #333;
        }

        /* Footer */
        footer {
            background-color: #1C1F26;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        /* Ensure space for the navbar */
        .section-offset {
            padding-top: 70px;
        }
         .navbar .menu-toggle {
            display: none;  /* Hide by default */
            font-size: 30px;
            cursor: pointer;
        }

        @media (max-width: 768px) {
            .navbar ul {
                display: none;
                flex-direction: column;
                width: 100%;
                text-align: center;
            }

            .navbar .menu-toggle {
                display: block;  /* Show on mobile */
            }

            .navbar ul.show {
                display: flex;
            }

            .navbar ul li {
                margin: 10px 0;
            }
    </style>
</head>
<body>
    <!-- Navbar -->
    <div class="navbar">
        <div class="logo">FoodFleet</div>
        <div class="menu-toggle" id="menuToggle">☰</div>
        <ul id="menu">
            <li><a href="#home"><i class="fas fa-home"></i>Home</a></li>
            <li><a href="#about"><i class="fas fa-info-circle"></i>About</a></li>
            <li><a href="#contact"><i class="fas fa-phone-alt"></i>Contact</a></li>
            <li><a href="register.jsp"><i class="fas fa-user-plus"></i>Register</a></li>
            <li><a href="login.jsp"><i class="fas fa-sign-in-alt"></i>Login</a></li>
        </ul>
        <!-- <div class="search-bar">
            <input type="text" placeholder="Search for food...">
            <button><i class="fas fa-search"></i></button>
        </div> -->
    </div>

    <!-- Home Section -->
    <div id="home" class="content">
        <h1>Welcome to FoodFleet</h1>
        <p>Your favorite food, delivered to your doorsteps!</p>
    </div>

    <!-- About Section -->
    <div id="about" class="content-section about section-offset">
        <h2>About Us</h2>
        <p>
            Welcome to <strong>FoodFleet</strong>, your trusted partner in delivering delicious meals to your doorstep! 
            Our mission is to connect food lovers with their favorite restaurants and provide a seamless delivery experience.
        </p>
        <p>
            We offer a wide variety of cuisines, from local specialties to international flavors, ensuring that there is something 
            for everyone. Whether you're craving pizza, sushi, or vegan delights, we've got you covered.
        </p>
        <p>
            Our user-friendly platform allows you to browse menus, customize your orders, and track deliveries in real time. 
            At FoodFleet, we prioritize quality, speed, and customer satisfaction to make every meal special.
        </p>
    </div>

    <!-- Contact Section -->
    <div id="contact" class="content-section contact section-offset">
        <h2>Contact Us</h2>
        <form action="ContactServlet" method="POST">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter your full name" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email address" required>

            <label for="message">Message:</label>
            <textarea id="message" name="message" placeholder="Write your message here..." required></textarea>

            <button type="submit">Send Message</button>
        </form>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 FoodFleet. All Rights Reserved.</p>
    </footer>
    
    <script>
        document.getElementById('menuToggle').addEventListener('click', function() {
            var menu = document.getElementById('menu');
            menu.classList.toggle('show');
        });
    </script>
</body>
</html>
