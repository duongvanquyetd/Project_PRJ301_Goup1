<%-- 
    Document   : Pay
    Created on : Mar 3, 2025, 8:06:15 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đường trạng thái</title>
    <style>
        .progress-container {
            display: flex;
            justify-content: space-between;
            width: 80%;
            margin: 20px auto;
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
        .img{
            margin:40px auto; 
            display: flex;
            
            width: 50%;
            height:400px;
        }
        .img img{
            width: 100%;
        }
        .conten{
            display: flex;
            justify-content: center;
           font-size: x-large;
           color:#0056b3
        }
    </style>
</head>
<body>

<div class="progress-container">
    <div class="step active" data-text="Xác nhận">✔</div>
    <div class="step active" data-text="Thanh toán">✔</div>
    <div class="step " data-text="Thành công">✔</div>
</div>
 
   
    <div class="img">
        <img src="image/Banerr.jpg">
    </div>
    
     <div class="conten">
        
        
        Nội dung chuyển khoản : mã phòng + mã khách sạn
    </div>
    
</body>
</html>

</html>
