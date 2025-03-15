/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.BookingDAO;
import Object.BookingDTO;
import Object.HotelDAO;
import Object.HotelDTO;
import Object.HotelImageDAO;
import Object.HotelImageDTO;
import Object.PersonDTO;
import Object.RoomDAO;
import Object.RoomDTO;
import Object.RoomImageDAO;
import Object.RoomImageDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Truong
 */
@WebServlet(name = "SellerController", urlPatterns = {"/SellerController"})
public class SellerController extends HttpServlet {

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
        String url = "SellerMainPage.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("ownersession") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        PersonDTO owner = (PersonDTO) session.getAttribute("ownersession");
        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();
        RoomImageDAO roomImgDAO = new RoomImageDAO();
        HotelImageDAO hotelImgDAO = new HotelImageDAO();
        BookingDAO bookingDAO = new BookingDAO();
        HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());

        /////////////////////////////////////////////////////////////////////////////
        if (action == null || action.isEmpty()) {
            url = "SellerMainPage.jsp";
        } else if (action.equalsIgnoreCase("bookingManager")) {
            List<BookingDTO> listBooking = new ArrayList<BookingDTO>();
            if(hotel != null && hotel.getHotelid() != null && hotel.getHotelid().isEmpty()){
                listBooking = bookingDAO.loadAllBookingByHotel(hotel.getHotelid());
            }
            request.setAttribute("listBooking", listBooking);
            request.setAttribute("hotel", hotel);

            url = "BookingManagement.jsp";
        } else if (action.equalsIgnoreCase("acceptBooking")) {
            String id = request.getParameter("id");
            bookingDAO.accept(hotel.getHotelid(), id);

            url = "SellerController?action=bookingManager";
        } else if (action.equalsIgnoreCase("rejectBooking")) {
            String id = request.getParameter("id");
            bookingDAO.reject(hotel.getHotelid(), id);

            url = "SellerController?action=bookingManager";
        } else if (action.equalsIgnoreCase("hotelManager")) {
            List<String> hotelimg = new ArrayList<>();
            if (hotel != null && hotel.getHotelid() != null && hotel.getHotelid().isEmpty()) {
                hotelimg = hotelImgDAO.getImgByHotelID(hotel.getHotelid());
            }
            request.setAttribute("hotel", hotel);
            request.setAttribute("hotelimg", hotelimg);

            url = "HotelEdit.jsp";
        } else if (action.equalsIgnoreCase("editHotel")) {
            HotelDAO dao = new HotelDAO();
            request.setAttribute("price", dao.getLowestPrice(hotel.getHotelid()));
            request.setAttribute("hotel", hotel);

            url = "ChangeHotelInfo.jsp";
        } else if (action.equalsIgnoreCase("changeHotelInfo")) {
            String id = request.getParameter("id");
            String name = request.getParameter("updatehotelname");
            String street = request.getParameter("updatehotelname");
            String district = request.getParameter("updatehotelname");
            String city = request.getParameter("updatehotelname");
            String rate = request.getParameter("updatehotelname");
            HotelDAO dao = new HotelDAO();
            dao.updateHotel(id, city, district, street, name, rate);

            url = "SellerController?action=hotelManager";
        } else if (action.equalsIgnoreCase("deleteHotel")) {
            String id = request.getParameter("id");
            hotelDAO.deleteHotel(hotel.getHotelid());

            url = "SellerController?action=hotelManager";
        } else if (action.equalsIgnoreCase("roomManager")) {
            List<RoomDTO> listRoom = new ArrayList<RoomDTO>();
            if(hotel != null && hotel.getHotelid() != null && hotel.getHotelid().isEmpty()){
                listRoom = roomDAO.loadRoomByHotelID(hotel.getHotelid());
            }
            List<RoomImageDTO> listRoomImg = roomImgDAO.load();
            request.setAttribute("hotel", hotel);
            request.setAttribute("listRoom", listRoom);
            request.setAttribute("ListImgRoom", listRoomImg);

            url = "RoomEdit.jsp";
        } else if (action.equalsIgnoreCase("createRoom")) {

            url = "RegisterRoom.jsp";
        } else if (action.equalsIgnoreCase("insertRoom")) {
            Integer capacityChild = null, capacityAdult = null, price = null, area = null, numBerOfBed = null;
            String roomID = roomDAO.newRoomIDByHotel(hotel.getHotelid());
            capacityChild = Integer.parseInt(request.getParameter("roomCapacityChild"));
            capacityAdult = Integer.parseInt(request.getParameter("roomCapacityAdult"));
            price = Integer.parseInt(request.getParameter("roomPrice"));
            area = Integer.parseInt(request.getParameter("roomArea"));
            numBerOfBed = Integer.parseInt(request.getParameter("numBerOfBed"));
            String discount = request.getParameter("roomDiscount");
            String typeRoom = request.getParameter("roomType");
            String status = request.getParameter("roomStatus");
            roomDAO.insertRoom(hotel.getHotelid(), roomID, capacityAdult, capacityChild, price, discount, area, numBerOfBed, typeRoom);;

            url = "SellerController?action=roomManager";
        } else if (action.equalsIgnoreCase("editRoomInfo")) {
            String id = request.getParameter("id");
            RoomDTO room = roomDAO.getRoomById(hotel.getHotelid(), id);
            request.setAttribute("room", room);

            url = "ChangeRoomInfo.jsp";
        } else if (action.equalsIgnoreCase("updateRoom")) {
            String roomID = request.getParameter("idroom");
            int capacityChild = Integer.parseInt(request.getParameter("roomCapacityChild"));
            int capacityAdult = Integer.parseInt(request.getParameter("roomCapacityAdult"));
            int price = Integer.parseInt(request.getParameter("roomPrice"));
            int area = Integer.parseInt(request.getParameter("roomArea"));
            int numBerOfBed = Integer.parseInt(request.getParameter("numBerOfBed"));
            String discount = request.getParameter("roomDiscount");
            String typeRoom = request.getParameter("roomType");
            String status = request.getParameter("roomStatus");
            roomDAO.updateRoom(hotel.getHotelid(), roomID, capacityAdult, capacityChild, price, discount, typeRoom);

            url = "SellerController?action=roomManager";
        } else if (action.equalsIgnoreCase("deleteRoom")) {
            String roomID = request.getParameter("id");
            roomDAO.deleteRoom(hotel.getHotelid(), roomID);

            url = "SellerController?action=roomManager";
        }

        request.getRequestDispatcher(url).forward(request, response);

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
