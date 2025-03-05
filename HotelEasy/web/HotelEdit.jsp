<%@page import="Object.HotelDTA"%>
<%@page import="Object.RoomDTO"%>
<%@page import="Object.HotelDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel</title>
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

            .content-container{
                display: flex;
                justify-content: center;
                align-items: center;
                flex-wrap: wrap;
            }

            .choose {
                display: flex;
                gap: 10px;
                flex-wrap: wrap;
                justify-content: space-evenly;
                align-items: center;
                margin: 20px 0; /* Increased margin */
                width: 100%; /* Full width */
            }

            .choose a {
                color: white;
                background-color: #18375D;
                text-decoration: none;
                width: 40%;
                text-align: center;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
                padding: 10px 0;
                transition: background-color 0.3s ease, transform 0.3s ease;
                font-size: 14px;
            }

            .choose a:hover {
                background-color: #0056b3;
                transform: scale(1.05);
            }

            .card {
                width: 350px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                overflow: hidden;
                padding: 10px;
                background-color: white;
            }

            .image-container {
                position: relative;
            }

            .image-container img {
                width: 100%;
                border-radius: 10px;
            }

            .stars {
                color: gold;
                font-size: 18px;
                margin: 10px 0;
            }

            .hotel-name {
                font-weight: bold;
                font-size: 18px;
            }

            .location {
                color: gray;
                font-size: 14px;
            }

            .price {
                font-size: 18px;
                color: orange;
                font-weight: bold;
            }

            .old-price {
                color: gray;
                text-decoration: line-through;
                font-size: 14px;
            }

            .buttons {
                margin-top: 20px; /* Increased margin-top */
                display: flex;
                justify-content: center; /* Center the buttons */
                gap: 20px; /* Increased gap */
            }

            .edit,
            .edit-room,
            .delete {
                border: none;
                padding: 12px 24px; /* Increased padding */
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px; /* Increased font size */
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .edit {
                background: #1E3A8A;
                color: white;
            }

            .edit:hover {
                background: #162d6a;
                transform: scale(1.05);
            }

            .edit:active {
                background: #0f1e4a;
            }

            .edit-room {
                background: #4CAF50; /* Green background */
                color: white;
            }

            .edit-room:hover {
                background: #3e8e41;
                transform: scale(1.05);
            }

            .edit-room:active {
                background: #2e6e31;
            }

            .delete {
                background: black;
                color: white;
            }

            .delete:hover {
                background: #333;
                transform: scale(1.05);
            }

            .delete:active {
                background: #111;
            }


        </style>
    </head>

    <body>
        <%@ include file="HeaderSellerPage.jsp" %>


        <div class="content-container">
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
            <%
                HotelDTA hotel = (HotelDTA) request.getAttribute("hotel");

            %>
            <div class="card">
                <div class="image-container">
                    <img src="https://demoda.vn/wp-content/uploads/2022/01/hinh-anh-con-meo-ngo-nghinh.jpg" alt="">
                </div>
                <div class="stars">âââââ</div>
                <div class="hotel-name">Name</div>
                <div class="location">location</div>
                <div>
                    <span class="old-price">1,498,000 VND</span>
                    <span class="price">899,000 VND</span>
                </div>
                <div class="buttons">
                    <a class="edit" href="HotelEditController?id=">Edit Information</a>
                    <a class="edit-room">Edit Room</a>
                    <a class="delete">Delete</a>
                </div>
                
            </div>

    </body>

</html>