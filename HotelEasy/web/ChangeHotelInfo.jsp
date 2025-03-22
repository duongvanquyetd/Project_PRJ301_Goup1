<%@page import="Object.HotelDTO"%>

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
            .main-content{
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

            .star {
                flex: 1;
                background-color: lightgray;
                padding: 12px;
                margin-left: 12px;
                border-radius: 5px;
                border: none;
                color: gray;
                font-size: 16px;
                cursor: pointer;
            }

            .button-container {
                text-align: center;
                margin-top: 20px;
            }

            .save-btn {
                background-color: green;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: block; /* Đảm bảo button là block để căn giữa */
                margin: 20px auto; /* Căn giữa theo chiều ngang */
                font-size: 16px;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .save-btn:hover {
                background-color: darkgreen;
                transform: scale(1.05);
            }
        </style>
    </head>

    <body>
        <%@ include file="HeaderSellerPage.jsp" %>

        <div class="main-content">
            <form action="SellerController" method="POST" enctype="multipart/form-data">
                <h2>Change Hotel Information</h2>
                <div class="form-container">
                    <div class="form-group">
                        <span class="label">Hotel Image</span>
                        <input type="file" class="input-field" value="Choose File" name="imghotel" multiple="" accept="image/*">
                    </div>
                    <div class="form-group">
                        <span class="label">Hotel Name</span>
                        <input type="text" class="input-field" value="${hotel.namehotel}" name="updatehotelname">
                    </div>
                    <div class="form-group">
                        <span class="label">Streets</span>
                        <input type="text" class="input-field" value="${hotel.streets}" name="updateStreet">
                    </div>
                    <div class="form-group">
                        <span class="label">District</span>
                        <input type="text" class="input-field" value="${hotel.district}" name="updatedistrict">
                    </div>
                    <div class="form-group">
                        <span class="label">City</span>
                        <input type="text" class="input-field" value="${hotel.city}" name="updatecity">
                    </div>
                    <div class="form-group">
                        <span class="label">Choose Rate</span>
                        <select id="star-rating" name="starrating" class="star">
                            <option name="ratestar" value="image/Star/1sao.png">1 Star</option>
                            <option name="ratestar" value="image/Star/2sao.png">2 Star</option>
                            <option name="ratestar" value="image/Star/3sao.png">3 Star</option>
                            <option name="ratestar" value="image/Star/4sao.png">4 Star</option>
                            <option name="ratestar" value="image/Star/5sao.png">5 Star</option>
                        </select>
                    </div>
                    <input type="hidden" name="action" value="updateHotel">
                    <input type="hidden" name="id" value="${hotel.hotelid}">
                    <button type="submit" class="save-btn">Save</button>
                </div>
            </form>
        </div>

        <%@ include file="Footer.jsp" %>
    </body>


</html>