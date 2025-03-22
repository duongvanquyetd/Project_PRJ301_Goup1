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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final static String Login_Page = "login.jsp";
    private final static String Register_Page = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");

            String url = Login_Page;
            if(action == null || action.isEmpty())
            {
                url = Login_Page;
            }
          else  if (action.equals("login")) {
                String user = request.getParameter("user");
                String pass = request.getParameter("password");
                PersonDAO p = new PersonDAO();
                PersonDTO pe = p.Login(user, pass);

                if (pe != null) {
                    HttpSession session = request.getSession(true);
                    if (pe.getRoleName().equalsIgnoreCase("Admin")) {

                        session.setAttribute("adminsession", pe);
                        session.setAttribute("role", pe.getRoleName());
                        url = "AdminController?action=";
                    } else if (pe.getRoleName().equalsIgnoreCase("owner")) {

                        session.setAttribute("ownersession", pe);
                        session.setAttribute("role", pe.getRoleName());
                        url = "HotelOwnwerController";
                    } else if (pe.getRoleName().equalsIgnoreCase("user")) {

                        session.setAttribute("usersession", pe);
                        session.setAttribute("role", pe.getRoleName());
                        url = "UserController";
                    }

                } else {
                    request.setAttribute("status", "false");
                    url = Login_Page;
                }
            } else if (action.equals("logout")) {
                HttpSession session = request.getSession(false);

                if (session != null) {
                    session.invalidate();
                }
                url = Login_Page;

            } else if (action.equals("register")) {
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

                } else if (p.CheckUserName(user)) {
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

                } else if (!password.equals(confirmpassword)) {
                    request.setAttribute("confirmpassword", "notmatch");

                }
                if (name.isEmpty()) {
                    cout++;
                    request.setAttribute("name", "empty");

                }

                if (phone.isEmpty()) {
                    cout++;
                    request.setAttribute("phone", "empty");

                }
                if (cout > 0) {
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {

                    PersonDTO pe = new PersonDTO(user, password, name, gender, phone, roleid);
                    p.RegisterPerson(pe);
                    url = Login_Page;
                }
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
