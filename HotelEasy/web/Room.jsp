<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Enumeration"%>
<%@page import="Object.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Room</title>
        <style>
            body, html {
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

            .choose a:hover {
                background-color: #18375D;
                transform: scale(1.05);
            }

            /* Container chứa các phòng */
            .rooms-container {
                display: flex;
                flex-wrap: wrap; 
                justify-content: space-around; 
                gap: 20px; 
                padding: 20px;
            }

            /* Card hiển thị thông tin từng phòng */
            .room {
                width: calc(33.33% - 40px); /* Đảm bảo 3 phòng trên một hàng */
                max-width: 350px; 
                border: 1px solid #ddd;
                border-radius: 10px;
                padding: 15px;
                box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
                background-color: white;
            }

            .room-title {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 10px;
                color: #1f4e78;
                text-align: center;
            }


            .room-image img {
                width: 100%;
                border-radius: 8px;
                transition: transform 0.3s;
            }


            .room-info {
                display: flex;
                flex-direction: column;
                gap: 15px;
            }

            .features li{
                list-style-type: none;
            }

            .buttons {
                display: flex;
                justify-content: space-between;
            }

            .btn {
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s, transform 0.3s;
            }

            .btn:hover {
                transform: translateY(-2px);
            }

            .edit {
                background-color: #1f4e78;
                color: white;
            }

            .edit:hover {
                background-color: #163a57;
            }

            .delete {
                background-color: black;
                color: white;
            }

            .delete:hover {
                background-color: #333;
            }

            .add-more {
                background-color: #1f4e78;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s, transform 0.3s;
                display: block;
                margin: 20px auto;
                text-align: center;
            }

            .add-more:hover {
                background-color: #163a57;
            }

            .checkmark {
                color: #28a745; /* Green color */
                font-size: 16px; /* Adjust the size as needed */
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

        <button class="btn add-more">Add more room</button>

        <%

            List<RoomDTO> list = (List<RoomDTO>) request.getAttribute("listRoom");
            if (list != null) {
                for (RoomDTO p : list) {
                    pageContext.setAttribute("p", p);
        %>

        <div class="rooms-container">
            <div class="room">
                <div class="room-title">${p.getRoomID()}</div>
                <div class="room-info">
                    <div class="room-image">
                        <img src="https://th.bing.com/th/id/OIP.AVR3AuzRtJPYY-64o09TvwHaHa?rs=1&pid=ImgDetMain"
                             alt="Room Image">
                    </div>
                    <div class="room-details">
                        <p>${p.getCapacityChild()}</p>
                        <p>${p.getCapacityAdult()}</p>
                    </div>
                    <div class="features">
                        <h4>Æ¯u ÄÃ£i trong phÃ²ng</h4>
                        <ul>
                            <li><span class="checkmark">â</span> Miá»n phÃ­ bá»¯a Än sÃ¡ng táº¡i nhÃ  hÃ ng cá»§a khÃ¡ch sáº¡n</li>
                            <li><span class="checkmark">â</span> Miá»n phÃ­ trÃ , cÃ  phÃª, nÆ°á»c suá»i</li>
                            <li><span class="checkmark">â</span> Miá»n phÃ­ bá»¯a Än sÃ¡ng cho tráº» em dÆ°á»i 6 tuá»i</li>
                            <li><span class="checkmark">â</span> Miá»n phÃ­ Internet wifi, há» bÆ¡i</li>
                        </ul>
                    </div>
                </div>
                <div class="buttons">
                    <button class="btn edit">Edit</button>
                    <button class="btn delete">Delete</button>
                </div>
            </div>


            <%}
            } else {%>
            <p>No rooms available</p>
            <%}%>

    </body>

</html>