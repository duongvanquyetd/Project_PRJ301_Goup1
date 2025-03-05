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
                justify-content: center; 
                gap: 20px; /* Increased gap */
                padding: 20px;
            }

            /* Card hiển thị thông tin từng phòng */
            .room {
                width: calc(25% - 20px); /* Reduced width */
                max-width: 100%; 
                border: 1px solid #ddd;
                border-radius: 10px;
                padding: 10px; /* Reduced padding */
                box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
                background-color: white;
                margin: 10px; /* Added margin */
                transition: transform 0.3s, box-shadow 0.3s; /* Added transition for hover effect */
            }

            .room:hover {
                transform: translateY(-5px); /* Move the card up slightly */
                box-shadow: 2px 2px 15px rgba(0, 0, 0, 0.2); /* Increase shadow on hover */
            }

            .room-title {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 10px;
                color: #1f4e78;
                text-align: center;
            }

            .room-image {
                position: relative;
                width: 100%;
                height: 200x; /* Set a fixed height for the image container */
                overflow: hidden; /* Hide any overflow */
            }

            .room-img {
                width: 100%; /* Set the width to 100% of the container */
                height: 100%; /* Set the height to be twice the width */
                object-fit: contain; /* Ensure the entire image is visible within the container */
                border-radius: 8px;
                transition: transform 0.3s;
            }

            .prev, .next {
                cursor: pointer;
                position: absolute;
                top: 50%;
                width: auto;
                padding: 16px;
                margin-top: -22px;
                color: white;
                font-weight: bold;
                font-size: 18px;
                transition: 0.6s ease;
                border-radius: 0 3px 3px 0;
                user-select: none;
            }

            .next {
                right: 0;
                border-radius: 3px 0 0 3px;
            }

            .prev {
                left: 0;
                border-radius: 3px 0 0 3px;
            }

            .prev:hover, .next:hover {
                background-color: rgba(0,0,0,0.8);
            }

            .room-info {
                display: flex;
                flex-direction: column;
                gap: 15px;
            }

            .features li {
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

            .room-price {
                font-size: 22px; /* Slightly increased font size */
                font-weight: bold;
                color: #e74c3c; /* Red color for price */
                margin-top: 15px; /* Increased margin */
                text-align: center; /* Center align the price */
                background-color: #fff3e0; /* Light orange background color */
                padding: 15px; /* Increased padding */
                border-radius: 10px; /* More rounded corners */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Increased shadow */
                border: 1px solid #e74c3c; /* Border with the same color as the text */
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



        <div class="rooms-container">
            <%

                List<RoomDTO> list = (List<RoomDTO>) request.getAttribute("listRoom");

                for (RoomDTO p : list) {
                    pageContext.setAttribute("p", p);
            %>
            <div class="room">
                <div class="room-title">${p.getRoomID()}</div>
                <div class="room-info">
                    <div class="room-image">
                        <button class="prev" onclick="changeImage(this, -1)">&#10094;</button>
                        <img src="https://th.bing.com/th/id/OIP.AVR3AuzRtJPYY-64o09TvwHaHa?rs=1&pid=ImgDetMain" alt="Room Image" class="room-img" style="display:block;">
                        <img src="https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/udHvbKwV-IMG-Dubai-UAE-1.jpg" alt="Room Image" class="room-img" style="display:none;">
                        <img src="https://th.bing.com/th/id/OIP.ToypZWqUfr06k1mrX5SIyQHaE8?rs=1&pid=ImgDetMain" class="room-img" style="display:none;">
                        <button class="next" onclick="changeImage(this, 1)">&#10095;</button>
                    </div>
                    <div class="room-details">
                        <p>${p.getCapacityChild()}</p>
                        <p>${p.getCapacityAdult()}</p>   
                        <p class="room-price">${p.getPrice()} VND</p> <!-- Added price information -->
                    </div>
                    <div class="features">
                        <h4>Ưu đãi trong phòng</h4>
                        <ul>
                            <li><span class="checkmark">✔</span> Miễn phí bữa ăn sáng tại nhà hàng của khách sạn</li>
                            <li><span class="checkmark">✔</span> Miễn phí trà, cà phê, nước suối</li>
                            <li><span class="checkmark">✔</span> Miễn phí bữa ăn sáng cho trẻ em dưới 6 tuổi</li>
                            <li><span class="checkmark">✔</span> Miễn phí Internet wifi, hồ bơi</li>
                        </ul>
                    </div>
                </div>
                <div class="buttons">
                    <button class="btn edit">Edit</button>
                    <button class="btn delete">Delete</button>
                </div>
            </div>
            <%}%>
        </div>

        <script>
            function changeImage(button, direction) {
                const roomImageDiv = button.parentElement;
                const images = roomImageDiv.querySelectorAll('.room-img');
                let currentImageIndex = Array.from(images).findIndex(img => img.style.display !== 'none');

                images[currentImageIndex].style.display = 'none';
                currentImageIndex = (currentImageIndex + direction + images.length) % images.length;
                images[currentImageIndex].style.display = 'block';
            }

            // Initialize the first image to be visible
            document.querySelectorAll('.room-img').forEach((img, index) => {
                if (index % 3 !== 0)
                    img.style.display = 'none';
            });
        </script>

    </body>

</html>