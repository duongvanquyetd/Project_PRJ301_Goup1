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
            <div><a href="AdminController" class="link ">Report</a></div>
            <div><a href="AdminController?action=ManagerHotel" class="link">Manager Hotel</a></div>
            <div><a href="AdminController?action=ManagerAccount" class="link">Manager Account</a></div>
        </div>
        <div>Hi Admin ${sessionScope.adminsession.name} | <a href="LoginServlet?action=logout">Logout</a></div>
    </div>

    <script>
    document.addEventListener("DOMContentLoaded", function() {
        let links = document.querySelectorAll(".menu a");

        // Mặc định chọn "Report" nếu chưa có giá trị trong localStorage
        let activeLink = localStorage.getItem("activeLink") || "AdminController";
        localStorage.setItem("activeLink", activeLink); // Đảm bảo luôn có giá trị hợp lệ

        // Áp dụng class "active" cho link phù hợp
        links.forEach(link => {
            if (link.getAttribute("href") === activeLink) {
                link.classList.add("active");
            }
        });

        // Sự kiện click: Cập nhật trạng thái active khi chọn link mới
        links.forEach(link => {
            link.addEventListener("click", function() {
                links.forEach(l => l.classList.remove("active")); // Xóa active cũ
                this.classList.add("active"); // Gán active mới
                localStorage.setItem("activeLink", this.getAttribute("href")); // Lưu vào localStorage
            });
        });
    });
</script>

</body>
</html>
