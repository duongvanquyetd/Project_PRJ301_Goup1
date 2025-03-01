<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seller</title>
    <link rel="stylesheet" href="MainsellerPageStyle.css">
</head>

<body>
    
    <%@ include file="../Header/Header.jsp" %>
    
    <div class="content-container">
        <div class="fillter">
            <div>Follow by day</div>
            <div>Follow by month</div>
            <div>Follow by year</div>
        </div>

        <div class="getdate">
            <input type="date" name="date" id="date">
        </div>

        <div class="choose">
            <a href="">Number Of Booking</a>
        </div>
        <div class="choose">
            <a href="">Revenue</a>
        </div>
    </div>
</body>

</html>