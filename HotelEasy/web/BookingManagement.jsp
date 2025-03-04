
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Booking Management</title>
        <style>body,
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

            .card {
                display: flex;
                align-items: center;
                gap: 10px; /* Reduced gap */
                background-color: white;
                border-radius: 10px;
                margin: 10px; /* Reduced margin */
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Reduced shadow */
                overflow: hidden;
                transition: transform 0.3s ease;
            }

            .card:hover {
                transform: scale(1.02);
            }

            .card a {
                color: white;
                text-decoration: none;
            }

            .card h3 {
                color: black;
                margin: 0;
                font-size: 16px; /* Reduced font size */
            }

            .room-info {
                padding: 10px; /* Reduced padding */
                width: 45%; /* Reduced width */
            }

            .room-image {
                width: 70%; /* Reduced width */
            }

            .room-image img {
                width: 100%;
                border-radius: 10px;
            }

            .room-id {
                width: 70%; /* Reduced width */
                text-align: center;
                font-weight: bold;
                font-size: 16px; /* Reduced font size */
                margin-top: 5px; /* Reduced margin */
            }

            .room-action {
                display: flex;
                width: 45%; /* Reduced width */
                justify-content: space-around;
                padding: 5px; /* Reduced padding */
            }

            .room-name {
                width: 45%; /* Reduced width */
            }

            .action {
                width: 45%; /* Reduced width */
                display: flex;
                align-items: center;
                justify-content: space-evenly;
            }

            .action a {
                padding: 10px 20px; /* Reduced padding */
                border-radius: 5px;
                font-size: 14px; /* Reduced font size */
                color: white;
                text-align: center;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .action a:hover {
                transform: scale(1.05);
            }

            .accept {
                background-color: green;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
                padding: 15px 25px; /* Increased padding */
                font-size: 18px; /* Increased font size */
                border-radius: 5px;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .accept:hover {
                background-color: darkgreen;
                transform: scale(1.05);
            }

            .reject {
                background-color: red;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
                padding: 15px 25px; /* Increased padding */
                font-size: 18px; /* Increased font size */
                border-radius: 5px;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .reject:hover {
                background-color: darkred;
                transform: scale(1.05);
            }</style>
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

        <!--Card Info-->
        <div>
            <div class="card">
                <div class="room-info">
                    <a href="">
                        <img src="https://i.pinimg.com/originals/32/5a/d9/325ad9956bf99344a590a78ba40c5321.jpg" alt=""
                             class="room-image">
                        <h3 class="room-id">Room ID</h3>
                    </a>
                </div>

                <div class="room-action">
                    <div class="room-name">
                        <h2>Room Name</h2>
                    </div>
                    <div class="action">
                        <a href="" class="accept">Accept</a>
                        <a href="" class="reject">Reject</a>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div class="card">
                <div class="room-info">
                    <a href="">
                        <img src="https://i.pinimg.com/originals/32/5a/d9/325ad9956bf99344a590a78ba40c5321.jpg" alt=""
                             class="room-image">
                        <h3 class="room-id">Room ID</h3>
                    </a>
                </div>

                <div class="room-action">
                    <div class="room-name">
                        <h2>Room Name</h2>
                    </div>
                    <div class="action">
                        <a href="" class="accept">Accept</a>
                        <a href="" class="reject">Reject</a>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div class="card">
                <div class="room-info">
                    <a href="">
                        <img src="https://i.pinimg.com/originals/32/5a/d9/325ad9956bf99344a590a78ba40c5321.jpg" alt=""
                             class="room-image">
                        <h3 class="room-id">Room ID</h3>
                    </a>
                </div>

                <div class="room-action">
                    <div class="room-name">
                        <h2>Room Name</h2>
                    </div>
                    <div class="action">
                        <a href="" class="accept">Accept</a>
                        <a href="" class="reject">Reject</a>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div class="card">
                <div class="room-info">
                    <a href="">
                        <img src="https://i.pinimg.com/originals/32/5a/d9/325ad9956bf99344a590a78ba40c5321.jpg" alt=""
                             class="room-image">
                        <h3 class="room-id">Room ID</h3>
                    </a>
                </div>

                <div class="room-action">
                    <div class="room-name">
                        <h2>Room Name</h2>
                    </div>
                    <div class="action">
                        <a href="" class="accept">Accept</a>
                        <a href="" class="reject">Reject</a>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <div class="card">
                <div class="room-info">
                    <a href="">
                        <img src="https://i.pinimg.com/originals/32/5a/d9/325ad9956bf99344a590a78ba40c5321.jpg" alt=""
                             class="room-image">
                        <h3 class="room-id">Room ID</h3>
                    </a>
                </div>

                <div class="room-action">
                    <div class="room-name">
                        <h2>Room Name</h2>
                    </div>
                    <div class="action">
                        <a href="" class="accept">Accept</a>
                        <a href="" class="reject">Reject</a>
                    </div>
                </div>
            </div>
        </div>
        <!--End Card Info-->
    </body>

</html>