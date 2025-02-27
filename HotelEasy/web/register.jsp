<%-- 
    Document   : register
    Created on : Feb 16, 2025, 1:21:25 PM
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
        .all_login{
            border-radius: 15px;
            flex:1;
            display: flex;
            box-shadow: 0px 0px 5px black;
            position: absolute;
            top:100px;
        }
        .form_login{

            width:400px;
            height:480px;
            text-align: center;
            background-color: white;
            marigin-left:0px 10px;
        }
        .form_input{

            box-sizing: border-box;
            display: flex;
            align-items: center;
            margin-left: 48px;


        }
        .form_input input{
            width: 240px;
            height:23px;
            border-left: none;


        }
        .img{
            width: 500px;
            height:480px;

        }
        .img img{
            width: 100%;
            height:100%;
            border-radius: 15px;
            border-right: none;
        }
        body{
            background-color:white;
            text-align: center;
            justify-content: center;
            display: flex;
        }

        .button input{
            padding: 5px 20px;
            background-color: #333;
            color:white;
            padding: 5px 130px;
            font-size: large;
        }
        h1{

            border-color: white;
            padding:15px;
            margin-top: 0px;
            background-color: #333;
            color:white;
        }
        .form_input_image img{
            width: 35px;

        }
        .message{
            font-size: 12px;
            color:red;
            width:fit-content;
            margin-left: 80px;
        }  

    </style> 
    <body>


        <div class='all_login'>
            <div class='img'>

                <img src='image/welcom.jpg'>

            </div> 
            <div class='form_login'>
                <h1>Register</h1>
                <form action='RegisterServlet' method='get'accept-charset="UTF-8">
                    <div class='form_input'><div class='form_input_image'><img src='image/User.jpg'></div> <div><input type="text" name ="user" placeholder="Nhập tên tài khoản" ></div></div>



                    <%

                        String username = (String) request.getAttribute("username");
                        if (username != null) {
                            if (username.equals("empty")) {
                    %>
                    <div class="message">Không được để trống !</div>

                    <%
                    } else if (username.equals("same")) {
                    %>
                    <div class="message">Tên này  đã được sử dụng</div>
                    <%
                            }
                        }

                    %>






                    <div class="form_input"><div class='form_input_image'><img src='image/pass.jpg'></div>  <div><input type ="password" name ='password' placeholder="Nhập mật khẩu" ></div></div>
                            <%                         String password = (String) request.getAttribute("password");

                                if (password != null) {
                                    if (password.equals("empty")) {
                            %>
                    <div class="message">Không được để trống !</div>

                    <%
                    } else if (password.equals("notsuitable")) {
                    %>
                    <div class="message">Password phải từ 6 tới 18 kí tự chứa cả chữ và số </div>
                    <%
                            }

                        }

                    %>

                    <div class="form_input"><div class='form_input_image'><img src='image/pass.jpg'></div>  <div><input type ="password" name ='confirmpassword' placeholder="Nhập lại  mật khẩu" ></div></div>
                            <%                        String confirmpassword = (String) request.getAttribute("confirmpassword");

                                if (confirmpassword != null) {
                                    if (confirmpassword.equals("empty")) {
                            %>
                    <div class="message">Không được để trống !</div>

                    <%
                    } else if (confirmpassword.equals("notmatch")) {
                    %>
                    <div class="message">Password và ConfirmPassword not match</div>
                    <%
                            }

                        }

                    %>




                    <div class="form_input"><div class=''><img style='width:25px' src='image/name.jpg'></div>  <div><input style="margin-left:9px" type ="text" name ='name' placeholder="Nhập Họ và Tên " ></div></div>
                            <%                         String name = (String) request.getAttribute("name");

                                if (name != null) {
                                    if (name.equals("empty")) {
                            %>
                    <div class="message">Không được để trống !</div>

                    <%
                            }
                        }
                    %>


                    <div class="form_input"><div class='form_input_image'><img src='image/phone.jpg'></div>  <div><input type ="text" name ='phone' placeholder="Nhập số điện thoại" ></div></div>

                    <%
                        String phone = (String) request.getAttribute("phone");

                        if (phone != null) {
                            if (phone.equals("empty")) {
                    %>
                    <div class="message">Không được để trống !</div>

                    <%
                            }
                        }
                    %>





                    <div class="" style="display:flex;margin-left: 140px">
                        <div style="color:rgb(26,188,156)">
                            Đăng ký làm : 
                        </div>
                        <select name="role">
                            <option value="R2">User</option>
                            <option value='R3'> Hotel Owner</option>
                        </select></div>
                    <div style='display:flex;margin-left: 90px;align-items: center'class="">


                        <div class=''><img style="width:35px"   src='image/male.webp'></div>  <div><input style='width:30px' type ="radio" name ='gender' value="M" checked></div>
                        <div class='' style='margin-left: 50px;'><img style="width:40px" src='image/female.jpg'></div>  <div><input type ="radio" name ='gender' value="F"></div>

                    </div>
                    <div class ="button">
                        <input type='submit' value='Register'> </div>



                </form>
            </div>
        </div> 
    </body>
</html>
