<%-- 
    Document   : Search
    Created on : Mar 14, 2025, 7:16:43 AM
    Author     : Lenovo
--%>

<%@page import="Object.HotelImageDAO"%>
<%@page import="Object.HotelDTO"%>
<%@page import="Object.FeatureHotelDAO"%>
<%@page import="Object.FeatureHotelDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Object.HotelImageDTA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <style>
        body{
            margin: 0px 50px;
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
            margin-top: 20px;
            padding:10px 30px;
            background-color: #007bff;
            color: #fff;

            border-radius: 5px;

        }

        #search-btn:hover {
            background-color: #0056b3;
            transform: translateY(-2px); /* Hiệu ứng nổi lên khi hover */
        }


        /* left-serch Bar */

        .left-search{
            width: 20%;
            margin: 0px 20px 0px 200px; 

            box-shadow: 0px 0px 5px gray;
            padding:9px;
            height: fit-content;


        }
        .sub-left{
            box-shadow: 0px 0px 5px black;
            padding: 10px ;
            margin-top: 20px;
        }
        .commen,.feature,.location,.star,.content{
            font-size: 18px;
            padding:5px 0px;
            color:#28a745
        }
        .right-search{
            width: 55%;
            box-shadow: 0px 0px 5px black;
            padding:10px;

        }
        .alll-search{
            display: flex;

        }
        .anh{
            width: 30%;
            padding: 2px 2px 0px 2px;
        }
        .anh img{
            width: 100%;
            height: 150px;
        }
        .sub-right-search{
            display: flex;
            box-shadow: 0px 0px 5px black;
            margin-top:20px;

        }

        .sub-content-rights-search div{
            margin: 13px;
        }
        .sosao img{
            width: 150px;


        }

        .nameks{
            font-size: large;
            font-weight:  bold;
        }
        .diachi{
            color: grey;
        }

        .giatien {
            width: 500px;
            font-size: larger;
            color: orange;
            font-weight: bolder;
            text-align: end;

        }
        .discoutn {
            position: absolute;
            margin-top: -150px;
            background-color: red;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            font-weight: bold;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.5);
        }
        .buton{
            background-color: blue;
            color: white;
            border-radius: 10px;
            padding: 5px 10px;
            width: fit-content;

        }
        .buton:hover {
            background-color: #0056b3;
            transform: translateY(2px); /* Hiệu ứng nổi lên khi hover */
        }

    </style>
    <body>

        <jsp:include page="header_mainpage.jsp"></jsp:include>

            <form action = "search" method="get">



                <div class="search-bar">

                    <div class="search-container">

                        <div>
                            <div style="color: white;font-weight: bolder">Tên dịa diểm hoặc khách sạn</div>
                            <input oninput="find(this)"   class="search-input" placeholder="Location or hotel name" type="text" name="location" value="${requestScope.location}">
                    </div>

                </div>
                <div class="search-container">

                    <div>
                        <div style="color: white;font-weight: bolder">Ngày Nhận Phòng</div>
                        <input type="date" class="search-input" name="Arriveddate" value="${requestScope.Arriveddate}">
                    </div>
                    <div>
                        <div style="color: white;font-weight: bolder">Ngày trả Phòng</div>
                        <input type="date" class="search-input"  name="check-out">
                    </div>


                </div>
                <div class="search-container">

                    <div>
                        <div style="color: white;font-weight: bolder">Số người</div>
                        <input type="text" oninput="find(this)" class="search-input" name="numberofperson" placeholder="số người" value="${requestScope.numberofperson}">
                    </div>    

                </div>
                <div>
                    <input id="search-btn"  type="submit" value="Search"> 
                </div>

            </div>



            <%
                List<HotelDTO> list = (List<HotelDTO>) request.getAttribute("List");
                HotelImageDAO d = new HotelImageDAO();

            %>


            <div class="alll-search">

                <div class="left-search">
                    <div class="content"> Tìm kiếm theo : </div>
                    <div class="sub-left">


                        <div class="location">Địa chỉ </div>

                        <% for (HotelDTO h : list) {%>
                        <div>  <input type="checkbox" oninput="find2(this)" value="<%= h.getStreets() + "," + h.getDistrict()%>" name="listlocation" > <%= h.getStreets() + "," + h.getDistrict()%></div>     <%  //nếu có thời gian sẽ làm sau mỗi cái tìm kiêm này sẽ là số lượng sẽ tìm kiếm được nếu ấn vào%>
                            <% } %>

                    </div>
                    <div class="sub-left">
                        <div class="star">  Lọc theo số sao  </div>
                        <div>  <input type="checkbox" value="image/Star/1sao.png" name="star">  <img src="image/Star/1sao.png">  </div>
                        <div>  <input type="checkbox" value="image/Star/2sao.png" name="star">    <img src="image/Star/2sao.png"> </div>
                        <div>  <input type="checkbox" value="image/Star/3sao.png" name="star">    <img src="image/Star/3sao.png"></div>
                        <div>  <input type="checkbox" value="image/Star/4sao.png" name="star">    <img src="image/Star/4sao.png"> </div>
                        <div>  <input type="checkbox" value="image/Star/5sao.png" name="star">   <img src="image/Star/5sao.png">  </div>

                    </div>
                    <div class="sub-left">
                        <div class="feature">Tiện ich Khách sạn  </div>



                        <% 
                            FeatureHotelDAO f = new FeatureHotelDAO();

                            List<String> fe = f.getFeatureHotelByHotelID(list);
                            for (String ft : fe) {%>

                        <div>  <input type="checkbox" value="<%= ft%>" name="feature">  <%= ft%> </div>
                            <%
                                }
                            %> 






                    </div>


                </div>

                <input type="hidden" value="moresearch" name="action">
                </form> 


                <div class="right-search">


                    <h2 style="color:green;margin-top: 0px ;padding-top:0px;">Khach san</h2> 
                    <div>  <a href="search?action=moresearch&sortCol=price">Sắp Xếp theo giá tiền </a></div>
                    <div id="result">






                        <%
                            for (HotelDTO ho : list) {

                        %>

                        <div class="sub-right-search" >





                            <div class="anh">

                                <img src="<%= d.getImgByHotelID(ho.getHotelID()).get(0)%>">

                                <div  class="discoutn"> Tiết Kiệm <%= ho.getDiscount()%></div>

                            </div>

                            <div class="sub-content-rights-search">

                                <div class="sosao">
                                    <img src="<%= ho.getRateHotel()%>">

                                </div> 
                                <div class="nameks">

                                    <%= ho.getNameHotel()%>

                                </div>
                                <div class="diachi">

                                    <%= ho.getStreets() + "," + ho.getDistrict() + "," + ho.getCity()%>
                                </div>

                                <div  class="giatien">

                                    <%= ho.getPrice()%>/Mỗi Đêm


                                </div>


                            </div>  



                        </div>

                        <%}%>
                    </div>



                    <div class="buton">

                        LoadMore

                    </div> 


                </div>







            </div>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>

        var r = document.getElementById("result");
        function find(param) {
            var v = param.value;
            $.ajax({
                url: "UserController",
                type: "get",
                data: {txt: v}, // Sửa lại cú pháp ở đây
                success: function (data) {
                    r.innerHTML = data;
                },
                error: function (err) {
                    console.error("Lỗi khi gửi yêu cầu AJAX:", err);
                }
            });
        }

function find2(param) {
            var v = param.value;
            $.ajax({
                url: "UserController?action=more",
                type: "get",
                data: {txt: v}, // Sửa lại cú pháp ở đây
                success: function (data) {
                    r.innerHTML = data;
                },
                error: function (err) {
                    console.error("Lỗi khi gửi yêu cầu AJAX:", err);
                }
            });
        }



    </script>

</html>
