<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Hotel</title>
    <link rel="stylesheet" href="RegisterHotel.css">
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

    <h2>Change Hotel Information</h2>
    <div class="form-container">
        <div class="form-group">
            <span class="label">Hotel Image</span>
            <input type="file" class="input-field" placeholder="Choose File" >
        </div>
        <div class="form-group">
            <span class="label">Hotel Name</span>
            <input type="text" class="input-field" placeholder="Input Name" >
        </div>
        <div class="form-group">
            <span class="label">Location</span>
            <input type="text" class="input-field" placeholder="Input Location" >
        </div>
       
        
    </div>
    <button class="save-btn">Register</button>
</body>
</html>