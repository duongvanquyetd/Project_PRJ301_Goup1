<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Header</title>
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

            .container-header {
                background-color: #333;
                color: #fff;
                padding: 10px 0;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .header-logo img {
                width: 50px;
                height: 50px;
                margin-left: 20px;
                border-radius: 50%;
            }

            .header-log img:hover {
                transform: scale(1.1);
            }

            .header-nav {
                display: flex;
                justify-content: space-evenly;
                align-items: center;
            }

            .header-nav a {
                color: #fff;
                text-decoration: none;
                font-size: 16px;
                margin: 20px;
            }

            .header-nav a:hover {
                color: #ff6347;
            }

            .header-account a {
                color: #fff;
                text-decoration: none;
                margin-left: 20px;
                font-size: 16px;
                margin-right: 20px;
            }

            .header-account a:hover {
                color: #ff6347;
            }
        </style>

    </head>

    <body>
        <!--Header-->
        <header>
            <div class="container-header">
                <div class="header-logo">
                    <a href=""><img src="https://i.pinimg.com/736x/bd/dd/40/bddd40355e08a41ae93bfbe21ae9ed1c--jouer-cream.jpg"
                                    alt=""></a>
                </div>

                <div class="header-nav">
                    <a href="">Report Revenue</a>
                    <a href="">Manager Hotel</a>
                    <a href="">Register Hotel</a>
                </div>

                <% String name =(String) request.getAttribute("name");
                   %>
                <div class="header-account">
                    <a href="">Seller ${name}></a>
                    <a href="">Logout</a>
                </div>
            </div>
        </header>
        <!--End Header-->
    </body>

</html>