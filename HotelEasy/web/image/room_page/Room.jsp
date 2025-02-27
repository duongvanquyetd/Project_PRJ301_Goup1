<%-- 
    Document   : Room
    Created on : Feb 25, 2025, 8:09:01 AM
    Author     : pvand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <header>
        <div class="container_header">
            <a href="#"><img src="img_room/logo.png" alt="hint error"></a>
            <nav>
                <div><a href="#">Home</a>
                    <a href="#">Favourite</a>
                    <a href="#">Login</a>
                    <a href="#">Register user</a>
                    <a href="#">Register seller</a>
                </div>

            </nav>
        </div>
    </header>

    <div class="search-bar">
        <div class="search-container">
            <input class="search-input" placeholder="Location or hotel name" type="text" id="location">
        </div>
        <div class="search-container">
            <input type="date" id="check-in">
            <input type="date" id="check-out">
        </div>
        <div class="search-container">
            <input type="text" id="room-type" placeholder="room-type">
        </div>
        <button id="search-btn">Search</button>
    </div>

    <div id="result-container"></div>

    <div class="img-inf">
        <div id="img-left">
            <img src="img_room/Screenshot 2025-02-17 003405.png" alt="">
        </div>
        <div id="img-right">
            <div class="img-div"><img src="img_room/ Screenshot 2025-02-17 003218.png" alt=""></div>
            <div class="img-div"><img src="img_room/Screenshot 2025-02-17 003308.png" alt=""></div>
            <div class="img-div"><img src="img_room/Screenshot 2025-02-17 003329.png" alt=""></div>
            <div class="img-div"><img src="img_room/Screenshot 2025-02-17 003346.png" alt=""></div>
            
           
        </div>
    </div>
    
    <div class="container">
        <!-- Phần thông tin phòng -->
        <section class="room-details">
            <div>
                <h2>Room Premium Family</h2>
                <img src="img/Screenshot 2025-02-17 003308.png" alt="">
                <div>
                    <a href="https://maps.app.goo.gl/kRnvZMxRZue79wYM6" target="_blank">
                    273 An Dương Vương, Quận 5, TP.HCM
                </a>
                <iframe src="https://www.google.com/maps/embed?pb=!1m17!1m12!1m3!1d3919.63455747629!2d106.65759707504172!3d10.762621989385309!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m2!1m1!2zMTDCsDQ1JzQ1LjQiTiAxMDbCsDM5JzM2LjYiRQ!5e0!3m2!1svi!2s!4v1739841982009!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
                
                

            </div>
            
            <div class="room-highlights">
                
                <p><strong>x4 human 2 children under 9 years old stay FREE</strong></p>
            </div>
            <div class="room-offers">
                <h3>Room Offers</h3>
                <ul>
                    <li>Free breakfast at the hotel restaurant.</li>
                    <li>Welcome fruit</li>
                    <li>Room service, hair dryer, in-room safe, slippers, robes.</li>
                    <li>Free Wi-Fi, swimming pool</li>
                    <li>Acreage - 58m²</li>
                    <li>Welcome drink</li>
                    <li>Beds: 2</li>
                </ul>
                <p class="note">Note: Room rates may change during holidays or special events.</p>
            </div>
        </section>

        <!-- Phần tiện ích -->
        <section class="amenities">
            <div>
                <h2>Amenities</h2>
                
            </div>
            
            <div class="amenities-list">
                <div class="amenity-item">
                    <span>Free Breakfast</span>
                </div>
                <div class="amenity-item">
                    <span>Massage Chair</span>
                </div>
                <div class="amenity-item">
                    <span>Office Desk</span>
                </div>
                <div class="amenity-item">
                    <span>Swimming Pool</span>
                </div>
            </div>
        </section>

        <!-- Phần đặt phòng -->
        <section class="booking-form-section">
            <h2>Booking Now</h2>
            <form class="booking-form">
                <div class="form-group">
                    <label for="code">Nhập mã vào</label>
                    <input type="text" id="code" placeholder="Mã đặt phòng">
                </div>
                <div class="form-group">
                    <label for="name">Họ và tên</label>
                    <input type="text" id="name" placeholder="Họ và tên">
                </div>
                <div class="form-group">
                    <label for="rating">Chọn đánh giá (1-5 sao)</label>
                    <input type="number" id="rating" min="1" max="5" placeholder="1-5 sao">
                </div>
                <div class="form-group">
                    <button type="submit">Visit đánh giá</button>
                    <button type="button">Post</button>
                </div>
            </form>
        </section>
    </div>
    <script>
        let today = new Date().toISOString().split('T')[0];
        document.getElementById("check-in").setAttribute("min", today);
        document.getElementById("check-in").addEventListener("change", function () {
            let checkInDate = document.getElementById("check-in").value;
            document.getElementById("check-out").setAttribute("min", checkInDate);
        });
    </script>
</body>

</html>