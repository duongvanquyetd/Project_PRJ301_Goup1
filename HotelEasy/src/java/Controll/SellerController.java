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
import Object.PersonDTO;
import Object.RoomDAO;
import Object.RoomDTO;
import Object.RoomImageDAO;
import Object.RoomImageDTO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Truong
 */
@MultipartConfig
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
    private static final String UPLOAD_DIRECTORY = "image/testhotel";

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

        if (session != null && owner != null) {
            /////////////////////////////////////////////////////////////////////////////
            if (action == null || action.isEmpty()) {

                url = "SellerMainPage.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("report")) {
                String fromDateStr = request.getParameter("fromDate");
                String toDateStr = request.getParameter("toDate");
                Date fromDate = null;
                Date toDate = null;
                if (fromDateStr != null && !fromDateStr.isEmpty()) {
                    fromDate = Date.valueOf(fromDateStr);
                }
                if (toDateStr != null && !toDateStr.isEmpty()) {
                    toDate = Date.valueOf(toDateStr);
                }
                int confirm = 0;
                int cancel = 0;
                int totalRevenue = 0;
                RoomDTO mostRevenueByRoom = new RoomDTO();
                RoomDTO mostBookingRoom = new RoomDTO();
                List<BookingDTO> listBooking = new ArrayList<BookingDTO>();
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                if (owner.getPersonid() != null && hotel != null) {
                    confirm = bookingDAO.countAcceptBooking(owner.getPersonid(), fromDate, toDate);
                    cancel = bookingDAO.countCancelledBooking(owner.getPersonid(), fromDate, toDate);
                    totalRevenue = bookingDAO.getTotalRevenueByDate(owner.getPersonid(), fromDate, toDate);
                    mostRevenueByRoom = roomDAO.getRoomByRevenue(owner.getPersonid(), fromDate, toDate);
                    mostBookingRoom = roomDAO.getRoomByMostBooking(owner.getPersonid(), fromDate, toDate);
                    listBooking = bookingDAO.loadAllBookingByHotelForReport(hotel.getHotelid());
                }
                request.setAttribute("confirm", confirm);
                request.setAttribute("cancel", cancel);
                request.setAttribute("totalRevenue", totalRevenue);
                request.setAttribute("mostRevenueByRoom", mostRevenueByRoom);
                request.setAttribute("mostBookingRoom", mostBookingRoom);
                request.setAttribute("listBooking", listBooking);

                url = "SellerMainPage.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("bookingManager")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                List<BookingDTO> listBooking = new ArrayList<BookingDTO>();
                if (hotel != null && hotel.getHotelid() != null && !hotel.getHotelid().isEmpty()) {
                    listBooking = bookingDAO.loadAllBookingByHotel(hotel.getHotelid());
                }
                request.setAttribute("listBooking", listBooking);
                request.setAttribute("hotel", hotel);

                url = "BookingManagement.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("acceptBooking")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String id = request.getParameter("id");
                bookingDAO.accept(hotel.getHotelid(), id);

                url = "SellerController?action=bookingManager";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("rejectBooking")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String id = request.getParameter("id");
                bookingDAO.reject(hotel.getHotelid(), id);

                url = "SellerController?action=bookingManager";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("hotelManager")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                Integer price = 0;
                List<String> hotelimg = new ArrayList<>();
                if (hotel != null && hotel.getHotelid() != null && !hotel.getHotelid().isEmpty()) {
                    hotelimg = hotelImgDAO.getImgByHotelID(hotel.getHotelid());
                    price = hotelDAO.getLowestPrice(hotel.getHotelid());
                }
                request.setAttribute("price", price);
                request.setAttribute("hotel", hotel);
                request.setAttribute("hotelimg", hotelimg);

                url = "HotelEdit.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("editHotel")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                request.setAttribute("hotel", hotel);

                url = "ChangeHotelInfo.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("updateHotel")) {
                String id = request.getParameter("id");
                String name = request.getParameter("updatehotelname");
                String street = request.getParameter("updatehotelname");
                String district = request.getParameter("updatehotelname");
                String city = request.getParameter("updatehotelname");
                String rate = request.getParameter("updatehotelname");
                hotelDAO.updateHotel(id, city, district, street, name, rate);
                ArrayList<String> imagePaths = new ArrayList<>();
                for (Part part : request.getParts()) {
                    if (part.getName().equals("imghotel") && part.getSize() > 0) {
                        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        String filePath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY + "/" + "HI" + "/" + fileName;
                        File uploadDir = new File(getServletContext().getRealPath("/") + UPLOAD_DIRECTORY);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdirs();
                        }
                        part.write(filePath);
                        imagePaths.add(UPLOAD_DIRECTORY + "/" + fileName);
                    }
                }
                hotelImgDAO.updateImg(id, imagePaths);

                url = "SellerController?action=hotelManager";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("insertHotel")) {
                String hotelName = request.getParameter("hotelName");
                String hotelStreets = request.getParameter("hotelStreets");
                String hotelDistrict = request.getParameter("hotelDistrict");
                String hotelCity = request.getParameter("hotelCity");
                String starrating = request.getParameter("starrating");
                String newHotelID = hotelDAO.newHotelID();
                if (owner.getPersonid() != null) {
                    hotelDAO.insertHotel(newHotelID, owner.getPersonid(), hotelCity, hotelDistrict, hotelStreets, hotelName, starrating);
                }

                ArrayList<String> imagePaths = new ArrayList<>();
                for (Part part : request.getParts()) {
                    if (part.getName().equals("imghotel") && part.getSize() > 0) {
                        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        String filePath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY + "/" + "HI" + "/" + fileName;
                        File uploadDir = new File(getServletContext().getRealPath("/") + UPLOAD_DIRECTORY);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdirs();
                        }
                        part.write(filePath);
                        imagePaths.add(UPLOAD_DIRECTORY + "/" + fileName);
                    }
                }
                hotelImgDAO.insertImg(newHotelID, imagePaths);

                url = "SellerController?action=hotelManager";
            } else if (action.equalsIgnoreCase("deleteHotel")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String id = request.getParameter("id");
                hotelDAO.deleteHotel(hotel.getHotelid());

                url = "SellerController?action=hotelManager";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("roomManager")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                List<RoomDTO> listRoom = new ArrayList<RoomDTO>();
                if (hotel != null && hotel.getHotelid() != null && !hotel.getHotelid().isEmpty()) {
                    listRoom = roomDAO.loadRoomByHotelID(hotel.getHotelid());
                }
                RoomImageDAO imageDAO = new RoomImageDAO();
                List<RoomImageDTO> roomimage = imageDAO.load();
                request.setAttribute("hotel", hotel);
                request.setAttribute("listRoom", listRoom);
                request.setAttribute("roomimage", roomimage);

                url = "RoomEdit.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("createRoom")) {

                url = "RegisterRoom.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("insertRoom")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String hotelID = "";
                String roomID = "";
                if (hotel != null) {
                    hotelID = hotel.getHotelid();
                    roomID = roomDAO.newRoomIDByHotel(hotel.getHotelid());
                }
                String typeRoom = request.getParameter("roomType");
                int capacityChild = Integer.parseInt(request.getParameter("roomCapacityChild"));
                int capacityAdult = Integer.parseInt(request.getParameter("roomCapacityAdult"));
                int price = Integer.parseInt(request.getParameter("roomPrice"));
                double discount = Double.parseDouble(request.getParameter("roomDiscount"));
                int area = Integer.parseInt(request.getParameter("roomArea"));
                int numBerOfBed = Integer.parseInt(request.getParameter("numberOfBed"));
                roomDAO.insertRoom(hotelID, roomID, capacityAdult, capacityChild, price, discount, area, numBerOfBed, typeRoom);
                ArrayList<String> imagePaths = new ArrayList<>();
                for (Part part : request.getParts()) {
                    if (part.getName().equals("imghotel") && part.getSize() > 0) {
                        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        String filePath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY + "/" + roomID + "/" + fileName;
                        File uploadDir = new File(getServletContext().getRealPath("/") + UPLOAD_DIRECTORY);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdirs();
                        }
                        part.write(filePath);
                        imagePaths.add(UPLOAD_DIRECTORY + "/" + roomID + "/" + fileName);
                    }
                }
                roomImgDAO.insertImg(hotelID, roomID, imagePaths);

                url = "SellerController?action=roomManager";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("editRoomInfo")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String id = request.getParameter("id");
                RoomDTO room = roomDAO.getRoomById(hotel.getHotelid(), id);
                request.setAttribute("room", room);

                url = "ChangeRoomInfo.jsp";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("updateRoom")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String roomID = request.getParameter("idroom");
                int capacityChild = Integer.parseInt(request.getParameter("roomCapacityChild"));
                int capacityAdult = Integer.parseInt(request.getParameter("roomCapacityAdult"));
                int price = Integer.parseInt(request.getParameter("roomPrice"));
                int area = Integer.parseInt(request.getParameter("roomArea"));
                int numBerOfBed = Integer.parseInt(request.getParameter("numBerOfBed"));
                double discount = Double.parseDouble(request.getParameter("roomDiscount"));
                String typeRoom = request.getParameter("roomType");
                roomDAO.updateRoom(hotel.getHotelid(), roomID, capacityAdult, capacityChild, price, discount, area, numBerOfBed, typeRoom);
                ArrayList<String> imagePaths = new ArrayList<>();
                for (Part part : request.getParts()) {
                    if (part.getName().equals("imghotel") && part.getSize() > 0) {
                        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        String filePath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY + "/" + roomID + "/" + fileName;
                        File uploadDir = new File(getServletContext().getRealPath("/") + UPLOAD_DIRECTORY);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdirs();
                        }
                        part.write(filePath);
                        imagePaths.add(UPLOAD_DIRECTORY + "/" + roomID + "/" + fileName);
                    }
                }
                roomImgDAO.updateImg(hotel.getHotelid(), roomID, imagePaths);

                url = "SellerController?action=roomManager";
                /////////////////////////////////////////////////////////////////////////////
            } else if (action.equalsIgnoreCase("deleteRoom")) {
                HotelDTO hotel = hotelDAO.getHotelByOwnerID(owner.getPersonid());
                String roomID = request.getParameter("id");
                roomDAO.deleteRoom(hotel.getHotelid(), roomID);

                url = "SellerController?action=roomManager";
            }
        } else {
            url = "login.jsp";
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
