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

            .choose {
                display: flex;
                gap: 10px; /* Reduced gap */
                flex-wrap: wrap;
                justify-content: space-evenly;
                align-items: center;
                margin: 10px; /* Reduced margin */
            }

            .choose a {
                color: white;
                background-color: #18375D;
                text-decoration: none;
                width: 40%; /* Reduced width */
                text-align: center;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
                padding: 10px 0; /* Reduced padding */
                transition: background-color 0.3s ease, transform 0.3s ease;
                font-size: 14px; /* Reduced font size */
            }

            .choose a:hover {
                background-color: #0056b3;
                transform: scale(1.05);
            }

            h2 {
                color: blue;
                text-align: center;
                margin-bottom: 20px;
            }

            .form-container {
                flex: 1;
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
                font-size: 16px; 
            }

            .input-field, #star-rating {
                flex: 1;
                background-color: lightgray;
                padding: 12px; 
                margin-left: 12px; 
                border-radius: 5px;
                border: none;
                color: gray;
                font-size: 16px; 
            }

            .save-btn {
                background-color: #28a745; /* Changed to a lighter green */
                color: white;
                padding: 10px 20px; /* Reduced padding */
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: block;
                margin: 20px auto; /* Centered button */
                font-size: 16px; 
                transition: background-color 0.3s ease, transform 0.3s ease; /* Added transition */
                width: fit-content; /* Adjust width to fit content */
            }

            .save-btn:hover {
                background-color: #218838; /* Changed to a darker green */
                transform: scale(1.05); /* Added scale effect */
            }

            #star-rating option {
                background-color: white;
                color: black;
            }
        </style>
    </head>

    <body>
        <%@ include file="HeaderSellerPage.jsp" %>



        <%
            HotelDTO hotel = (HotelDTO) request.getAttribute("hotel");
            pageContext.setAttribute("hotel", hotel);
        %>
        <h2>Change Hotel Information</h2>
        <div class="form-container">
            <div class="form-group">
                <span class="label">Hotel Image</span>
                <input type="file" class="input-field" value="Choose File" name="imghotel">

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
                <select id="star-rating" name="star-rating">
                    <option name="ratestar" value="image/Star/1sao.png">1 Star</option>
                    <option name="ratestar" value="image/Star/2sao.png">2 Star</option>
                    <option name="ratestar" value="image/Star/3sao.png">3 Star</option>
                    <option name="ratestar" value="image/Star/4sao.png">4 Star</option>
                    <option name="ratestar" value="image/Star/5sao.png">5 Star</option>
                </select>

            </div>
            <a class="save-btn" href="SellerController?action=changeHotelInfo&id=${hotel.hotelid}">Save</a>
        </div>
        <%@ include file="Footer.jsp" %>
    </body>

</html>