/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.FeatureHotelDAO;
import Object.FeatureHotelDTO;
import Object.FeatureRoomDAO;
import Object.FeatureRoomDTO;
import Object.HotelImageDAO;
import Object.HotelImageDTA;
import Object.RoomImageDAO;
import Object.RoomImageDTO;
import Object.commentDAO;
import Object.commentDTO;
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
 * @author pvand
 */
@WebServlet(name = "RoomExtensioncontroller", urlPatterns = {"/RoomExtensioncontroller"})
public class RoomExtensioncontroller extends HttpServlet {

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
        HotelImageDAO dao = new HotelImageDAO();
        FeatureHotelDAO htdao = new FeatureHotelDAO();
        FeatureRoomDAO rdao = new FeatureRoomDAO();
        commentDAO cdao = new commentDAO();
        String id = "H1";

        HttpSession session = request.getSession();
        if (id != null && !id.isEmpty()) {
            session.setAttribute("hotelId", id);
        }
        int price = 0;
        int numberbed = 0;
        int numberAdult = 0;
        int numberChild = 0;
        List<String> list = dao.getImgByHotelID(id);
        List<FeatureHotelDTO> featurehotel = htdao.getInfHotel(id);
        List<FeatureRoomDTO> featureroom = rdao.getInfAllRoom(id, price, numberbed, numberAdult, numberChild);
        List<commentDTO> cmtroom = cdao.getcomment(id);
        RoomImageDAO daoRoom = new RoomImageDAO();
        List<RoomImageDTO> listImgRoom = daoRoom.load();
        try {
            String action = request.getParameter("action");
            if (action != null && "search".equals(action)) {

                String strPrice = request.getParameter("price");
                String strBedCount = request.getParameter("bedCount");
                String strGuestAdult = request.getParameter("guestCountAdult");
                String strGuestChild = request.getParameter("guestCountChild");

// Gán giá trị mặc định nếu chuỗi null hoặc rỗng
                int price1 = (strPrice == null || strPrice.trim().isEmpty()) ? 0 : Integer.parseInt(strPrice);
                int numberbed1 = (strBedCount == null || strBedCount.trim().isEmpty()) ? 0 : Integer.parseInt(strBedCount);
                int numberpeople = (strGuestAdult == null || strGuestAdult.trim().isEmpty()) ? 0 : Integer.parseInt(strGuestAdult);
                int numberChild1 = (strGuestChild == null || strGuestChild.trim().isEmpty()) ? 0 : Integer.parseInt(strGuestChild);

                List<FeatureRoomDTO> search = rdao.getInfAllRoom(id, price1, numberbed1, numberpeople, numberChild1);
                System.out.println("=== Đã vào block search ===");
                System.out.println("price: " + price1);
                System.out.println("bedCount: " + numberbed1);
                System.out.println("guestCountAdult: " + numberpeople);
                System.out.println("guestCountChild: " + numberChild1);
                System.out.println("Search Result Size: " + search.size());
                request.setAttribute("cmt", cmtroom);
                request.setAttribute("fthotel", featurehotel);
                request.setAttribute("HotelImg", list);
                request.setAttribute("ftroom", search);
                if (search.size() == 0) {
                    request.setAttribute("noroom", "Không có phòng như bạn tìm kiếm.");
                }
                request.getRequestDispatcher("./image/room_page/Room.jsp").forward(request, response);
                return; // ← Important to prevent double forwarding
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        request.setAttribute("cmt", cmtroom);
        request.setAttribute("ftroom", featureroom);
        request.setAttribute("fthotel", featurehotel);
        request.setAttribute("RoomImg", listImgRoom); // danh sách ảnh của room
        request.setAttribute("HotelImg", list); // danh sách ảnh của Hotel
        
        System.out.println("Comment room:" + cmtroom.size() + cmtroom);
        System.out.println("Room feature" + featureroom.size());
        System.out.println("Hotel images: " + list.size());
        System.out.println("Hotel features: " + featurehotel.size());
        System.out.println("Room images: " + listImgRoom.size());

        request.getRequestDispatcher("./image/room_page/Room.jsp").forward(request, response);
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
