<%-- 
    Document   : login
    Created on : Feb 16, 2025, 11:46:07 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <style>
        .all_login{
            border-radius: 15px;
            flex:1;
            display: flex;
            box-shadow: 0px 0px 5px black;
            position: absolute;
            top:200px;
        }
        .form_login{

            width:400px;
            height:310px;
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
            height:300px;
        }
        .img img{
            width: 100%;
            border-radius: 15px;
        }
        body{
            background-color: white;
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
            color:red;
            font-size: 13px;
            display: flex;
            margin-left: 60px;
            margin-bottom: 20px;
        }
    </style> 
    <body>


        <div class='all_login'>
            <div class='img'>

                <img src='image/welcom.jpg'>

            </div> 
            <div class='form_login'>
                <h1>Login</h1>
                <form action='LoginServlet' method='post'>
                    <div  style="margin-bottom: 20px" class='form_input'><div class='form_input_image'><img src='image/User.jpg'></div> <div><input type="text" name ="user" placeholder="Nhập tên tài khoản" ></div></div>
                    <div class="form_input"><div class='form_input_image'><img src='image/pass.jpg'></div>  <div><input type ="password" name ='password' placeholder="Nhập mật khẩu" ></div>  </div>

                    <%

                        String status = (String) request.getAttribute("status");

                        if (status != null) {
                            if (status.equals("false")) {

                    %>

                    <div class="message">

                        <div > Username or Password wrong !</div>

                    </div>

                    <%                            }
                        }

                    %>



                    <div class ="button">
                        <input type='submit' value='Login'>              
                    </div>
                    <div style='margin-top: 20px;color: rgb(26,188,156)'> 
                        Don't have a account? <a href="#">SignUp Now</a>
                    </div>


                </form>
            </div>
        </div> 
    </body>
</html>