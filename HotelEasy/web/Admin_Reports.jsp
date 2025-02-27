<%-- 
    Document   : Admin
    Created on : Feb 25, 2025, 8:53:27 AM
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
            display: flex;
            justify-content: space-between;
            background-color: #333;
            align-items:  center;

        }
        .menu{
            display: flex;
            margin-left: 150px;
            gap:80px;
        }
        .logo img{
            width:40px;
        }
        body{
            margin: 0px;
        }
        div a{
            color:white;

            text-decoration: none;
            margin-right: 10px;
        }
        .content {
            display:flex;
            flex-wrap: wrap;
        }
        .sub-content{
            display: flex;
            justify-content: center;
            width:100%;
            gap:100px;
            margin: 50px 0px;

        }
        .sub-content div{
            align-content: center;
            text-align: center;
            background-color:  gray;
            width:20%;
            height:100px;
            color:white;
        }
        .kq{
            color:white;
        }
    </style>

    <body>

        <jsp:include page="admin_header.jsp"></jsp:include>



            <div class="content">

            <%
                int nhotel = (int) request.getAttribute("nhotel");
                int nuser = (int) request.getAttribute("nuser");
                int nhotelowner = (int) request.getAttribute("nhotelowner");
                int nroom = (int) request.getAttribute("nroom");
                int nbooking = (int) request.getAttribute("nbooking");
                long nprice=(long)request.getAttribute("nprice");


            %>

            <div class="sub-content">
                <div>Tổng số khách sạn: <span class="kq"><%= nhotel %> </span> </div>
                <div>Tổng số phòng:  <span class="kq"> <%= nroom %></span> </div> 
            </div>




            <div class="sub-content">

                <div>Tổng số owner:  <span class="kq"><%= nhotelowner %> </span> </div>
                <div>Tổng số user:  <span class="kq"> <%= nuser %> </span></div>
            </div>

            <div class="sub-content">


                <div>Tổng số lượt booking: <span class="kq"><%= nbooking %> </span> </div>   
                <div>Tổng số tiền:  <span class="kq"><%= nprice %> </v>  VND</div> 
            </div>


        </div>





    </body>
</html>
