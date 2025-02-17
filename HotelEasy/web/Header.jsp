<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="header.css">
        <title>Hotel Booking</title>
    </head>
    <style> 
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .logo{
            display: flex;
            justify-content: center;

        }
        .logo img img{
            width: 100%;
        }
        .logo img img{
            width:15%;

        }
        .logo menu{
            width: 100%;
        }
        .logo menu{
            width: 85%;
        }

        .img img{
            width: 200px;
            height: 200px;
            border-radius: 50%;
            border: 5px solid black; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            margin-right: 250px;
        }

        .logo ul li a{
            text-decoration: none;
            padding: 10px 15px;
            border-radius: 20px;
            
        }

        .logo ul li a:first-child {
            background-color: #1ABC9C !important;
            font-size: 40px;
            color: white;
            padding: 25px;
            border-radius: 20px;
            margin-right: 20px;
            font-weight: bold;
        }


        .logo ul li a{
            transition: transform 0.3s ease;
        }

        .logo ul li a:hover{
            transform: scale(1.1);
        }



        .logo ul li{
            width: 80%;
            list-style: none;
            display: flex;
            justify-content: center;
            margin-top: 65px;

        }



        .header_menu  {
            display: flex;
            justify-content: center;
            background-image: url('image/Banerr.jpg');  
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            color: white;
            padding: 100px 0;
        }


        .search-box input {
            width: 230px;
            padding: 15px 10px;
        }
        .search-box button{
            width: 230px;
            padding: 16px;
            background-color: #1ABC9C;
            font-weight: bold;
            font-size: 20px;
        }


        .option_user ul li{
            display: flex;
            justify-content: center;
            margin-bottom: 70px;

        }
        .option_user ul li h5{
            width:80%;
            color: white;
            font-size: 35px;
            padding: 10px;
            transition: transform 0.3s ease;
        }


        .option_user ul li h5:hover{
            transform: scale(1.1);
        }
        
        
        .form-control{
            font-weight: bold;
            font-size: 20px;
        }


        .Main_page {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            background-color: #f8f9fa;
            padding: 20px;
        }

        .card {
            width: 300px;
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 10px;
            transition: transform 0.3s ease-in-out;
            padding: 0px 15px;
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

    </style>



    <body>
        <header class="logo">
            <div class="logoo">
                <div class='img'>
                    <img src='image/logo.jpg'>
                </div> 

            </div>


            <div class="menu">
                <ul>
                    <li>
                        <a href="#" class="btn btn-primary">Home</a>
                        <a style="margin-left: 200px; font-size: 40px; color:white;padding:25px;border-radius: 20px; background-color: navy" href="#" class="btn btn-dark">Favourite</a>
                        <a style="margin-left: 200px; font-size: 40px; color:white;padding:25px;border-radius: 20px; background-color: navy" href="#" class="btn btn-dark">Login</a>
                        <a style="margin-left: 200px; font-size: 40px; color:white;padding:25px;border-radius: 20px; background-color: navy" href="#" class="btn btn-dark">Register</a>
                    </li>
                </ul>
            </div>
        </header>








        <section class="header_menu">
            <div class="container">
                <div class="search-box d-flex justify-content-center">
                    <input type="text" class="form-control mx-2" placeholder="Tìm theo tên khách sạn">
                    <input type="date" class="form-control mx-2">
                    <input type="date" class="form-control mx-2">
                    <input type="number" class="form-control mx-2" placeholder="Số người">
                    <button class="btn btn-danger">Tìm kiếm</button>
                </div>
            </div>
        </section>


        <div class="option_user">
            <ul>
                <li>
                    <h5 class="chon" style=" background-color: #1ABC9C;font-weight: bold;margin-right:50px;text-align: center;border-radius: 10px">Khách Sạn Đang Giảm Giá</h5>
                    <h5 style="background-color: navy; color:white; margin-right: 50px;text-align: center; border-radius: 10px">Khách Sạn Đánh Giá Cao Nhất</h5>
                    <h5 style="background-color: navy; color:white;margin-right: 50px;text-align: center; border-radius: 10px">Khách Sạn Quan Tâm Nhất</h5>
                </li>
            </ul>
        </div>



        <div class="Main_page">
            <div class="card">
                <div class="card-img-container">
                    <img style="border-radius: 10px"; src="image/hotel/KhachSanPageMain/HT1.jpg" class="card-img-top" alt="Hotel">
                    <span class="discount-badge">Tiết kiệm -25% </span>
                    <span class="start"> <img style="margin-left:100px;" src="image/star/5sao.png" ></span>
                    <i class="fa-solid fa-heart favorite-icon"></i>
                </div>
                <div class="card-body"">
                    <div class="rating">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                    </div>
                    <h5>Wink Hottel DaNang Centre</h5>
                    <p class="location">12 Thùy Vân, TP Đà Nẵng</p>
                    <p class="price">
                        <del>1,490,000 VND</del> 
                        <strong>1,175,000 VND</strong>
                    </p>
                </div>
            </div>

            <div class="card">
                <div class="card-img-container">
                    <img style="border-radius: 10px"; src="image/hotel/KhachSanPageMain/HT2.jpg" class="card-img-top" alt="Hotel">
                    <span class="discount-badge">Tiết kiệm -50%</span>
                    <span class="start"> <img style="margin-left:100px;" src="image/star/3sao.png" ></span>
                    <i class="fa-solid fa-heart favorite-icon"></i>
                </div>
                <div class="card-body">
                    <div class="rating">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                    </div>
                    <h5>Khách sạn Riva Vũng Tàu</h5>
                    <p class="location">03-05 Thùy Vân, TP Vũng Tàu</p>
                    <p class="price">
                        <del>1,800,000 VND</del> 
                        <strong>900,000 VND</strong>
                    </p>
                </div>
            </div>

            <div class="card">
                <div class="card-img-container">
                    <img style="border-radius: 10px"; src="image/hotel/KhachSanPageMain/HT3.jpg" class="card-img-top" alt="Hotel">
                    <span class="discount-badge">Tiết kiệm -50%</span>
                    <span class="start"> <img style="margin-left:100px;" src="image/star/5sao.png" ></span>
                    <i class="fa-solid fa-heart favorite-icon"></i>
                </div>
                <div class="card-body">
                    <div class="rating">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                    </div>
                    <h5>La Sapinette Hottel</h5>
                    <p class="location">05 Lý Chính Thắng, TP Đà Lạt</p>
                    <p class="price">
                        <del>2,000,000 VND</del> 
                        <strong>1,000,000 VND</strong>
                    </p>
                </div>
            </div>
        </div>




        <footer class="bg-dark text-white text-center p-3 mt-4">Footer</footer>
    </body>
</html>
