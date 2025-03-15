<%@page import="Object.HotelDTO"%>

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

            a {
                text-decoration: none;
            }

            .content-container{
                flex: 1;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-wrap: wrap;
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
                width: 100%;
                overflow: hidden;
            }

            .image-container img {
                width: 100%;
                opacity: 0;
                transition: opacity 0.5s ease;
                position: absolute;
                top: 0;
                left: 0;
            }

            .image-container img.active {
                opacity: 1;
                position: relative;
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
            }

            .arrow.left {
                left: 10px;
            }

            .arrow.right {
                right: 10px;
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
            <%
                HotelDTO hotel = (HotelDTO) request.getAttribute("hotel");
                HotelDAO dao = new HotelDAO();
                List<String> img = (List<String>) request.getAttribute("hotelimg");
                pageContext.setAttribute("img", img);

                if (hotel != null) {
                    pageContext.setAttribute("hotel", hotel);
            %>

            <div class="card">
                <div class="image-container">

                    <%                        for (String hotelimg : img) {

                    %>
                    <img src="${hotelimg}" alt="Hotel Image">

                    <%}%>

                    <button class="arrow left" onclick="prevImage()">&#10094;</button>
                    <button class="arrow right" onclick="nextImage()">&#10095;</button>
                </div>
                <img class="stars" src="${hotel.ratehotel}">
                <div class="hotel-name">${hotel.namehotel}</div>
                <div class="location">${hotel.city}, ${hotel.district}, ${hotel.streets}</div>
                <div>

                    <span class="price"><%= dao.getLowestPrice(hotel.getHotelid())%></span>
                </div>
                <div class="buttons">
                    <a class="edit" href="SellerController?action=editHotel&id=${hotel.hotelid}">Edit Information</a>
                    <a class="edit-room" href="SellerController?action=editRoom&id=${hotel.hotelid}">Manager Room</a>
                    <a class="delete" href="SellerController?action=deleteHotel&id=${hotel.hotelid}">Delete</a>
                </div>
            </div>
            <%} else {%>
            <h3>No hotel available. <a href="" style="color: blue">Register Hotel?</a></h3>
            <%}%>
        </div>


        <%@ include file="Footer.jsp" %>

    </body>
    <script>
        let currentImageIndex = 0;
        const images = document.querySelectorAll('.image-container img');

        function showImage(index) {
            images.forEach((img, i) => {
                img.classList.toggle('active', i === index);
            });
        }

        function prevImage() {
            currentImageIndex = (currentImageIndex > 0) ? currentImageIndex - 1 : images.length - 1;
            showImage(currentImageIndex);
        }

        function nextImage() {
            currentImageIndex = (currentImageIndex < images.length - 1) ? currentImageIndex + 1 : 0;
            showImage(currentImageIndex);
        }
    </script>

</html>