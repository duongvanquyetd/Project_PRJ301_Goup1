<%-- 
    Document   : Header_Search
    Created on : Mar 20, 2025, 8:38:12 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>    .search-bar {
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

        .search-input:focus, #room-type:focus, #startDate:focus, #endDate:focus {
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
    </style>

    <body>
        <div class="search-bar">

                <div class="search-container">
            <form action = "search" method="get">
                    <div>
                        <div style="color: white;font-weight: bolder">Tên dịa diểm hoặc khách sạn</div>
                        <input oninput="find(this)"   class="search-input" placeholder="Location or hotel name" type="text" name="location" value="${requestScope.location}">
                    </div>

                </div>
                <div class="search-container">

                    <div>
                        <div style="color: white;font-weight: bolder">Ngày Nhận Phòng</div>
                        <input type="date" class="search-input" name="DepatureDay" value="${requestScope.depaturedate}" id="startDate">
                    </div>
                    <div>
                        <div style="color: white;font-weight: bolder">Ngày trả Phòng</div>
                        <input type="date" class="search-input"  name="Arriveddate" id ="endDate" value="${requestScope.arrivedate}">
                    </div>


                </div>
                <div class="search-container">

                    <div>
                        <div style="color: white;font-weight: bolder">Số người</div>
                        <input type="text" oninput="find2(this)" class="search-input" name="numberofperson" placeholder="số người" value="${requestScope.numberofperson}">
                    </div>    

                </div>
                <div>
                    <input id="search-btn"  type="submit" value="Search"> 
                </div>

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



    </script>
</html>
