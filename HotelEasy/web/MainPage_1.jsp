<%@page import="Object.HotelImageDTA"%>
<%@page import="Object.HotelDTA"%>
<%@page import="Object.HotelDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <style> 
        /* Reset CSS */
        body, html {
            margin: 0;
            padding: 0;
            font-family: 'Merriweather', serif;
            background-color: #f4f4f4;
            color: #333;
            scroll-behavior: smooth; /* Cuộn mượt */
        }

        /* Header */
        header {
            background-color: #333;
            color: #fff;
            padding: 2px 0;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .container_header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin: 0 auto;
            padding: 0 20px;
        }



        header img {
            height: 50px;
            width: 50px;/* Điều chỉnh kích thước logo */
            border-radius: 50%;
            transition: transform 0.3s ease;
            margin-right: 430px;

        }
        header img:hover {
            transform: scale(1.1); /* Hiệu ứng phóng to khi hover */
        }


        nav {
            display: flex;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            margin-left:30px;
            font-size: 16px;
            font-family: 'Merriweather', serif;
            transition: color 0.3s ease, transform 0.3s ease;

        }

        nav a:hover {
            color: #007bff; 
            transform: translateY(-3px); 
        }




        /* Search Bar */
        .search-bar {
            display: flex;
            flex-wrap: wrap;
            gap: 25px;
            justify-content: center;
            padding: 30px 0px;

            background-color: #fff;
            background-image: url('image/hotel/KhachSanPageMain/Banner.png');
            border-radius: 8px;
            margin: 25px auto;
            max-width: 1200px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);

        }

        .search-container {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .search-input, #room-type, #check-in, #check-out {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            outline: none;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
        }

        .search-input:focus, #room-type:focus, #check-in:focus, #check-out:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        #search-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        #search-btn:hover {
            background-color: #0056b3;
            transform: translateY(-2px); /* Hiệu ứng nổi lên khi hover */
        }








        /* Phần tìm kiếm theo lựa chọn*/
        .option_user {
            text-align: center;
            margin-top: 20px;
        }

        .option_user ul b {
            list-style: none; 

            display: flex;
            justify-content: space-evenly; 
            gap: 50px;
            font-family: 'Merriweather', serif;
        }

        .option_user a {
            text-decoration: none; /* Xóa gạch chân */
            color: #333; /* Màu chữ */
            font-size: 22px;
            font-weight: bold;
            transition: color 0.3s ease, transform 0.3s ease; 
        }

        .option_user a:hover {
            color: #007bff;
            transform: translateY(-3px); 
        }


        /* Phần hiển thị phòng */

        .Main_page {
            display: flex;
            justify-content: space-evenly;
            flex-wrap: wrap;
            background-color: white;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card {
            width: 252px;
            background-color: white;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 10px;
            transition: transform 0.3s ease-in-out;
            padding: 10px 10px;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card-img-container {
            position: relative;
            width: 100%;
            height: 200px;
        }

        .card-img-top {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .discount-badge {
            position: absolute;
            top: 10px;
            left: 10px;
            background-color: red;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            font-size: 14px;
            font-weight: bold;
        }

        .favorite-icon {
            position: absolute;
            top: 10px;
            right: 10px;
            color: red;
            font-size: 20px;
        }

        .card-body {
            padding: 15px;
            text-align: center;
        }

        .rating {
            color: gold;
            font-size: 18px;
        }

        h5 {
            font-size: 18px;
            font-weight: bold;
            margin: 10px 0;
        }

        .location {
            color: gray;
            font-size: 14px;
        }

        .price {
            font-size: 16px;
            font-weight: bold;
            margin-top: 10px;
        }

        .price del {
            color: gray;
            font-size: 14px;
            margin-right: 5px;
        }

        .price strong {
            color: #ff7e00;
            font-size: 18px;
        }


        /* Footer */
        /* Style chung cho footer */
        footer {
            background-color: #333;
            color: #fff;
            padding: 40px 0;
            text-align: center;
        }



        /* Responsive Design */
        @media (max-width: 768px) {
            .img-inf {
                flex-direction: column;
            }

            .img-div {
                flex: 1 1 100%;
            }

            .room-details {
                flex-direction: column;
                align-items: center;
            }

            .room-details img {
                width: 100%;
            }

            .amenities-list {
                flex-direction: column;
            }

            .booking-form {
                width: 100%;
            }
        }




    </style>

    <body>

        <!-- Header logo và các nút home-->
        <header>
            <div class="container_header">
                <a href="#"><img src="image/hotel/KhachSanPageMain/Logo.png" alt="hint error"></a>
                <nav>
                    <div class="Menu">
                        <a  style="background-color: dimgrey;padding: 10px 15px; border-radius: 20px; border: 1px solid white;"href="#">Home</a>
                        <a style="margin-right: 550px;" href="#">Favourite</a>
                        <a href="#">Login</a>
                        <a href="#">Register</a>
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






        <!-- Phần tìm kiếm theo lựa chọn -->
        <div class="option_user">
            <ul> 
                <b>
                    <a href="#" style="background-color: #9FA1A5; border-radius: 20px;
                       padding: 0px 15px;border: 2px solid black"> <h5>Khách Sạn Đang Giảm Giá</h5></a>
                    <a href="#"> <h5>Khách Sạn Đánh Giá Cao Nhất</h5></a>
                    <a href="#"> <h5>Địa Điểm Đáng Quan Tâm Nhất</h5></a>
                </b>
            </ul>
        </div>


        <!-- Phần hiển thị các phòng -->
        <div class="Main_page">
            <%
                List<HotelDTA> list = (List<HotelDTA>) request.getAttribute("List");
                List<HotelImageDTA> i = (List<HotelImageDTA>) request.getAttribute("Img");

                for (HotelDTA h : list) {


            %>
            <div class="card">
                <div class="card-img-container">
                    <%      for (HotelImageDTA b : i) {
                            if (h.getHotelID().equals(b.getHotelID())) {


                    %>
                    <img style="border-radius: 10px"; src="<%=b.getImage().get(0)%>" class="card-img-top" alt="Hotel">
                    <% }
                        }
                    %>
                    <span class="discount-badge">Tiết kiệm <%=h.getDiscount()%>% </span>
                    <span class="start"> <img style="margin-left:75px;" src="<%=h.getRateHotel()%>" ></span>
                </div>
                <div class="card-body">
                    <h5><%=h.getNameHotel()%></h5>
                    <p class="location">
                        <a href="https://www.google.com/maps?q=<%=h.getStreets() + "+" + h.getDistrict() + "+" + h.getCity()%>" target="_blank">
                            <%=h.getStreets() + "," + h.getDistrict() + "," + h.getCity()%>
                        </a>
                    </p>
                    <p class="price">
                        <del> <%=h.getPrice()%> VND </del> <!-- del dùng để gạch ngang-->
                        <strong><%=h.getPrice() * (1 - (h.getDiscount() / 100))%> VND</strong>
                    </p>
                </div>
            </div>

            <% }%>


        </div>





        <script>
            let today = new Date().toISOString().split('T')[0];
            document.getElementById("check-in").setAttribute("min", today);
            document.getElementById("check-in").addEventListener("change", function () {
                let checkInDate = document.getElementById("check-in").value;
                document.getElementById("check-out").setAttribute("min", checkInDate);
            });
        </script>


        <footer>
            <h5>Footter</h5>

        </footer>

    </body>

</html>