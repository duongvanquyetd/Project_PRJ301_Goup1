<%-- 
    Document   : admin_header
    Created on : Feb 25, 2025, 1:41:32 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        .menu a {
            text-decoration: none;
            color: black; /* Màu mặc định */
            padding: 10px;
            display: inline-block;
        }

        .menu a.active {
            color: #ff6347; /* Màu khi được chọn */
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo"><img src="image/User.jpg"></div>
        <div class="menu">
            <div><a href="AdminController" class="link">Report</a></div>
            <div><a href="AdminController?action=ManagerHotel" class="link">Manager Hotel</a></div>
            <div><a href="AdminController?action=ManagerAccount" class="link">Manager Account</a></div>
        </div>
        <div>Hi Admin | <a href="login.jsp">Logout</a></div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            let links = document.querySelectorAll(".menu a");

            // Lấy giá trị liên kết đã chọn từ localStorage
            let activeLink = localStorage.getItem("activeLink");

            // Nếu có giá trị, áp dụng class "active"
            if (activeLink) {
                links.forEach(link => {
                    if (link.getAttribute("href") === activeLink) {
                        link.classList.add("active");
                    }
                });
            }

            // Thêm sự kiện click cho từng liên kết
            links.forEach(link => {
                link.addEventListener("click", function() {
                    // Xóa class "active" khỏi tất cả liên kết
                    links.forEach(l => l.classList.remove("active"));

                    // Thêm class "active" vào liên kết được nhấn
                    this.classList.add("active");

                    // Lưu liên kết đã chọn vào localStorage
                    localStorage.setItem("activeLink", this.getAttribute("href"));
                });
            });
        });
    </script>
</body>
</html>
