<%@page import="Object.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Hotel Information</title>
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

            a{
                text-decoration: none;
            }

            h2 {
                color: blue;
                text-align: center;
                margin-bottom: 20px;
            }
            .content-container{
                flex: 1;
            }
            .form-container {

                width: 700px; /* Reduced width */
                margin: 0 auto; /* Centered form */
                padding: 30px; /* Reduced padding */
                background-color: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                display: flex;
                align-items: center;
                margin-bottom: 15px; /* Reduced margin */
            }

            .label {
                width: 180px; /* Reduced width */
                background-color: green;
                color: white;
                padding: 12px; /* Reduced padding */
                text-align: center;
                border-radius: 5px;
                font-size: 16px; /* Reduced font size */
            }

            .input-field {
                flex: 1;
                background-color: lightgray;
                padding: 12px; /* Reduced padding */
                margin-left: 12px; /* Reduced margin */
                border-radius: 5px;
                border: none;
                color: gray;
                font-size: 16px; /* Reduced font size */
            }

            .button-container {
                text-align: center;
                margin-top: 20px;
            }

            .save-btn {
                background-color: green;
                color: white;
                padding: 10px 20px; /* Adjusted padding */
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: inline-block;
                font-size: 16px; /* Reduced font size */
            }

            .save-btn:hover {
                background-color: darkgreen;
            }
        </style>
    </head>

    <body>

        <%@ include file="HeaderSellerPage.jsp" %>

        <%
            RoomDTO room = (RoomDTO) request.getAttribute("room");
            pageContext.setAttribute("room", room);
        %>

        <div class="content-container">
            <form action="SellerController" method="POST" enctype="multipart/form-data">
                <h2>Change Room Information</h2>
                <div class="form-container">
                    <div class="form-group">
                        <span class="label">Room Image</span>
                        <input type="file"  class="input-field" name="roomImg" value="" multiple="" accept="image/*">
                    </div>

                    <div class="form-group">
                        <span class="label">Capacity Child</span>
                        <input type="text" class="input-field"  name="roomCapacityChild" value="${room.capacitychild}">
                    </div>

                    <div class="form-group">
                        <span class="label">Capacity Adult</span>
                        <input type="text" class="input-field"  name="roomCapacityAdult" value="${room.capacityadult}">
                    </div>

                    <div class="form-group">
                        <span class="label">Type Room</span>
                        <input type="text" class="input-field"  name="roomType" value="${room.typeroom}">
                    </div>

                    <div class="form-group">
                        <span class="label">Area</span>
                        <input type="text" class="input-field"  name="roomArea" value="${room.area} m²" >
                    </div>

                    <div class="form-group">
                        <span class="label">Number Of Bed</span>
                        <input type="text" class="input-field"  name="numberOfBed" value="${room.numberofbed}">
                    </div>

                    <div class="form-group">
                        <span class="label">Price</span>
                        <input type="text" class="input-field"  name="roomPrice" value="${room.price}">
                    </div>

                    <div class="form-group">
                        <span class="label">Discount</span>
                        <input type="text" class="input-field"  name="roomDiscount" value="${room.discount}">
                    </div>


                    <div class="button-container">
                        <input type="hidden" name="action" value="updateRoom">
                        <input type="hidden" name="idroom" value="${room.roomid}">
                        <input type="submit" class="save-btn" value="Save">
                    </div>
                </div>
            </form>
        </div>

        <%@ include file="Footer.jsp" %>
    </body>

</html>