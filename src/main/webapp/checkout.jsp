<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout Page</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7f9;
            margin: 0;
            padding: 0;
        }

        .checkout-container {
            max-width: 900px;
            margin: 30px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            color: #333;
        }

        h1 {
            text-align: center;
            color: #495057;
            font-size: 2em;
            margin-bottom: 20px;
        }

        .section-title {
            font-size: 1.3em;
            font-weight: bold;
            margin-top: 20px;
            color: #6c757d;
        }

        .radio-group {
            margin: 15px 0;
            display: flex;
            flex-direction: column; /* Ensure radio buttons are stacked vertically */
        }

        .radio-group label {
            margin-bottom: 10px;
            font-size: 1.1em;
            cursor: pointer;
        }

        .radio-group input[type="radio"] {
            margin-right: 10px;
        }

        .address-textarea {
            width: 100%;
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 15px;
            resize: vertical; /* Allow vertical resizing */
            display: none;
        }

        .place-order-btn {
            display: block;
            width: 100%;
            background-color: #007bff;
            color: white;
            padding: 15px;
            font-size: 1.2em;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            transition: background-color 0.3s ease;
        }

        .place-order-btn:hover {
            background-color: #0056b3;
        }

        .place-order-btn:focus {
            outline: none;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .checkout-container {
                padding: 15px;
            }
        }

        .payment-icons label {
            font-size: 1.1em;
            cursor: pointer;
            margin-bottom: 10px;
        }

        .payment-icons input[type="radio"] {
            margin-right: 10px;
        }

        .payment-icons i {
            margin-right: 10px;
        }
        .payment-icons {
        display:flex;
        flex-direction: column; 
        }
    </style>

    <script>
        // Function to toggle the visibility of the custom address textarea
        function toggleAddressField() {
            var otherAddressField = document.getElementById("otherAddress");
            var addressRadio = document.querySelector('input[name="address"]:checked').value;

            if (addressRadio === "other") {
                otherAddressField.style.display = "block"; // Show the textarea for custom address
            } else {
                otherAddressField.style.display = "none"; // Hide the textarea for custom address
            }
        }

        // Function to validate the form
        function validateForm() {
            var addressRadio = document.querySelector('input[name="address"]:checked');
            var otherAddressField = document.getElementById("otherAddress");

            // Check if an address is selected
            if (!addressRadio) {
                alert("Please select an address.");
                return false;
            }

            // If "Other" address is selected, check if the textarea is filled
            if (addressRadio.value === "other" && otherAddressField.value.trim() === "") {
                alert("Please provide your custom address.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

    <div class="checkout-container">
        <h1>Checkout</h1>

        <!-- Address Section -->
        <form action="PlaceOrderServlet" method="post" onsubmit="return validateForm()">
            <!-- Address Section -->
            <div class="address-section">
                <div class="section-title">Select Address</div>
                <div class="radio-group">
                    <label>
                        <input type="radio" name="address" value="home" checked onclick="toggleAddressField()"> Home Address
                    </label>
                    <label>
                        <input type="radio" name="address" value="office" onclick="toggleAddressField()"> Office Address
                    </label>
                    <label>
                        <input type="radio" name="address" value="other" onclick="toggleAddressField()"> Other (Provide Below)
                    </label>
                    <textarea name="otherAddress" id="otherAddress" class="address-textarea" placeholder="Enter your address" rows="4"></textarea>
                </div>
            </div>

            <!-- Payment Section -->
            <div class="payment-section">
                <div class="section-title">Select Payment Mode</div>

                <!-- Icons for Payment Methods -->
                <div class="payment-icons">
                    <label>
                        <input type="radio" name="payment" value="credit-card" checked> <i class="fas fa-credit-card"></i> Credit Card
                    </label>
                    <label>
                        <input type="radio" name="payment" value="debit-card"> <i class="fas fa-credit-card"></i> Debit Card
                    </label>
                    <label>
                        <input type="radio" name="payment" value="cash"> <i class="fas fa-money-bill-wave"></i> Cash on Delivery
                    </label>
                    <label>
                        <input type="radio" name="payment" value="paypal"> <i class="fab fa-paypal"></i> PayPal
                    </label>
                    <label>
                        <input type="radio" name="payment" value="net-banking"> <i class="fas fa-university"></i> Net Banking
                    </label>
                </div>
            </div>

            <!-- Hidden input for paymentMode -->
            <input type="hidden" name="paymentMode" value="">

            <!-- Place Order Button -->
            <button type="submit" class="place-order-btn">Place Order</button>
        </form>
    </div>

    <script>
        // Ensure the selected payment mode is sent when the form is submitted
        document.querySelector("form").addEventListener("submit", function(event) {
            var selectedPaymentMode = document.querySelector('input[name="payment"]:checked');
            if (selectedPaymentMode) {
                document.querySelector('input[name="paymentMode"]').value = selectedPaymentMode.value;
            }
        });
    </script>

</body>
</html>
