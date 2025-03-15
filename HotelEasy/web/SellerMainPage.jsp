<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Seller</title>
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

            .content-container {
                flex: 1;
                display: flex;
                justify-content: space-between;
                align-items: flex-start;
                text-align: center;
                margin: 20px;
            }

            .fillter {
                display: flex;
                flex-direction: column;
                gap: 10px;
            }

            .fillter div {
                padding: 12px 20px;
                color: white;
                text-align: center;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                background-color: #0d2b4d;
                transition: background-color 0.3s, transform 0.3s;
            }

            .fillter div:hover {
                background-color: #0a1f36;
                transform: scale(1.05);
            }

            .getdate input {
                padding: 12px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                width: 100%;
                max-width: 250px;
                transition: border-color 0.3s;
            }

            .getdate input:focus {
                border-color: #0d2b4d;
            }

            .choose {
                display: flex;
                gap: 20px;
                flex-wrap: wrap;
                justify-content: center;
            }

            .choose a {
                display: flex;
                align-items: center;
                justify-content: center;
                width: 200px;
                height: 70px;
                background-color: #f58242;
                color: white;
                text-decoration: none;
                font-size: 18px;
                border-radius: 20px;
                text-align: center;
                transition: background-color 0.3s, box-shadow 0.3s;
            }

            .choose a:hover {
                background-color: #e67335;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }


        </style>
    </head>

    <body>

        <%@ include file="HeaderSellerPage.jsp" %>

        <div class="content-container">
            <div class="fillter">
                <div>Follow by day</div>
                <div>Follow by month</div>
                <div>Follow by year</div>
            </div>

            <div class="getdate">
                <input type="date" name="date" id="date">
            </div>

            <div class="choose">
                <a href="">Number Of Booking</a>
            </div>
            <div class="choose">
                <a href="">Revenue</a>
            </div>
        </div>
        <%@ include file="Footer.jsp" %>
    </body>

</html>