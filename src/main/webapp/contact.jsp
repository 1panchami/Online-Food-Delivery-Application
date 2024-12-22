<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - FoodFleet</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4; /* Light gray background */
            color: #333;
        }

        .container {
            padding: 20px 40px;
            max-width: 600px;
            margin: 50px auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #1C1F26; /* Dark theme color */
            margin-bottom: 20px;
        }

        form label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #555;
        }

        form input,
        form textarea,
        form button {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        form textarea {
            resize: none;
            height: 100px;
        }

        form button {
            background-color: #1C1F26; /* Dark color */
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
            margin-top: 15px;
            transition: background-color 0.3s ease;
        }

        form button:hover {
            background-color: #333; /* Darker color */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Contact Us</h1>
        <form action="ContactServlet" method="POST">
            <label for="name">Your Name</label>
            <input type="text" id="name" name="name" placeholder="Enter your name" required>

            <label for="email">Your Email</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="message">Your Message</label>
            <textarea id="message" name="message" placeholder="Type your message here..." required></textarea>

            <button type="submit">Send Message</button>
        </form>
    </div>
</body>
</html>
