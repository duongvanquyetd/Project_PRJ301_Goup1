<%-- 
    Document   : Admin_ManagerAcount
    Created on : Feb 25, 2025, 2:03:08 PM
    Author     : Lenovo
--%>

<%@page import="Object.PersonDTO"%>
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
            background-color: grey;
            color : white;
            width: 15%;
             padding: 8px 0px;
        }
    </style>
    <body>
        <jsp:include page="admin_header.jsp"></jsp:include>
            <table style="width:100%; padding: 50px 100px;text-align: center;">
                <tr>
                    <th>STT </th>
                    <th>Tên tài khoản </th>
                    <th>Phone </th>
                    <th>Name </th> 
                    <th> HotelOwner</th>
                    <th> Gender</th>




                </tr>
            <%

             List<PersonDTO> list = (List<PersonDTO>) request.getAttribute("list");
                int i = 1 ; 
                for (PersonDTO p : list) {


            %>
            <tr style="margin-top: 100px;">
                
                <td>
                    <%=i++  %>
                </td>
                
                <td>
                    <div>
                        <%= p.getPersonid() %>
                    </div>
                </td>
                <td>
                    <%= p.getPhone() %>
                </td>
                <td>

                    <%= p.getName()  %>

                </td> 

                <td>
                    <%
                        if (p.getRoleName().equals("R2")) {
                    %>
                    No

                    <%
                    } else {
                    %>


                    Yes
                    <%}%>
                </td>
                <td>
                    <%= p.getGender() %>
                </td>
                <td>

                    <a  href="AdminController?action=ManagerAccount&userid=<%=p.getPersonid()  %>"><img style="width:40px"  src="image/delete.jpg"></a>
                </td>

            </tr>

            <%}%>

        </table>



    </body>
</html>
