<%@page import="Object.HotelDTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Hotel Information</title>
        <style>
            body, html {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                color: #333;
                scroll-behavior: smooth;
                min-height: 100vh; /* Đảm bảo chiều cao tối thiểu */
                display: flex;
                flex-direction: column;
            }

            .main-content {
                flex: 1; /* Đẩy footer xuống cuối */
                padding-bottom: 20px; /* Khoảng cách giữa form và footer */
            }

            a {
                text-decoration: none;
            }

            h2 {
                color: blue;
                text-align: center;
                margin-bottom: 20px;
            }

            .form-container {
                width: 700px;
                margin: 20px auto; /* Cách xa phần footer */
                padding: 30px;
                background-color: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                display: flex;
                align-items: center;
                margin-bottom: 15px;
            }

            .label {
                width: 180px;
                background-color: green;
                color: white;
                padding: 12px;
                text-align: center;
                border-radius: 5px;
                font-size: 16px;
            }

            .input-field {
                flex: 1;
                background-color: lightgray;
                padding: 12px;
                margin-left: 12px;
                border-radius: 5px;
                border: none;
                color: gray;
                font-size: 16px;
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

            /* Footer đặt ở cuối trang */
            .footer {
                background-color: #222;
                color: white;
                text-align: center;
                padding: 10px;
                position: relative;
                bottom: 0;
                width: 100%;
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
                        <input type="file" class="input-field" name="imghotel" multiple="" accept="image/*" required>
                    </div>
                    <div class="form-group">
                        <span class="label">Hotel Name</span>
                        <input type="text" class="input-field"  name="hotelName" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Streets</span>
                        <input type="text" class="input-field" name="hotelStreets" required>
                    </div>

                    <div class="form-group">
                        <span class="label">District</span>
                        <input type="text" class="input-field" name="hotelDistrict" required>
                    </div>

                    <div class="form-group">
                        <span class="label">City</span>
                        <input type="text" class="input-field" name="hotelCity" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Choose Rate</span>
                        <select id="star-rating" name="starrating" class="star" required>
                            <option name="ratestar" value="image/Star/1sao.png">1 Star</option>
                            <option name="ratestar" value="image/Star/2sao.png">2 Star</option>
                            <option name="ratestar" value="image/Star/3sao.png">3 Star</option>
                            <option name="ratestar" value="image/Star/4sao.png">4 Star</option>
                            <option name="ratestar" value="image/Star/5sao.png">5 Star</option>
                        </select>

                    </div>
                    <input name="action" type="hidden" value="insertHotel">
                    <input class="save-btn" type="submit" value="Register"> 
                </div>
            </form>
        </div>
        <%@ include file="Footer.jsp" %>
    </body>

</html>