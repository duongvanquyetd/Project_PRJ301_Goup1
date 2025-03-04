<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register Hotel</title>
        <style>
            body,
            html {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                color: #333;
                scroll-behavior: smooth;
            }

            .choose {
                display: flex;
                gap: 10px; /* Reduced gap */
                flex-wrap: wrap;
                justify-content: space-evenly;
                align-items: center;
                margin: 10px; /* Reduced margin */
            }

            .choose a {
                color: white;
                background-color: #18375D;
                text-decoration: none;
                width: 40%; /* Reduced width */
                text-align: center;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
                padding: 10px 0; /* Reduced padding */
                transition: background-color 0.3s ease, transform 0.3s ease;
                font-size: 14px; /* Reduced font size */
            }

            .choose a:hover {
                background-color: #0056b3;
                transform: scale(1.05);
            }

            h2 {
                color: blue;
                text-align: center;
                margin-bottom: 20px;
            }

            .form-container {
                width: 700px; /* Reduced width */
                margin: 0 auto; /* Centered form */
                padding: 30px; /* Reduced padding */
                background-color: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                display: flex;
                align-items: center;
                margin-bottom: 15px; /* Reduced margin */
            }

            .label {
                width: 180px; /* Reduced width */
                background-color: green;
                color: white;
                padding: 12px; /* Reduced padding */
                text-align: center;
                border-radius: 5px;
                font-size: 16px; /* Reduced font size */
            }

            .input-field {
                flex: 1;
                background-color: lightgray;
                padding: 12px; /* Reduced padding */
                margin-left: 12px; /* Reduced margin */
                border-radius: 5px;
                border: none;
                color: gray;
                font-size: 16px; /* Reduced font size */
            }

            .save-btn {
                background-color: green;
                color: white;
                padding: 15px 30px; /* Reduced padding */
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: block;
                margin: 20px auto; /* Centered button and increased margin */
                font-size: 16px; /* Reduced font size */
            }

            .save-btn:hover {
                background-color: darkgreen;
            }
        </style>
    </head>
    <body>

        <%@ include file="HeaderSellerPage.jsp" %>

        <!--Choose-->
        <div class="choose">
            <a href="">
                <h3>Booking Management</h3>
            </a>
            <a href="">
                <h3>Hotel Information management</h3>
            </a>
        </div>
        <!--End Choose-->

        <h2>Change Hotel Information</h2>
        <div class="form-container">
            <div class="form-group">
                <span class="label">Hotel Image</span>
                <input type="file" class="input-field" placeholder="Choose File" >
            </div>
            <div class="form-group">
                <span class="label">Hotel Name</span>
                <input type="text" class="input-field" placeholder="Input Name" >
            </div>
            <div class="form-group">
                <span class="label">Location</span>
                <input type="text" class="input-field" placeholder="Input Location" >
            </div>


        </div>
        <button class="save-btn">Register</button>
    </body>
</html>