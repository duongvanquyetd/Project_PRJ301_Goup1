<%-- 
    Document   : Admin_managerHotel
    Created on : Feb 25, 2025, 1:44:06 PM
    Author     : Lenovo
--%>

<%@page import="Object.HotelImageDTA"%>
<%@page import="Object.HotelImageDAO"%>
<%@page import="Object.HotelDTA"%>
<%@page import="java.util.List"%>
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

        th{
            color: white;
            background-color: grey;
            width:33%;
            padding: 8px 0px;
        }
        input{
            padding:5px 10px;
        }
    </style>
    <body>
        <jsp:include page="admin_header.jsp"></jsp:include>
            <table style="width:100%; padding: 50px 100px;text-align:    center;">
                <tr>

                    <th style="width:50%">Khách sạn </th>
                    <th style="width:30%">Hotel Owner </th>
                    <th style="width:20%"> </th> 

                </tr>
            <%

                List<HotelDTA> listA = (List<HotelDTA>) request.getAttribute("listA");
                List<HotelImageDTA> listB = (List<HotelImageDTA>) request.getAttribute("listB");
                for (HotelDTA h : listA) {


            %>
            <tr style="box-shadow: 0px 0px 5px #333" >
                <td>
                    <div style="display:flex;padding: 5px;box-sizing: border-box">
                        <div style="width:40%" class ="anh">

                            <%                                for (HotelImageDTA hi : listB) {
                                    if (h.getHotelID().equals(hi.getHotelID())) {
                            %>
                            <img style="width:250px;height:150px "  src="<%= hi.getImage().get(0)%>">
                            <%
                                    }
                                }

                            %>

                        </div> 
                        <div style="width:60%;text-align: start;margin-left: 40px" class="conten">
                            <h1 style="font-size: 20px">
                                <%= h.getNameHotel()%>
                            </h1>
                            <div>
                                <img style="width:120px" src="<%= h.getRateHotel() %>">
                           
                            </div>
                            <div  style="margin-top:20px;color: grey">
                                <%= h.getStreets() + ", " + h.getDistrict() + ", " + h.getCity()%>
                            </div>


                        </div>

                    </div>
                </td>
                <td>



                    <%= h.getPersonID()%>


                </td>
                <td >
                    <div style="display:flex;justify-content: center;gap:40px;align-items: center;">

                        <a  href="adminmanagerhotel?hotelid=<%= h.getHotelID() %>"><img style="width:40px"  src="image/appove.jpg"></a>
                        <a  href="#"><img style="width:40px"  src="image/rejec.png"></a> 
                    </div>

                </td> 

            </tr>
            <%}%>


        </table>

    </body>
</html>
