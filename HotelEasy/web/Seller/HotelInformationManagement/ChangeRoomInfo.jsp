<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Hotel Information</title>
    <link rel="stylesheet" href="ChangeRoomInfo.css">
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

    <h2>Change Room Information</h2>
    <div class="form-container">
        <div class="form-group">
            <span class="label">Room Image</span>
            <input type="file" class="input-field" placeholder="Choose File" >
        </div>
        <div class="form-group">
            <span class="label">Discount</span>
            <input type="text" class="input-field" placeholder="Input Discount" >
        </div>
        <div class="form-group">
            <span class="label">Price</span>
            <input type="text" class="input-field" placeholder="Input Price" >
        </div>
        <div class="form-group">
            <span class="label">NameRoom</span>
            <input type="text" class="input-field" placeholder="Input Room Name" >
        </div>
        <div class="form-group">
            <span class="label">Utilities</span>
            <input type="text" class="input-field" placeholder="Input Utilities" >
        </div>
        <div class="form-group">
            <span class="label">Endow</span>
            <input type="text" class="input-field" placeholder="Input Endow" >
        </div>
        <div class="form-group">
            <span class="label">Type Of Room</span>
            <input type="text" class="input-field" placeholder="Input Type" >
        </div>
    </div>
    <button class="save-btn">Save</button>
</body>

</html>