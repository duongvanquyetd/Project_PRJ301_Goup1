/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.BookingDAO;
import Object.BookingDTO;
import Object.HotelDAO;
import Object.PersonDAO;
import Object.PersonDTO;
import Object.RoomDAO;
import Object.RoomDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "Booking", urlPatterns = {"/Booking"})
public class Booking extends HttpServlet {

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
            String roomid = request.getParameter("roomid");
            String hotelid = request.getParameter("hotelid");
            RoomDAO r = new RoomDAO();
            String url = "Booking.jsp";

            HttpSession session = request.getSession(false);
//            PersonDTO pe = (PersonDTO) session.getAttribute("usersession");
//            String personid = pe.getPersonid();

            String personid = "quyet";

            HotelDAO hd = new HotelDAO();
            if (action == null || action.isEmpty()) {

                RoomDTO room = r.getRoomByID(roomid, hotelid);
                request.setAttribute("room", room);
                request.setAttribute("hotel", hd.getHotelByID(hotelid));
                request.getRequestDispatcher("Booking.jsp").forward(request, response);

            } else if (action.equals("book")) {
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String type = request.getParameter("type");
                if (name != null && phone != null) {

                    if (name.isEmpty() || phone.isEmpty()) {
                        request.setAttribute("loi", "Phone and Name not Empty");
                        RoomDTO room = r.getRoomByID(roomid, hotelid);
                        request.setAttribute("room", room);
                        request.setAttribute("hotel", hd.getHotelByID(hotelid));
                        request.getRequestDispatcher("Booking.jsp").forward(request, response);

                    } else {

                        personid += "/" + phone;
                        PersonDTO p = new PersonDTO();
                        p.setPersonid(personid);
                        p.setName(name);
                        p.setPhone(phone);
                        p.setRoleName("R2");
                        PersonDAO d = new PersonDAO();
                        d.RegisterPersonDatHO(p);
                    }
                }

                String DepatureDay = request.getParameter("DepatureDay");
                String Arriveddate = request.getParameter("Arriveddate");
                String numberofchildren = request.getParameter("numberofchildren");
                String numberofadult = request.getParameter("numberofadult");
                BookingDAO bd = new BookingDAO();

                BookingDTO b = new BookingDTO();
                b.setHotelid(hotelid);
                b.setRoomid(roomid);
                b.setPerosnid(personid);

                b.setNumberofchild(Integer.parseInt(numberofchildren));

                b.setNumberofadult(Integer.parseInt(numberofadult));
                request.setAttribute("phone", phone);
                request.setAttribute("name", name);

                if (Arriveddate.isEmpty() || DepatureDay.isEmpty()) {
                    request.setAttribute("mess", "Date not Empty");
                    RoomDTO room = r.getRoomByID(roomid, hotelid);
                    request.setAttribute("room", room);

                    request.setAttribute("hotel", hd.getHotelByID(hotelid));
                    request.getRequestDispatcher("Booking.jsp").forward(request, response);
                } else {
                    b.setDepaturedate(Date.valueOf(DepatureDay));
                    b.setArrivedate(Date.valueOf(Arriveddate));
                }

                if (!bd.CheckDateBooking(b)) {
                    request.setAttribute("mess", "This date is booked");
                    RoomDTO room = r.getRoomByID(roomid, hotelid);
                    request.setAttribute("room", room);
                    request.setAttribute("hotel", hd.getHotelByID(hotelid));
                    request.getRequestDispatcher("Booking.jsp").forward(request, response);
                } else if (b.getDepaturedate() != null && b.getArrivedate() != null) {
                    bd.Booking(b);
                    request.setAttribute("personid", personid);
                    request.getRequestDispatcher("Booking?action=pay").forward(request, response);

                }

            } else if (action.equals("pay")) {

                PersonDAO d = new PersonDAO();
                String hotelidd = request.getParameter("hotelid");
                String roomidd = request.getParameter("roomid");
                String price = request.getParameter("price");
                String personidd = (String) request.getAttribute("personid");
                request.setAttribute("person", d.getAllPersonByID(personidd));
                request.setAttribute("hotelid", hotelidd);
                request.setAttribute("roomid", roomidd);
                request.setAttribute("price", price);
                // out.print(hotelidd+"/"+roomidd+"/");
                request.getRequestDispatcher("Pay.jsp").forward(request, response);
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
