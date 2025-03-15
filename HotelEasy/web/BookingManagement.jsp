

<%@page import="Object.HotelDTO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="Object.BookingDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Booking Management</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
                
            }
            a{
                text-decoration: none;
                color: orange;
                font-size: 25px;
            }

            .content-container {
                flex: 1;
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                justify-content: center;
            }

            .card {
                background: #fff;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
                overflow: hidden;
                width: 400px;
                text-align: center;
                padding: 20px;
            }

            .room-info a {
                text-decoration: none;
                font-size: 25px;
                color: #333;
                display: block;
                margin-bottom: 10px;
            }

            .room-image {
                width: 100%;
                height: auto;
                border-radius: 10px;
            }

            .room-detail div {
                margin: 5px 0;
                font-size: 14px;
                color: #555;
            }

            .action {
                display: flex;
                justify-content: space-between;
                margin-top: 10px;
            }

            .action a {
                text-decoration: none;
                color: white;
                padding: 8px 12px;
                border-radius: 5px;
                font-size: 14px;
            }

            .accept {
                background: #28a745;
            }

            .reject {
                background: #dc3545;
            }
        </style>
    </head>

    <body>

        <%@ include file="HeaderSellerPage.jsp" %>
        <div class="content-container">
            <%
                List<BookingDTO> listBooking = (List<BookingDTO>) request.getAttribute("listBooking");
                HotelDTO hotel = (HotelDTO) request.getAttribute("hotel");
                pageContext.setAttribute("hotel", hotel);
                if (!listBooking.isEmpty() && listBooking != null) {
                    for (BookingDTO booking : listBooking) {
                        pageContext.setAttribute("booking", booking);

            %>
            <div class="card">
                <div class="room-info">
                    <a href="SellerController?action=editRoom&id=${booking.roomid}">
                        <img src="https://th.bing.com/th/id/R.09d9bce822589c25113a33f2f625ecd4?rik=V3HDt8nAUeD9MQ&pid=ImgRaw&r=0"
                             alt="" class="room-image">
                        <h2 class="room-id">${hotel.namehotel}</h2>
                        <h3 class="room-id">${booking.roomid}</h3>
                    </a>
                </div>

                <div class="room-detail">
                    <a class="personid" href="">Person: ${booking.personname}</a>
                    <div class="numberchild">Children: ${booking.numberchild}</div>
                    <div class="numberadult">Adults: ${booking.numberadult}</div>
                    <div class="depaturedate">Departure: ${booking.departuredate}</div>
                    <div class="arrivedate">Arrival: ${booking.arrivedate}</div>
                    <div class="timebooking">Booking Time: ${booking.timebooking}</div>
                    <div class="action">
                        <a href="SellerController?action=acceptBooking&id=${booking.roomid}" class="accept">Accept</a>
                        <a href="SellerController?action=rejectBooking&id=${booking.roomid}" class="reject">Reject</a>
                    </div>
                </div>
            </div>
            <%}
            } else {%>
            <h2>No Booking Available</h2>
            <%}%>

        </div>

        <%@ include file="Footer.jsp" %>


    </body>

</html>