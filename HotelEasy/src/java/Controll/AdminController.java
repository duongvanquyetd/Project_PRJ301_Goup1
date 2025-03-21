/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.BookingDAO;
import Object.HotelDAO;
import Object.HotelDTO;
import Object.HotelImageDAO;
import Object.HotelImageDTA;
import Object.PersonDAO;
import Object.PersonDTA;
import Object.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            String url = "login.jsp";
            if (session != null && session.getAttribute("adminsession") != null) {
                if (action == null || action.isEmpty()) {
                    HotelDAO h = new HotelDAO();
                    int nhotel = h.NumberOfHotel();
                    PersonDAO p = new PersonDAO();
                    int nUser = p.NumberOfUser();
                    int nHotelOwner = p.NumberOfHotelOwner();
                    RoomDAO r = new RoomDAO();
                    int nRoom = r.NumberOfRoom();
                    BookingDAO d = new BookingDAO();
                    int nBooking = d.NumberOfBooking();
                    long nPrice = d.NumberOfBookingPrice();

                    request.setAttribute("nhotel", nhotel);
                    request.setAttribute("nuser", nUser);
                    request.setAttribute("nhotelowner", nHotelOwner);
                    request.setAttribute("nroom", nRoom);
                    request.setAttribute("nbooking", nBooking);
                    request.setAttribute("nprice", nPrice);
                    url="Admin_Reports.jsp";
                } else if (action != null && action.equals("ManagerAccount")) {
                    PersonDAO p = new PersonDAO();
                    String userid = request.getParameter("userid");

                    if (userid != null && !userid.isEmpty()) {
                        p.deletebyUserid(userid);
                    }

                    List<PersonDTA> list = p.getAllPerson();

                    request.setAttribute("list", list);
                    url="Admin_ManagerAcount.jsp";
                } else if (action != null && action.equals("ManagerHotel")) {
                    HotelDAO h = new HotelDAO();
                    /* TODO output your page here. You may use following sample code. */

                    String HotelID = request.getParameter("hotelid");
                    if (HotelID != null && !HotelID.trim().isEmpty()) {
                        h.AppvovedHotel(HotelID);
                    }
                    List<HotelDTO> listH = h.getNotApproveHotel();
                    HotelImageDAO hm = new HotelImageDAO();
                    List<HotelImageDTA> listI = hm.getNotApHotel();
                    request.setAttribute("listA", listH);
                    request.setAttribute("listB", listI);
                    url="Admin_managerHotel.jsp";
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
