<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
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

            .button-container {
                text-align: center;
                margin-top: 20px;
            }

            .save-btn {
                background-color: green;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                display: inline-block;
                font-size: 16px;
            }

            .save-btn:hover {
                background-color: darkgreen;
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
                <h2>Change Room Information</h2>
                <div class="form-container">
                    <div class="form-group">
                        <span class="label">Room Image</span>
                        <input type="file" class="input-field" placeholder="Choose File" name="roomImg" multiple="" accept="image/*" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Capacity Child</span>
                        <input type="number" class="input-field" placeholder="Input Capacity Child" name="roomCapacityChild" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Capacity Adult</span>
                        <input type="number" class="input-field" placeholder="Input Capacity Adult" name="roomCapacityAdult" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Type Room</span>
                        <input type="text" class="input-field" placeholder="Input Type Room" name="roomType" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Area</span>
                        <input type="number" class="input-field" placeholder="Input Area" name="roomArea" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Number Of Bed</span>
                        <input type="number" class="input-field" placeholder="Input Number Of Bed" name="numberOfBed" required>
                    </div>

                    <div class="form-group">
                        <span class="label">Price</span>
                        <input type="number" class="input-field" placeholder="Input Price" name="roomPrice" required>
                    </div>

                    <div class="form-group"> 
                        <span class="label">Discount</span>
                        <input type="number" class="input-field" placeholder="Input Discount" name="roomDiscount" required>
                    </div>
                    <div class="button-container">
                        <input name="action" type="hidden" value="insertRoom">
                        <input class="save-btn" type="submit" value="Register"> 
                    </div>
                </div>
            </form>
        </div>

        <%@ include file="Footer.jsp" %>
    </body>

</html>