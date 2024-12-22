<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmation</title>
    <link href="https://fonts.googleapis.com/css2?family=Lora:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Lora', serif;
            color: #333;
            text-align: center;
            line-height: 1.8;
            padding: 50px;
        }

        .confirmation-message {
            max-width: 600px;
            margin: 0 auto;
            padding: 30px;
            background-color: #f4f4f4;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .confirmation-message h2 {
            font-size: 36px;
            color: #1C1F26;
            margin-bottom: 20px;
        }

        .confirmation-message p {
            font-size: 18px;
            color: #555;
        }

        .back-button {
            display: inline-block;
            padding: 12px 25px;
            background-color: #1C1F26;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            margin-top: 20px;
            cursor: pointer;
        }

        .back-button:hover {
            background-color: #333;
        }
    </style>
</head>
<body>

    <!-- Confirmation Message -->
    <div class="confirmation-message">
        <h2>Thank You for Contacting Us!</h2>
        <p>We have received your message and will get back to you as soon as possible.</p>
        <p>We appreciate your feedback and will address any concerns you may have.</p>

        <a href="welcome.jsp" class="back-button">Go back to home</a>
    </div>

</body>
</html>
