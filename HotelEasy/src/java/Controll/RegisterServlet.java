/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.PersonDAO;
import Object.PersonDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");


            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("user").trim();
            String password = request.getParameter("password").replaceAll(" ", "");
            String confirmpassword = request.getParameter("confirmpassword").replaceAll(" ", "");
            String name = request.getParameter("name").trim();
            String phone = request.getParameter("phone").replaceAll(" ", "");
            String roleid = request.getParameter("role");
            String gender = request.getParameter("gender");
            PersonDAO p = new PersonDAO();
            

            
            int cout = 0;
            if (user.isEmpty()) {
                request.setAttribute("username", "empty");
               cout++;
               
            } else  if (p.CheckUserName(user)) {
                  cout++;
                request.setAttribute("username", "same");
                
            }  
            
            if (password.isEmpty()) {
                  cout++;
                request.setAttribute("password", "empty");
                
            } else if (!p.checkPassword(password)) {
                  cout++;
                request.setAttribute("password", "notsuitable");
                

            }  
            
            
            
            if (confirmpassword.isEmpty()) {
                  cout++;
                request.setAttribute("confirmpassword", "empty");
                
            }  else if (!password.equals(confirmpassword)) {
                request.setAttribute("confirmpassword", "notmatch");
                
            } 
            if(name.isEmpty()){
                  cout++;
                request.setAttribute("name", "empty");
                
            }
            
            
            
            if (phone.isEmpty()) {
                  cout++;
                request.setAttribute("phone", "empty");
                
            } 
            if (cout > 0 )
            {
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else{
            out.print(user + "///" + password + "//" + confirmpassword + "//" + name + "//" + phone + "//" + roleid + "//" + gender);
               PersonDTO  pe = new PersonDTO(user, password, name, gender, phone, roleid);
               
               p.RegisterPerson(pe);
            }
            

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
