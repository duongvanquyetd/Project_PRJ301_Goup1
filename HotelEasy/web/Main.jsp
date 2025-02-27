<%-- 
    Document   : Main
    Created on : Feb 24, 2025, 9:29:16 PM
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



        .header{
            margin: 0px;
            display: flex;
            justify-content: space-between;
        }  
        .header_logo img{
            width:40%; 
        }
        .header_menu {
            display:flex;
            gap:50px;
        }

        .banner img{
            width: 100%;
            padding: 0px 40px;
            box-sizing: border-box;

        }


    </style>
    <body>


        <div class="header">

            <div class="header_logo">
                <img src="image/logo.jpg">
            </div>


            <div class="header_menu">
                <div> <a herf="#">Home</a> </div>  
                <div>   <a herf="#">Manager</a> </div>  
                <div>  <a herf="#">Favority</a> </div>  


            </div> 

            <div>  <a herf="#">Login</a> | <a herf="#">Register</a> </div>  


        </div>  



        <div class="banner">
            <img src="image/Banerr.jpg">
            <div class="banner_serch">


                <div> 
                    <div> Nhập địa điểm hoặc tên khách sạn</div>
                            <input type="text" name="location" placeholder="Nhập dịa điểm hoặc tên khách sạn">

                        </div>


                        <div> 
                            <div> Ngày nhận phòng</div>
                                    <input type="date" name="ngaynhanphong" >

                                </div>


                                <div> 
                                    <div> Ngày trả phòng</div>
                                            <input type="date" name="ngaytraphong" >

                                        </div>

                                      <div> 
                                    <div>Số người</div>
                                            <input type="number" name="songuoi" >

                                        </div>
                <dv class="buton">
                    <input type="submit" value="Serch">
                </dv>
                                </div>




                                <div class="conten">
                                    <div class="content-menu">



                                        <div><a href="#">Khách sạn nổi bật nhất</a></div>
                                        <div><a href="#">Khách sạn đang giảm giá</a></div>
                                        <div><a href="#">Địa điểm đáng quan tâm</a></div>
                                    </div>



                                </div>


                                </body>
                                </html>
