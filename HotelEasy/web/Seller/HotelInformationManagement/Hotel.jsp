<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel</title>
    <link rel="stylesheet" href="Hotel.css">
</head>

<body>
    <%@ include file="../Header/Header.jsp" %>


    <div class="content-container">
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

        <div class="card">
            <div class="image-container">
                <img src="https://demoda.vn/wp-content/uploads/2022/01/hinh-anh-con-meo-ngo-nghinh.jpg" alt="">
            </div>
            <div class="stars">âââââ</div>
            <div class="hotel-name">Name</div>
            <div class="location">location</div>
            <div>
                <span class="old-price">1,498,000 VND</span>
                <span class="price">899,000 VND</span>
            </div>
            <div class="buttons">
                <button class="edit">Edit Information</button>
                <button class="edit-room">Edit Room</button>
                <button class="delete">Delete</button>
            </div>
        </d>
    </div>

</body>

</html>