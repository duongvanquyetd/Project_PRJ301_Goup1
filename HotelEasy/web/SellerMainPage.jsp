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
                margin: 20px 0;
            }

            .fillter select {
                padding: 12px 20px;
                font-size: 16px;
                color: white;
                background-color: #0d2b4d;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s, transform 0.3s;
            }

           

            .fillter select option {
                color: #333;
                background-color: white;
            }

            .getdate {
                display: flex;
                flex-direction: column;
                gap: 15px;
                margin: 20px 0;
            }

            .getdate div {
                display: flex;
                justify-content: space-between;
                align-items: center;
                gap: 10px;
            }

            .getdate label {
                font-size: 16px;
                font-weight: bold;
                color: #333;
                flex: 1;
            }

            .getdate input {
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                width: 100%;
                max-width: 250px;
                flex: 1;
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
                <select>
                    <option value="day">Follow by day</option>
                    <option value="month">Follow by month</option>
                    <option value="year">Follow by year</option>
                </select>
            </div>

            <div class="getdate">
                <div>
                    <label for="fromDate">From date:</label>
                    <input type="date" name="fromDate" id="fromDate">
                </div>
                <div>
                    <label for="toDate">To date:</label>
                    <input type="date" name="toDate" id="toDate">
                </div>
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