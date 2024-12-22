<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
        }
        .success-container {
            text-align: center;
            color: #28a745;
            background-color: #fff;
            padding: 40px 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            animation: fadeIn 1s ease-in-out;
        }
        .circle {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            border: 5px solid #28a745;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto 20px;
            animation: popIn 0.5s ease-in-out;
        }
        .checkmark {
            font-size: 60px;
            font-weight: bold;
        }
        .message {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            animation: fadeUp 1s ease-in-out;
        }
        .button-container {
            animation: fadeUp 1s ease-in-out 1s;
        }
        .button-container a {
            text-decoration: none;
            display: inline-block;
            padding: 12px 25px;
            margin: 10px;
            background-color: #28a745;
            color: #fff;
            border-radius: 5px;
            font-size: 18px;
            font-weight: bold;
            transition: background-color 0.3s, transform 0.2s;
        }
        .button-container a:hover {
            background-color: #218838;
            transform: scale(1.05);
        }
        @keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }
        @keyframes popIn {
            0% {
                transform: scale(0.5);
                opacity: 0;
            }
            100% {
                transform: scale(1);
                opacity: 1;
            }
        }
        @keyframes fadeUp {
            0% {
                opacity: 0;
                transform: translateY(30px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="success-container">
        <div class="circle">
            <div class="checkmark">✔</div>
        </div>
        <div class="message">Order Placed Successfully!</div>
        <div class="button-container">
            <a href="home.jsp">Back to Home</a>
            <a href="menuAll.jsp">Order More</a>
        </div>
    </div>
</body>
</html>
