/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.BookingDAO;
import Object.HotelDAO;
import Object.PersonDAO;
import Object.RoomDAO;
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
@WebServlet(name = "admin_Reports", urlPatterns = {"/adminreport"})
public class admin_Reports extends HttpServlet {

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
           HotelDAO h = new HotelDAO();
           int nhotel = h.NumberOfHotel();
           PersonDAO p = new PersonDAO();
           int nUser= p.NumberOfUser();
           int nHotelOwner = p.NumberOfHotelOwner();
          RoomDAO r = new RoomDAO();
          int nRoom = r.NumberOfRoom();
          BookingDAO d = new BookingDAO();
          int nBooking = d.NumberOfBooking();
          long nPrice= d.NumberOfBookingPrice();
          
          request.setAttribute("nhotel", nhotel);
          request.setAttribute("nuser", nUser);
          request.setAttribute("nhotelowner", nHotelOwner);
          request.setAttribute("nroom", nRoom);
          request.setAttribute("nbooking", nBooking);
          request.setAttribute("nprice", nPrice);
          request.getRequestDispatcher("Admin_Reports.jsp").forward(request, response);
          
          
          
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
