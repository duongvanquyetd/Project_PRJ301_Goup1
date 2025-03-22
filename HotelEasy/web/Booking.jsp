<%-- 
    Document   : Booking
    Created on : Mar 1, 2025, 3:43:47 PM
    Author     : Lenovo
--%>

<%@page import="Object.RoomImageDAO"%>
<%@page import="Object.HotelImageDAO"%>
<%@page import="Object.RoomDTO"%>
<%@page import="Object.HotelDTO"%>
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
            width:480px;
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
            <div class="step " data-text="Đợi xác nhận">✔</div>
        </div>


        <div class="conten">


            <form action="Booking">
                <div class="all-form">
                    
                   
                    <div class="form-left" style="width:50%">  
                       

                        <%
                            String action = request.getParameter("type");

                        
                            if (action != null && action.equals("datho")) {

                        %>
                        
                        <input  type="hidden" value="datho" name="type">
                        <div style="box-shadow: 0px 0px 5px black;padding: 20px;border-radius: 15px">
                             <h3> Thông tin người đặt</h3>
                            <div class="form-left-sub" >
                                <div>Name: </div>
                                <input type="text" name="name" value="${requestScope.name}">
                            </div>


                            <div class="form-left-sub">
                                <div>Phone:</div>
                                <input type="number" name="phone" value="${requestScope.phone}">

                            </div>
                            <div style="color:red">      

                                ${requestScope.loi}

                            </div>
                        </div>
                        <%}%>



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
                    <%
                        HotelDTO h = (HotelDTO) request.getAttribute("hotel");
                        RoomDTO r = (RoomDTO) request.getAttribute("room");
                        HotelImageDAO hi = new HotelImageDAO();
                        RoomImageDAO ri = new RoomImageDAO();
                    %>
                    <input  type="hidden" value="<%= r.getHotelID()%>" name="hotelid">
                    <input  type="hidden" value="<%= r.getRoomID()%>" name="roomid">
                    <div class="form-right">
                        <h3 style="text-align: center;margin-top: 5px;color: #0056b3">Thông tin phòng</h3>
                        <div class="header-room">
                            <h2 style="margin:0px;color: #0a1f36"><%= h.getNameHotel()%></h2>
                            <div>   <img style="width:100px;" src="<%= h.getRateHotel()%>"></div>


                        </div>
                        <div style="margin-left:20px">
                            <h5 style="margin:5px;color:grey"><%= h.getStreets() + "," + h.getDistrict() + "," + h.getCity()%></h5>

                        </div>

                        <div> 
                            <img class="room-image" src="<%= ri.getImageRoom(r.getHotelID(), r.getRoomID()).get(0)%>">
                        </div>

                        <div class="detail-room">
                            <h4 style="margin:0px 0px 0px 8px">Chi tiết đặt phòng</h4>

                            <div class="conten-room">
                                <div>
                                    Kiểu phòng: <%= r.getTypeRoom()%>

                                </div>
                                <div>
                                    Số lượng người lớn:


                                    <select name ="numberofadult">
                                        <%for (int i = 1; i <= r.getCapacityAdult(); i++) {%>
                                        <option value="<%=i%>"> <%=i%> </option>
                                        <%}%>

                                    </select>  



                                </div>

                                <div>

                                    Số lượng trẻ em: 
                                    <select name ="numberofchildren">
                                        <%for (int i = 1; i <= r.getCapacityChild(); i++) {%>
                                        <option value="<%=i%>"> <%=i%> </option>
                                        <%}%>



                                    </select>  

                                </div>
                                <div> Gia tiền Thuê;      <input style="border: none;font-size: large;width: 100px" type="number" value ="<%= r.getPrice()%>" id ="price" readonly >VND/Mỗi Đêm</div>

                            </div>

                            <div class="time">

                                <div>
                                    Ngày Nhận Phòng
                                    <input type="date" class="search-input" name="DepatureDay"  id="startDate">
                                </div>
                                <div>
                                    Ngày trả Phòng
                                    <input type="date" class="search-input"  name="Arriveddate" id ="endDate">
                                </div>
                            </div>

                            <div style="color:red;margin-left: 20px">      

                                ${requestScope.mess}

                            </div>


                        </div>



                        <div class="footer-room">
                            Tổng Tiền:
                            <span id="totalPrice">

                            </span>     VND
                            
                           <div> <input type="hidden" name="price" value="" id="pricehidden"></div>
                            <div>
                                <input  type="hidden" value="book" name="action">
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
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            let today = new Date().toISOString().split('T')[0]; // Lấy ngày hôm nay theo định dạng YYYY-MM-DD
            let startDateInput = document.getElementById("startDate");
            let endDateInput = document.getElementById("endDate");

            // Đặt giá trị min cho startDate (chỉ cho phép chọn từ hôm nay trở đi)
            startDateInput.min = today;

            startDateInput.addEventListener("change", function () {
                let startDate = new Date(this.value);
                if (isNaN(startDate))
                    return; // Nếu ngày không hợp lệ, thoát

                let maxEndDate = new Date(startDate);
                maxEndDate.setDate(maxEndDate.getDate() + 15); // Ngày tối đa là 15 ngày sau

                // Gán min/max cho endDate
                endDateInput.min = this.value;
                endDateInput.max = maxEndDate.toISOString().split('T')[0];

                // Reset endDate nếu đã chọn trước đó mà không hợp lệ
                if (endDateInput.value < endDateInput.min || endDateInput.value > endDateInput.max) {
                    endDateInput.value = "";
                }
            });
        });


        function calculateTotal() {
            let startDate = new Date(document.getElementById("startDate").value);
            let endDate = new Date(document.getElementById("endDate").value);
            let pricePerDay = parseFloat(document.getElementById("price").value) || 0;

            if (isNaN(startDate) || isNaN(endDate) || endDate < startDate) {
                document.getElementById("totalPrice").textContent = "0";
                return;
            }

            let days = (endDate - startDate) / (1000 * 60 * 60 * 24); // Tính số ngày
            let total = days * pricePerDay;

            document.getElementById("totalPrice").textContent = total.toLocaleString(); // Hiển thị số có dấu phân tách
            document.getElementById("pricehidden").value =total;
        }

        document.getElementById("startDate").addEventListener("change", calculateTotal);
        document.getElementById("endDate").addEventListener("change", calculateTotal);
        document.getElementById("price").addEventListener("input", calculateTotal);
    </script>

</html>
