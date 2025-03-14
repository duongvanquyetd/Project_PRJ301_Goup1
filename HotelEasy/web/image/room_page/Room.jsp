<%-- 
    Document   : Room
    Created on : Feb 25, 2025, 8:09:01 AM
    Author     : pvand
--%>

<%@page import="Object.FeatureHotelDTO"%>
<%@page import="Object.FeatureRoomDTO"%>
<%@page import="sun.net.www.content.audio.x_aiff"%>
<%@page import="Object.RoomImageDTO"%>
<%@page import="java.util.List"%>
<%@page import="Object.HotelImageDTA"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

/* Image Section */
.img-inf {
    display: flex;
    gap: 10px;
    max-width: 1200px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

#img-left {
    flex: 2;
}

#img-left img {
    width: 100%;
    height: auto;
    border-radius: 8px;
    transition: transform 0.3s ease;
}

#img-left img:hover {
    transform: scale(1.02); /* Hiệu ứng phóng to khi hover */
}

#img-right {
    flex: 1;
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
}

.img-div {
    flex: 1 1 calc(50% - 10px);
}

.img-div img {
    width: 100%;
    height: 100%;
    border-radius: 8px;
    transition: transform 0.3s ease;
}

.img-div img:hover {
    transform: scale(1.05); /* Hiệu ứng phóng to khi hover */
}

/* Room Details */
.container {
    max-width: 1200px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.room-details {
    margin-bottom: 30px;
    display: flex;
    gap: 20px;
    align-items: flex-start;
}

.room-details h2 {
    font-size: 2em;
    color: #007bff;
    margin-bottom: 10px;
}

.room-details img {
    width: 300px;
    height: auto;
    border-radius: 8px;
    transition: transform 0.3s ease;
}

.room-details img:hover {
    transform: scale(1.05); /* Hiệu ứng phóng to khi hover */
}

.room-highlights {
    margin-bottom: 20px;
}

.room-highlights p {
    font-size: 1.2em;
    color: #555;
    margin: 5px 0;
}

.room-offers h3 {
    font-size: 1.5em;
    color: #333;
    margin-bottom: 10px;
}

.room-offers ul {
    list-style-type: circle;
    padding-left: 20px;
}

.room-offers ul li {
    font-size: 1em;
    color: #555;
    margin: 5px 0;
}

.room-offers .note {
    font-size: 0.9em;
    color: #888;
    margin-top: 10px;
}

/* Amenities */
.amenities {
    margin-bottom: 30px;
}

.amenities h2 {
    font-size: 2em;
    color: #007bff;
    margin-bottom: 10px;
}

.amenities-list {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
}

.amenity-item {
    background-color: #f8f9fa;
    padding: 10px 15px;
    border-radius: 5px;
    font-size: 1em;
    color: #333;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.amenity-item:hover {
    transform: translateY(-5px); /* Hiệu ứng nổi lên khi hover */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

/* Booking Form */
.booking-form-section {
    margin-bottom: 30px;
}

.booking-form-section h2 {
    font-size: 2em;
    color: #007bff;
    margin-bottom: 10px;
}

.booking-form {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

.form-group {
    display: flex;
    flex-direction: column;
    gap: 5px;
}

.form-group label {
    font-size: 1em;
    color: #555;
}

.form-group input {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1em;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

.form-group input:focus {
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

.form-group button {
    padding: 10px 15px;
    background-color: #28a745;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1em;
    transition: background-color 0.3s ease, transform 0.3s ease;
}

.form-group button:hover {
    background-color: #218838;
    transform: translateY(-2px); /* Hiệu ứng nổi lên khi hover */
}
/* style.css */


.container_hotel {
            max-width: 1200px;
            margin: 30px auto;
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

        
        
        /*  Phần css của room */
        
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

    <div id="result-container">
<%
    List<String> list = (List<String>) request.getAttribute("HotelImg");
    
    if (list != null) {
          
%>
    <div class="img-inf">
        <div id="img-left">
            <img src="<%= list.get(0) %>" alt="Main Image">
        </div>
        <div id="img-right">
         <% for(int i =1 ; i < list.size() ; i++) {  %>
         <div class="img-div"><img src="<%= list.get(i) %>" alt="Hotel Image"></div>
            <%
            }
            %>
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
                        <div class="hotel-rating">Đánh giá: <img url="${ht.rateHotel}" ></div>
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
           <c:forEach var="ir" items="${rt.image}">
               <img src="${ir}" alt="Room Image">
           </c:forEach>
           
           <div class="features">
               <span>📐 35.5 m²</span>
               <span>🚭 Non-smoking</span>
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
                                <div class="old-price">Boor sung data gias cux</div>
                                <div class="price">${rt.price}</div>
                                <div style="font-size: 12px;">Exclude taxes & fees</div>
                                <button class="choose-btn">Choose</button>
                                <div class="left-room">2 room(s) left!</div>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
        </div>
   </div>
</c:forEach>

      
    </div> 
    </div>
   
       
        
        

      
    <script>
        let today = new Date().toISOString().split('T')[0];
        document.getElementById("check-in").setAttribute("min", today);
        document.getElementById("check-in").addEventListener("change", function () {
            let checkInDate = document.getElementById("check-in").value;
            document.getElementById("check-out").setAttribute("min", checkInDate);
        });
    </script>
</body>

</html>