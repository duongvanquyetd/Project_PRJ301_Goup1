<%@page import="Object.BookingDTO"%>
<%@page import="java.util.List"%>
<%@page import="Object.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Revenue Report - Seller</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            display: flex;
            flex-direction: column;
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
        }

        .content-container {
            flex: 1;
            padding: 20px;
        }

        h1, h2 {
            text-align: center;
            color: #333;
        }

        .section {
            background: #fff;
            padding: 20px;
            margin: 20px auto;
            border-radius: 12px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            max-width: 1000px;
        }

        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 15px;
            margin-bottom: 20px;
        }

        form label {
            font-weight: bold;
        }

        form input, button {
            padding: 8px;
            margin: 5px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        button {
            background-color: #007bff;
            color: white;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        .btn-primary {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            font-weight: bold;
            font-size: 16px;
            border: none;
            border-radius: 10px;
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
        }

        .card {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 16px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
            text-align: center;
        }

        .card h3 {
            margin: 0;
            color: #2b7a78;
            font-size: 22px;
        }

        .card p {
            color: #666;
            margin-top: 8px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f9f9f9;
        }
    </style>
</head>

<body>

    <%@ include file="HeaderSellerPage.jsp" %>

    <div class="content-container">
        <h1>HOTEL REVENUE REPORT</h1>

        <!-- Time Filter -->
        <div class="section">
            <h2>Select Date Range</h2>
            <form id="filterForm" action="SellerController">
                <label>
                    From:
                    <input type="date" id="fd" name="fromDate" required>
                </label>
                <label>
                    To:
                    <input type="date" id="td" name="toDate" required>
                </label>
                <div class="button">
                    <input type="hidden" name="action" value="report">
                    <input type="submit" value="Generate Report" class="btn-primary">
                </div>
            </form>
        </div>

        <%
            Integer totalRevenue = (Integer) request.getAttribute("totalRevenue");

            RoomDTO mostRevenueByRoom = (RoomDTO) request.getAttribute("mostRevenueByRoom");
            RoomDTO mostBookingRoom = (RoomDTO) request.getAttribute("mostBookingRoom");
            if (mostRevenueByRoom != null && mostBookingRoom != null && totalRevenue != 0) {
                pageContext.setAttribute("mostRevenueByRoom", mostRevenueByRoom);
                pageContext.setAttribute("mostBookingRoom", mostBookingRoom);
        %>

        <!-- Revenue Section -->
        <div class="section">
            <h2>Revenue Summary</h2>
            <div class="stats-grid">
                <div class="card">
                    <h3><%= totalRevenue %> VND</h3>
                    <p>Total Revenue</p>
                </div>
                <div class="card">
                    <h3>${mostRevenueByRoom.typeroom}: ${mostRevenueByRoom.price} VND</h3>
                    <p>Highest Revenue by Room Type</p>
                </div>
                <div class="card">
                    <h3>Most Booked Room</h3>
                    <h2><%= mostBookingRoom.getRoomid() %> - <%= mostBookingRoom.getTyperoom() %></h2>
                    <p>Based on Number of Bookings</p>
                </div>
            </div>
        </div>
        <% } %>

        <%
            Integer confirm = (Integer) request.getAttribute("confirm");
            Integer cancel = (Integer) request.getAttribute("cancel");
            if (confirm != null && cancel != null) {
        %>
        <!-- Booking Stats -->
        <div class="section">
            <h2>Total Bookings in This Time Range</h2>
            <div class="stats-grid">
                <div class="card">
                    <h3><%= confirm %></h3>
                    <p>Confirmed Bookings</p>
                </div>
                <div class="card">
                    <h3><%= cancel %></h3>
                    <p>Cancelled Bookings</p>
                </div>
            </div>
        </div>
        <% } %>

        <%
            List<BookingDTO> listBooking = (List<BookingDTO>) request.getAttribute("listBooking");
            if (listBooking != null) {
        %>
        <!-- Booking History -->
        <div class="section">
            <h2>Booking History</h2>
            <table>
                <thead>
                    <tr>
                        <th>Customer</th>
                        <th>Room</th>
                        <th>Booking Date</th>
                        <th>Check-in Date</th>
                        <th>Check-out Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (BookingDTO booking : listBooking) {
                            pageContext.setAttribute("booking", booking);
                    %>
                    <tr>
                        <td>${booking.personname}</td>
                        <td>${booking.roomid}</td>
                        <td>${booking.timebooking}</td>
                        <td>${booking.departuredate}</td>
                        <td>${booking.arrivedate}</td>
                        <td>${booking.status}</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <% } %>
    </div>

    <%@ include file="Footer.jsp" %>

</body>
</html>
