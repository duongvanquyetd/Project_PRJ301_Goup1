<%@page import="java.util.List"%>
<%@page import="java.util.Collections.list(Enumeration)"%>
<%@page import="Object.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room</title>
    <link rel="stylesheet" href="Room.css">
</head>

<body>
<%@ include file="../Header/Header.jsp" %>

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
                int i = 1 ; 
                for (RoomDTO p : list) {
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
                    <p>ð¥ 2 ngÆ°á»i lá»n | ð 1 giÆ°á»ng ÄÃ´i / 2 giÆ°á»ng ÄÆ¡n</p>
                    <p>ð¨ HÆ°á»ng phá» | ð Wifi miá»n phÃ­ | ðââï¸ Há» bÆ¡i</p>
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

       
    <%}%>

</body>

</html>