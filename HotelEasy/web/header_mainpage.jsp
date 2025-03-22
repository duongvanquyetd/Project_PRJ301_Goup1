<%-- 
    Document   : header_mainpage
    Created on : Mar 14, 2025, 7:27:34 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <style>
        body{
            margin: 0px;
            padding: 0px;
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


    </body>
</html>
