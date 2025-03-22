<%@page import="java.util.Map"%>
<%@page import="Object.RoomDAO"%>
<%@page import="Object.HotelDTO"%>
<%@page import="Object.RoomImageDTO"%>
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

            a{
                text-decoration: none;
            }


            /* Container chứa các phòng */
            .rooms-container {
                flex: 1;
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
                overflow: hidden;
            }

            .room-img {
                width: 100%;
                height: 300px;
                transition: opacity 0.5s ease;
                display: none; /* Ẩn tất cả ảnh ban đầu */
            }

            .arrow {
                position: absolute;
                top: 50%;
                transform: translateY(-50%);
                background-color: rgba(0, 0, 0, 0.5);
                color: white;
                border: none;
                padding: 10px;
                cursor: pointer;
                border-radius: 50%;
                font-size: 20px;
                z-index: 10;
            }

            .arrow.left {
                left: 10px;
            }

            .arrow.right {
                right: 10px;
            }

            .arrow:hover {
                background-color: rgba(0, 0, 0, 0.8);
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
                padding: 10px 20px; /* Reduced padding for a smaller button */
                border: none;
                border-radius: 5px;
                font-size: 16px; /* Reduced font size */
                cursor: pointer;
                transition: background-color 0.3s, transform 0.3s;
                display: block;
                margin: 20px auto; /* Center the button */
                text-align: center;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Added shadow for depth */
                width: fit-content; /* Adjust width to fit content */
            }

            .add-more:hover {
                background-color: #163a57;
                transform: translateY(-3px); /* Slightly lift the button on hover */
                box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2); /* Increase shadow on hover */
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

            .room-details p {
                margin: 5px 0; /* Adjust margin for better spacing */
                font-size: 16px; /* Adjust font size */
                color: #333; /* Text color */
            }

            .room-details p.room-price {
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



        <a class="btn add-more" href="SellerController?action=createRoom">Add more room</a>

        <div class="rooms-container">
            <%
                HotelDTO hotel = (HotelDTO) request.getAttribute("hotel");
                pageContext.setAttribute("hotel", hotel);
                List< RoomDTO> r = (List< RoomDTO>) request.getAttribute("listRoom");
                List< RoomImageDTO> rimage = (List< RoomImageDTO>) request.getAttribute("roomimage");

                for (RoomDTO room : r) {
                    int i = 0;

                    pageContext.setAttribute("room", room);
            %>

            <div class="room">
                <div class="room-title">${room.roomid} - ${room.typeroom}</div>
                <div class="room-info">
                    <div class="room-image">
                        <%for (RoomImageDTO ri : rimage) {
                            if (ri.getHotelid().equals(hotel.getHotelid()) && ri.getRoomid().equals(room.getRoomid())) {
                                    for (int j = 0; j < ri.getImage().size(); j++) {
                        %>
                        <img src="<%= ri.getImage().get(j)%>" alt="Room Image" class="room-img" >
                        <%  }
                                }
                            }%>

                        <button class="arrow left" onclick="prevImage()">&#10094;</button>
                        <button class="arrow right" onclick="nextImage()">&#10095;</button>
                    </div>
                    <div class="room-details">
                        <p>Capacity Child: ${room.capacitychild}</p>
                        <p>Capacity Adult: ${room.capacityadult}</p>
                        <p>Area: ${room.area} m²</p>
                        <p>Number of Beds: ${room.numberofbed}</p>
                        <p class="room-price">${room.price} VND</p>
                    </div>
                    <div class="features">
                        <h4>Ưu đãi trong phòng</h4>
                        <ul>
                            <%
                                RoomDAO roomDAO = new RoomDAO();
                                List<String> feature = roomDAO.getRoomFeature(hotel.getHotelid(), room.getRoomid());
                                for (String ft : feature) {
                                    pageContext.setAttribute("ft", ft);
                            %>
                            <li><span class="checkmark">✔</span> ${ft}</li>
                                <% } %>
                        </ul>
                    </div>
                </div>
                <div class="buttons">
                    <a class="btn edit" href="SellerController?action=editRoomInfo&id=${room.roomid}">Edit</a>
                    <a class="btn delete" href="SellerController?action=deleteRoom&id=${room.roomid}">Delete</a>
                </div>
            </div>



            <% }%>
        </div>



        <%@ include file="Footer.jsp" %>



    </body>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.querySelectorAll(".room").forEach(room => {
                let images = room.querySelectorAll(".room-img");
                let index = 0;

                if (images.length > 0) {
                    images[0].style.display = "block"; // Hiển thị ảnh đầu tiên
                }

                let prevButton = room.querySelector(".arrow.left");
                let nextButton = room.querySelector(".arrow.right");

                function updateImageDisplay() {
                    images.forEach(img => img.style.display = "none"); // Ẩn tất cả ảnh
                    images[index].style.display = "block"; // Hiển thị ảnh theo index
                }

                if (prevButton && nextButton) {
                    prevButton.addEventListener("click", function () {
                        index = (index - 1 + images.length) % images.length; // Di chuyển về ảnh trước
                        updateImageDisplay();
                    });

                    nextButton.addEventListener("click", function () {
                        index = (index + 1) % images.length; // Di chuyển tới ảnh tiếp theo
                        updateImageDisplay();
                    });
                }
            });
        });

    </script>


</html>