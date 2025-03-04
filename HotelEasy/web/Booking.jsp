<%-- 
    Document   : Booking
    Created on : Mar 1, 2025, 3:43:47 PM
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

        }

        .form-left-sub{
            text-align: center;display:flex;
            margin-bottom: 20px;
        }
        .form-left-sub input{
            width: 200px;
            margin-left:50px;
        }
        form{
            margin:0px 100px;
        }
        .form-left-content span{
            font-size: 19px;
            text-align:  justify;
            text-justify: auto;
        }
        .all-form{
            display: flex;
            gap:100px;

        }
        .header-room{
            display:flex;
            justify-content: space-between;
            margin: 0px 20px;
        }
        .form-right{
            width:39%;
            border-radius: 15px;
            box-shadow: 0px 0px 5px #333;

        }
        .conten-room,.time{
            margin-left:10px; 

        }     
        .conten-room div, .time div{
            margin-bottom:10px;
        }
        .footer-room{
            display:flex; 
            justify-content: space-around;
            background-color: #0056b3;
            align-items: center;
            color: white;
            font-size: larger;
            width: fit-content;

            padding-left:10px;
            border-radius: 10px;
            margin: 20px 0px 20px 10%;

        }
        .detail-room{
            box-shadow: 0px 0px 5px;
            margin:0px 15px 0px 20px;
            padding:10px 0px;
            box-sizing: border-box;
            border-radius: 10px;

        }
        .room-image
        {
            width:425px;
            height:200px;
            margin:0px 20px;
            box-shadow: 0px 0px 5px;
            box-sizing: border-box;

        }
        .progress-container {
            display: flex;
            justify-content: space-between;
            width: 80%;
            margin: 40px auto;
            position: relative;
        }

        .progress-container::before {
            content: "";
            position: absolute;
            top: 50%;
            left: 0;
            width: 100%;
            height: 5px;
            background: #ddd;
            transform: translateY(-50%);
            z-index: -1;
        }

        .step {
            width: 30px;
            height: 30px;
            background: #ddd;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 14px;
            font-weight: bold;
            color: white;
            position: relative;
        }

        .step.active {
            background: #4CAF50;
        }

        .step::after {
            content: attr(data-text);
            position: absolute;
            top: 40px;
            font-size: 14px;
            color: black;
            white-space: nowrap;
        }
    </style>
    <body>




        <div class="progress-container">
            <div class="step active" data-text="Xác nhận">✔</div>
            <div class="step " data-text="Thanh toán">✔</div>
            <div class="step " data-text="Chấp nhận">✔</div>
        </div>


        <div class="conten">


            <form action="">
                <div class="all-form">
                    <div class="form-left" style="width:50%">  

                        <div style="box-shadow: 0px 0px 5px black;padding: 20px;border-radius: 15px">
                            <div class="form-left-sub" >
                                <div>Name: </div>
                                <input type="text" name="name">
                            </div>

                            <div class="form-left-sub">
                                <div>Email:</div>
                                <input type="text" name="Email">

                            </div>
                            <div class="form-left-sub">
                                <div>Phone:</div>
                                <input type="number" name="phone">

                            </div>
                        </div>



                        <div class="form-left-content">
                            <h3 style="color: #0056b3;">Chính sách lưu trú</h3>
                            <span>
                                <div>- Chính Sách Bổ Sung</div>
                                <div>- Trẻ em dưới 6 tuổi ở lại miễn phí nếu sử dụng giường hiện có.</div>
                                <div>- Trẻ em từ 6 đến dưới 12 tuổi (sử dụng giường hiện tại) sẽ được tính thêm khi nhận phòng.</div>
                                <div>- Trẻ em từ 12 tuổi trở lên được tính là người lớn và phải sử dụng thêm một chiếc giường.</div>
                                <div>- Phí của giường phụ phụ thuộc vào loại phòng bạn chọn.</div>
                                <div>- Tất cả các yêu cầu đặc biệt sẽ tuân theo tính khả dụng. Để biết thêm thông tin xin vui 
                                    lòng liên hệ với tài sản trước hoặc khi đến để xác nhận.</div>
                                <div>- Hướng dẫn nhận phòng</div>
                                <div>- Trẻ em dưới 6 tuổi ở lại miễn phí nếu sử dụng giường hiện có.</div>
                                <div>- Trẻ em từ 6 đến dưới 12 tuổi (sử dụng giường hiện tại) sẽ được tính thêm khi nhận phòng.</div>
                                <div>- Trẻ em từ 12 tuổi trở lên được tính là người lớn và phải sử dụng thêm một chiếc giường.</div>
                                <div>- Phí của giường phụ phụ thuộc vào loại phòng bạn chọn.</div>
                                <div>- Tất cả các yêu cầu đặc biệt sẽ tuân theo tính khả dụng. Để biết thêm thông tin xin vui lòng liên hệ với tài sản trước hoặc khi đến để xác nhận.</div>
                            </span>


                        </div> 


                    </div>

                    <div class="form-right">
                        <h3 style="text-align: center;margin-top: 5px;color: #0056b3">Thông tin phòng</h3>
                        <div class="header-room">
                            <h2 style="margin:0px;color: #0a1f36">Name khach san</h2>
                            <div>   <img style="width:100px;" src="image/Star/5sao.png"></div>


                        </div>
                        <div style="margin-left:20px">
                            <h5 style="margin:5px">địa chỉ khách sạn , sdfdsf,sfsdf</h5>

                        </div>

                        <div> 
                            <img class="room-image" src="image/Hotel10/R1/1.jpg">
                        </div>

                        <div class="detail-room">
                            <h4 style="margin:0px 0px 0px 8px">Chi tiết đặt phòng</h4>

                            <div class="conten-room">
                                <div>
                                    Kiểu phòng:

                                </div>
                                <div>
                                    Số lượng người lớn:


                                </div>

                                <div>
                                    Số lượng trẻ em:

                                </div>

                            </div>

                            <div class="time">

                                <div>
                                    Ngày Nhận Phòng :  

                                </div>
                                <div>

                                    Ngày trả Phòng:
                                </div>
                            </div>

                        </div>



                        <div class="footer-room">
                            <div>
                                Tổng Tiền: 54678789789897789
                            </div>
                            <div>
                                <input style="background-color: orangered;color:white;border-radius: 10px;padding: 8px 20px" type="submit" value="Thanh Toán">

                            </div>

                        </div>

                    </div>
                </div>

            </form>



        </div>

        <div class="footer">
            footer

        </div>
    </body> 
</html>
