<%-- 
    Document   : Room
    Created on : Feb 25, 2025, 8:09:01 AM
    Author     : pvand
--%>

<%@page import="Object.FeatureHotelDTO"%>
<%@page import="Object.FeatureRoomDTO"%>
<%@page import="Object.RoomImageDTO"%>
<%@page import="java.util.List"%>
<%@page import="Object.HotelImageDTA"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">



<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            /* Reset CSS */
            body, html {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                color: #333;
                scroll-behavior: smooth; /* Cuộn mượt */
            }

            /* Header */
            header {
                background-color: #333;
                color: #fff;
                padding: 10px 0;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            .container_header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                max-width: 1200px;
                margin: 0 auto;
                padding: 0 20px;
            }

            header img {
                height: 50px; /* Điều chỉnh kích thước logo */
                transition: transform 0.3s ease;
            }

            header img:hover {
                transform: scale(1.1); /* Hiệu ứng phóng to khi hover */
            }

            nav {
                display: flex;
            }

            nav a {
                color: #fff;
                text-decoration: none;
                margin-left: 20px;
                font-size: 16px;
                transition: color 0.3s ease;
            }

            nav a:hover {
                color: #ff6347; /* Đổi màu khi hover */
            }

            /* Search Bar */
            .search-bar {
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                justify-content: center;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                margin: 20px auto;
                max-width: 1200px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            .search-container {
                display: flex;
                align-items: center;
                gap: 10px;
            }

            .search-input, #room-type, #check-in, #check-out {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
                outline: none;
                transition: border-color 0.3s ease, box-shadow 0.3s ease;
            }

            .search-input:focus, #room-type:focus, #check-in:focus, #check-out:focus {
                border-color: #007bff;
                box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
            }

            #search-btn {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            #search-btn:hover {
                background-color: #0056b3;
                transform: translateY(-2px); /* Hiệu ứng nổi lên khi hover */
            }


            .container_hotel {
                max-width: 1200px;
                margin: 0px auto;
                background: #fff;
                padding: 30px;
                border-radius: 12px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }
            .title {
                font-size: 28px;
                font-weight: bold;
                text-align: center;
                margin-bottom: 30px;
            }
            .hotel-card {
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap;
                border: 1px solid #ddd;
                padding: 20px;
                margin-bottom: 20px;
                border-radius: 10px;
                background-color: #fff;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
            }
            .hotel-details {
                flex: 1 1 60%;
            }
            .hotel-name {
                font-size: 24px;
                font-weight: bold;
                color: #333;
                margin-bottom: 10px;
            }
            .hotel-address, .hotel-rating {
                font-size: 16px;
                color: #555;
                margin-bottom: 8px;
            }
            .hotel-features-section {
                flex: 1 1 35%;
                background-color: #f5f5f5;
                padding: 16px;
                border-radius: 10px;
            }
            .hotel-features-section strong {
                display: block;
                margin-bottom: 10px;
                color: #333;
            }
            .hotel-features {
                list-style: none;
                padding-left: 0;
                margin: 0;
            }
            .hotel-features li::before {
                content: "✔️ ";
                margin-right: 6px;
            }
            .no-data {
                font-size: 18px;
                text-align: center;
                color: #999;
                margin-top: 30px;
            }

            .content{

                display: flex ;
                margin: 10px auto ;
                max-width: 1600px;
                justify-content: space-between;


            }
            .infomationhotel {
                max-width: 1600px;
                margin: 0 auto;
            }

            .imghotel {
                display: flex;
                gap: 10px;
                max-width: 1400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            .img-left {
                flex: 2;
            }

            .img-left img {
                width: 100%;
                height: 100%;
                object-fit: cover;
                border-radius: 8px;
                transition: transform 0.3s ease;
                cursor: pointer;
            }

            .img-left img:hover {
                transform: scale(1.02);
            }

            .img-right {
                flex: 1;
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                justify-content: space-between;
                align-content: flex-start;
            }

            .imgmodal {
                width: calc(50% - 5px); /* Chia 2 ảnh trên 1 hàng với gap 10px */
                 height: calc(50% - 5px); /* mỗi ảnh cao bằng 50% chiều cao của khung */
                aspect-ratio: 1.5; /* Hoặc bạn có thể dùng height cố định */
                overflow: hidden;
                border-radius: 8px;
            }

            .imgmodal img {
                width: 100%;
                height: 100%;
                object-fit: cover;
                border-radius: 8px;
                cursor: pointer;
                transition: transform 0.3s ease;
            }

            .imgmodal img:hover {
                transform: scale(1.02);
            }






            .filter {
                max-width: 1200px;
                margin: 0px 14px 20px;
                padding: 30px;
                background: #ffffff;
                border-radius: 20px;
                box-shadow: 0 12px 30px rgba(0, 0, 0, 0.1);
                font-family: 'Segoe UI', sans-serif;
                color: #333;
            }

            .filter h1 {
                font-size: 28px;
                margin-bottom: 25px;
                color: #2c3e50;
                text-align: center;
            }

            .filter-section {
                margin-bottom: 25px;
            }

            .filter-section h3 {
                font-size: 18px;
                margin-bottom: 10px;
                color: #444;
            }

            .filter-section label {
                display: block;
                font-weight: 500;
                margin-bottom: 8px;
                color: #555;
            }

            select,
            input[type="range"] {
                width: 100%;
                padding: 10px 12px;
                font-size: 15px;
                border: 1px solid #ccc;
                border-radius: 12px;
                box-shadow: inset 0 2px 4px rgba(0,0,0,0.05);
                transition: border-color 0.3s ease;
                background: #fdfdfd;
            }

            select:focus,
            input[type="range"]:focus {
                border-color: #3498db;
                outline: none;
            }

            .price-slider-container {
                position: relative;
            }

            .price-label {
                display: inline-block;
                font-size: 14px;
                margin-top: 10px;
                color: #666;
            }

            .min-price {
                float: left;
            }

            .selected-price {
                float: right;
                font-weight: bold;
                color: #2c3e50;
            }

            .submit-button {
                width: 100%;
                background: linear-gradient(135deg, #6dd5ed, #2193b0);
                color: white;
                padding: 14px 20px;
                font-size: 16px;
                border: none;
                border-radius: 12px;
                cursor: pointer;
                transition: background 0.3s ease, transform 0.2s;
                box-shadow: 0 8px 16px rgba(0,0,0,0.15);
            }

            .submit-button:hover {
                background: linear-gradient(135deg, #2193b0, #6dd5ed);
                transform: scale(1.02);
            }

            @media (max-width: 600px) {
                .filter {
                    padding: 20px;
                }

                .filter h1 {
                    font-size: 22px;
                }

                .submit-button {
                    font-size: 15px;
                    padding: 12px 16px;
                }
            }




            /*  Phần css của room */
            .alert_alert-warning{
                max-width: 1200px ; margin:  30px auto ; background: #fff ;
            }
            .container { max-width: 1200px; margin: 30px auto; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
            .title { font-size: 28px; font-weight: bold; margin-bottom: 20px; }
            .room-section { display: flex; gap: 20px; }
            .room-image { flex: 1; }
            .room-image img { width: 100%; border-radius: 12px; }
            .room-details { flex: 2; }
            .features { margin-top: 10px; font-size: 14px; }
            .features span { display: block; margin-bottom: 4px; }
            .options-table { width: 100%; border-collapse: collapse; margin-top: 20px; }
            .options-table th, .options-table td { border: 1px solid #ddd; padding: 10px; text-align: center; }
            .price { color: #d9534f; font-weight: bold; font-size: 18px; }
            .old-price { text-decoration: line-through; color: #888; font-size: 14px; }
            .good-location { color: #fff; background: #d9534f; border-radius: 5px; padding: 2px 6px; font-size: 12px; }
            .choose-btn { background-color: #007bff; color: white; padding: 8px 12px; border: none; border-radius: 5px; cursor: pointer; }
            .left-room { color: red; font-size: 13px; }
            .room-option-title { font-weight: bold; margin-top: 10px; }
            .see-details { color: #007bff; text-decoration: underline; cursor: pointer; margin-top: 10px; display: inline-block; }


            .price-slider-container {
                display: flex;
                align-items: center;
                justify-content: space-between;
                gap: 10px;
            }

            .price-label {
                font-weight: bold;
                font-size: 14px;
                white-space: nowrap;
                min-width: 100px;
                text-align: center;
            }

            #priceSlider {
                flex: 1;
                height: 6px;
                -webkit-appearance: none;
                background: #ccc;
                border-radius: 4px;
                outline: none;
            }

            #priceSlider::-webkit-slider-thumb {
                -webkit-appearance: none;
                appearance: none;
                width: 18px;
                height: 18px;
                background: #007bff;
                border-radius: 50%;
                cursor: pointer;
            }

            #priceSlider::-moz-range-thumb {
                width: 18px;
                height: 18px;
                background: #007bff;
                border-radius: 50%;
                cursor: pointer;
            }

       

          
            /*
            comment css*/
            .container-comment {
                max-width: 1200px;
                margin: 30px auto;
                padding: 20px;
                background: #f9f9f9;
                border-radius: 16px;
                box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
                font-family: 'Segoe UI', sans-serif;
            }

            .comment-title h3 {
                text-align: center;
                font-size: 24px;
                color: #333;
                margin-bottom: 30px;
                position: relative;
            }

            .comment-title h3::after {
                content: '';
                display: block;
                width: 80px;
                height: 3px;
                background-color: #4caf50;
                margin: 10px auto 0;
                border-radius: 5px;
            }

            .comment-box {
                background: #fff;
                border-radius: 12px;
                padding: 20px;
                margin-bottom: 20px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
                transition: transform 0.2s ease;
            }

            .comment-box:hover {
                transform: translateY(-3px);
            }

            .comment-header {
                display: flex;
                align-items: center;
                margin-bottom: 10px;
            }

            .avatar {
                width: 45px;
                height: 45px;
                border-radius: 50%;
                background-color: #4caf50;
                display: flex;
                justify-content: center;
                align-items: center;
                color: white;
                font-size: 20px;
                font-weight: bold;
                margin-right: 15px;
                flex-shrink: 0;
            }

            .comment-name {
                font-size: 18px;
                font-weight: 600;
                color: #222;
                margin: 0;
            }

            .comment-body p {
                font-size: 16px;
                line-height: 1.6;
                color: #555;
                margin: 0;
            }

        /* Modal overlay */
.modal {
    display: none;
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100vw;
    height: 100vh;
    overflow: auto;
    background-color: rgba(0,0,0,0.6);
    justify-content: center;
    align-items: center;
}

/* Modal content box */
.modal-content {
    background-color: #fff;
    padding: 10px;
    max-width: 90vw;
    max-height: 90vh;
    border-radius: 12px;
    box-shadow: 0 5px 20px rgba(0,0,0,0.3);
    overflow: hidden;
    display: flex;
    flex-direction: column;
    align-items: center;
    position: relative;
}


/* Close icon */
.close {
    position: absolute;
    top: 10px;
    right: 15px;
    font-size: 28px;
    color: #333;
    cursor: pointer;
    z-index: 1001;
}

/* Slideshow */
.slideshow-container {
    width: 100%;
    height: 100%;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
}

/* Each image slide */

.slide {
    display: none;
    width: 100%;
    height: auto;
    text-align: center;
}

.slide img {
    max-width: 100%;
    max-height: 80vh;
    object-fit: contain;
    border-radius: 10px;
}


.room-image {
    border: 1px solid #ddd;
    border-radius: 10px;
    padding: 10px;
    margin-bottom: 20px;
    max-width: 100%;
}

.image-slider {
    position: relative;
    overflow: hidden;
    width: 100%;
    height: 250px;
}

.slider-img {
    display: none;
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 10px;
}

.slider-img.active {
    display: block;
}

.prev-btn, .next-btn {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    background-color: rgba(0,0,0,0.5);
    border: none;
    color: white;
    font-size: 24px;
    padding: 8px 12px;
    cursor: pointer;
    z-index: 10;
    border-radius: 50%;
}

.prev-btn:hover, .next-btn:hover {
    background-color: rgba(0,0,0,0.8);
}

.prev-btn {
    left: 10px;
}

.next-btn {
    right: 10px;
}

.features {
    margin-top: 10px;
    display: flex;
    flex-direction: column;
    gap: 5px;
    font-size: 14px;
}

.see-details {
    margin-top: 10px;
    font-weight: bold;
    color: #007BFF;
    cursor: pointer;
}


           
            /* Responsive Design */
            @media (max-width: 768px) {
                .img-inf {
                    flex-direction: column;
                }

                .img-div {
                    flex: 1 1 100%;
                }

                .room-details {
                    flex-direction: column;
                    align-items: center;
                }

                .room-details img {
                    width: 100%;
                }

                .amenities-list {
                    flex-direction: column;
                }

                .booking-form {
                    width: 100%;
                }
            }
        </style>

    </head>

    <body>


        <header>
            <div class="container_header">
                <a href="#"><img src="img_room/logo.png" alt="hint error"></a>
                <nav>
                    <div><a href="#">Home</a>
                        <a href="#">Favourite</a>
                        <a href="#">Login</a>
                        <a href="#">Register user</a>
                        <a href="#">Register seller</a>
                    </div>

                </nav>
            </div>
        </header>


        <div class="search-bar">
            <div class="search-container">
                <input class="search-input" placeholder="Location or hotel name" type="text" id="location">
            </div>
            <div class="search-container">
                <input type="date" id="check-in">
                <input type="date" id="check-out">
            </div>
            <div class="search-container">
                <input type="text" id="room-type" placeholder="room-type">
            </div>
            <button id="search-btn">Search</button>
        </div>
        <div class="content">
            <div class="filter">
                <h1>🎯 Điều chỉnh thông tin phù hợp</h1>

                <form action="RoomExtensioncontroller" method="GET">
                    <!-- Lọc theo giá -->
                    <div class="filter-section">
                        <h3>Lọc theo giá</h3>
                        <div class="price-slider-container">
                            <span class="price-label min-price">0 VNĐ</span>
                            <input type="range" id="priceSlider" name="price" min="0" max="5000000" step="50000" value="${requestScope.price}">
                            <span class="price-label selected-price" id="selectedPrice">${requestScope.price} VNĐ</span>
                        </div>
                    </div>

                    <!-- Lọc theo số giường -->
                    <div class="filter-section">
                        <label for="bedCount">🛏️ Số giường:</label>
                        <select id="bedCount" name="bedCount">

                            <option value="">none</option>
                            <option value="1" ${bed == '1' ? 'selected': ''}>1 giường</option>
                            <option value="2" ${bed == '2' ? 'selected' : ''}>2 giường</option>
                            <option value="3" ${bed == '3'? 'selected' : ''}>3 giường</option>
                            <option value="4" ${bed == '4' ? 'selected': ''}>4 giường</option>
                        </select>
                    </div>

                    <!-- Lọc theo số người lớn -->
                    <div class="filter-section">
                        <label for="guestCountAdult">👤 Số người lớn:</label>
                        <select id="guestCountAdult" name="guestCountAdult" >
                            <option value="${adults}">--chọn--</option>
                            <option value="">none</option>
                            <option value="1" ${adult =='1' ? 'selected':''}>1 người</option>
                            <option value="2"${adult =='2' ? 'selected':''}>2 người</option>
                            <option value="3"${adult =='3' ? 'selected':''}>3 người</option>
                            <option value="4"${adult =='3' ? 'selected':''}>4 người</option>
                            <option value="5"${adult =='4' ? 'selected':''}>5 người</option>
                        </select>
                    </div>

                    <!-- Lọc theo số trẻ em -->
                    <div class="filter-section">
                        <label for="guestCountChild">👶 Số trẻ em:</label>
                        <select id="guestCountChild" name="guestCountChild">
                            <option value="">--Chọn--</option>
                            <option value="1" ${child == '1' ? 'selected' : ''}>1 người</option>
                            <option value="2"${child == '2' ? 'selected' : ''}>2 người</option>
                            <option value="3"${child == '3' ? 'selected' : ''}>3 người</option>
                            <option value="4"${child == '4' ? 'selected' : ''}>4 người</option>
                            <option value="5"${child == '5' ? 'selected' : ''}>5 người</option>
                        </select>
                    </div>

                    <!-- Hidden input để truyền action -->
                    <input type="hidden" name="action" value="search">

                    <div class="filter-section">
                        <button type="submit" class="submit-button">🔍 Lọc kết quả</button>
                    </div>
                </form>

            </div>
            <div class="infomationhotel">
                <div id="result-container">
                    <%
                        List<String> list = (List<String>) request.getAttribute("HotelImg");

                        if (list != null) {

                    %>
                    <div class="imghotel">
                        <div class="img-left">
                            <img src="<%= list.get(0)%>" alt="Main Image" onclick="openModal(0)">
                        </div>
                        <div class="img-right">
                            <% for (int i = 1; i < 5 && i < list.size(); i++) {%>
                            <div class="imgmodal">
                                <img src="<%= list.get(i)%>" alt="Hotel Image" onclick="openModal(<%= i%>)">
                            </div>
                            <% } %>
                        </div>
                    </div>


                    <!--            Model box-->
                    <div id="imageModal" class="modal">
                        <div class="modal-content">
                            <span class="close" onclick="closeModal()">&#x2716;</span>
                            <div class="slideshow-container ">

                                <%
                                    for (int i = 0; i < list.size(); i++) {
                                %>
                                <div class="slide">
                                    <img src="<%=list.get(i)%>" alt="ảnh full">

                                </div>

                                <%
                                    }
                                %>
                                <a class="prev-btn" onclick="changeSlide(-1)">&#10094;</a>
                                <a class="next-btn" onclick="changeSlide(1)">&#10095;</a>
                            </div>
                        </div>
                    </div>
                    <%
                    } else {
                    %>
                    <p>No images available</p>
                    <%
                        }
                    %>

                </div>



                <div class="container_hotel">
                    <div class="title">Thông tin khách sạn</div>

                    <c:if test="${not empty fthotel}">
                        <c:forEach var="ht" items="${fthotel}">
                            <div class="hotel-card">
                                <div class="hotel-details">
                                    <div class="hotel-name">Tên khách sạn: ${ht.nameHotel}</div>
                                    <div class="hotel-address">Địa chỉ: ${ht.streets}, ${ht.districts}, ${ht.city}</div>
                                    <div class="hotel-rating">Đánh giá: <img src="${ht.rateHotel}" > ${ht.rateHotel}</div>
                                </div>
                                <c:if test="${not empty ht.featureList}">
                                    <div class="hotel-features-section">
                                        <strong>Tiện ích:</strong>
                                        <ul class="hotel-features">
                                            <c:forEach var="feature" items="${ht.featureList}">
                                                <li>${feature}</li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </c:if>

                    <c:if test="${empty fthotel}">
                        <div class="no-data">Không có dữ liệu khách sạn.</div>
                    </c:if>
                </div>

                <c:forEach var="rt" items="${ftroom}">
                    <div class="container">

                        <div class="title">${rt.type}</div>
                        <div class="room-section">
                            <div class="room-image">
                                <div class="image-slider">
                                    <c:forEach var="ir" items="${rt.image}" varStatus="loop">
                                        <img src="${ir}" class="slider-img ${loop.index == 0 ? 'active' : ''}" alt="Room Image">
                                    </c:forEach>
                                    <button class="prev-btn" onclick="prevSlide(this)">❮</button>
                                    <button class="next-btn" onclick="nextSlide(this)">❯</button>
                                </div>

                                <div class="features">
                                    <span>📐 ${rt.area} m²</span>
                                    <span>Số giường: ${rt.numberOfBed} <i class="fa-solid fa-bed"></i></span>
                                    <span>🛁 Separate shower and bathtub</span>
                                    <span>🧊 Refrigerator</span>
                                    <span class="see-details">See Room Details</span>
                                </div>
                            </div>

                            <div class="room-details">
                                <table class="options-table">
                                    <thead>
                                        <tr>
                                            <th>Room Option(s)</th>
                                            <th>Guest(s)</th>
                                            <th>Price/room/night</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <c:forEach var="ft" items="${rt.gift}">
                                                    <div class="room-option-title">${ft}</div>
                                                </c:forEach>


                                            </td>
                                            <td>
                                                <div> CapacityAdult </div>
                                                <p>${rt.capacityAdult}</p>
                                                <div> CapacityChild </div>
                                                <p>${rt.capacityChild}</p>

                                            </td>
                                            <td>
                                                <div class="good-location">Good location</div>
                                                <div class="old-price"><fmt:formatNumber value="${rt.price}"/> VNĐ </div>
                                                <c:set var="finalPrice" value="${rt.price - (rt.price * rt.discount / 100)}"/>
                                                <div class="price">
                                                    <fmt:formatNumber value="${finalPrice}"/> VNĐ
                                                </div>

                                                <div style="font-size: 12px;">Exclude taxes & fees</div>
                                                <button class="choose-btn" >Choose</button>
                                                <!--                                <div class="left-room">2 room(s) left!</div>-->
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <c:if test="${empty ftroom}">
                    <div class="alert alert-warning" role="alert">
                        không có phòng này
                    </div>
                </c:if>
            </div> 


        </div>

        <div class="container-comment">
            <div class="comment-title">
                <h3>Đánh giá của khách hàng cho khách sạn</h3>
            </div>
            <c:forEach var="vr" items="${cmt}">
                <div class="comment-box">
                    <div class="comment-header">
                        <div class="avatar">
                            <span>${vr.name.charAt(0)}</span>
                        </div>
                        <h4 class="comment-name">${vr.name}</h4>
                    </div>
                    <div class="comment-body">
                        <p>${vr.desciption}</p>
                    </div>
                </div>
            </c:forEach>
        </div>





        <script>
            const priceSlider = document.getElementById("priceSlider");
            const selectedPrice = document.getElementById("selectedPrice");

            priceSlider.addEventListener("input", () => {
                selectedPrice.textContent = Number(priceSlider.value).toLocaleString('vi-VN') + " VNĐ";
            })
            let today = new Date().toISOString().split('T')[0];
            document.getElementById("check-in").setAttribute("min", today);
            document.getElementById("check-in").addEventListener("change", function () {
                let checkInDate = document.getElementById("check-in").value;
                document.getElementById("check-out").setAttribute("min", checkInDate);
            });
            function prevSlide(btn) {
    const slider = btn.closest('.image-slider');
    const images = slider.querySelectorAll('.slider-img');
    let currentIndex = [...images].findIndex(img => img.classList.contains('active'));

    images[currentIndex].classList.remove('active');
    const prevIndex = (currentIndex - 1 + images.length) % images.length;
    images[prevIndex].classList.add('active');
}

function nextSlide(btn) {
    const slider = btn.closest('.image-slider');
    const images = slider.querySelectorAll('.slider-img');
    let currentIndex = [...images].findIndex(img => img.classList.contains('active'));

    images[currentIndex].classList.remove('active');
    const nextIndex = (currentIndex + 1) % images.length;
    images[nextIndex].classList.add('active');
}
            //modal bboxx

            let slideIndex = 0;
let slides = [];

function openModal(index = 0) {
    document.getElementById("imageModal").style.display = "block";
    slides = document.getElementsByClassName("slide");
    showSlide(index);
}

function closeModal() {
    document.getElementById("imageModal").style.display = "none";
}

function changeSlide(n) {
    showSlide(slideIndex + n);
}

function showSlide(n) {
    if (slides.length === 0) return;

    if (n >= slides.length) slideIndex = 0;
    else if (n < 0) slideIndex = slides.length - 1;
    else slideIndex = n;

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slides[slideIndex].style.display = "block";
}

// Optional: click outside modal to close
window.onclick = function (event) {
    const modal = document.getElementById("imageModal");
    if (event.target === modal) {
        modal.style.display = "none";
    }
}


        </script>
    </body>

</html>