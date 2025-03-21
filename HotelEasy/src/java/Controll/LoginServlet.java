/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.PersonDAO;
import Object.PersonDTA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("user");
            String pass = request.getParameter("password");
            PersonDAO p = new PersonDAO();
            PersonDTA pe = p.Login(user, pass);

            String url = "login.jsp";
            String action = request.getParameter("action");

            if (action == null || action.isEmpty()) {

                if (pe != null) {
                    HttpSession session = request.getSession(true);
                    if (pe.getRoleName().equalsIgnoreCase("Admin")) {

                        session.setAttribute("adminsession", pe);
                        url = "AdminController";
                    } else if (pe.getRoleName().equalsIgnoreCase("owner")) {
                        
                        session.setAttribute("ownersession", pe);
                        url = "HotelEditController";
                    } else if (pe.getRoleName().equalsIgnoreCase("user")) {
                   
                        session.setAttribute("usersession", pe);
                        url = "./MainPage_1.jsp";
                    }

                } else {
                    request.setAttribute("status", "false");
                    url = "login.jsp";
                }
            } else if (action.equals("logout")) {
                HttpSession session = request.getSession(false);

                if (session != null) {
                    session.invalidate();
                }
                url = "login.jsp";

            }

            request.getRequestDispatcher(url).forward(request, response);
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
