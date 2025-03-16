/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.HotelDAO;
import Object.HotelDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

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

            String action = request.getParameter("action");
            HotelDAO h = new HotelDAO();
            String location = request.getParameter("location");
            String Arriveddate = request.getParameter("Arriveddate");
            String numberofperson = request.getParameter("numberofperson");
            String sortCol = request.getParameter("sortCol");
            String[] listlocation = request.getParameterValues("listlocation");
            String star[] = request.getParameterValues("star");

            String feature[] = request.getParameterValues("feature");

            if (action == null || action.isEmpty()) {
                List<HotelDTO> list = h.getHotelBySearch(sortCol, numberofperson, sortCol);
                request.setAttribute("List", list);
                request.getRequestDispatcher("Search.jsp").forward(request, response);
            } else {
                

                List<HotelDTO> list = h.searachAll(location, sortCol, Arriveddate, numberofperson, listlocation, star, feature);
                request.setAttribute("List", list);
                request.getRequestDispatcher("Search.jsp").forward(request, response);
////for (String string : feature) {
////                     out.println("<div>"+string+"</div>");
////                }
//out.print(location+"/"+numberofperson+"/"+Arriveddate+"/"+listlocation+"/"+star+"/"+feature+"/"+list+"/");
////
//                for (HotelDTO hotelDTO : list) {
//                      out.println("<div>"+hotelDTO.toString()+"</div>");
//                }
////        

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
