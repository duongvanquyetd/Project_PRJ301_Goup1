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
    FeatureHotelDAO htdao = new FeatureHotelDAO() ; 
    FeatureRoomDAO rdao = new FeatureRoomDAO() ;
    String id = "H2" ;
    List<String> list = dao.getImgByHotelID(id);
    List<FeatureHotelDTO> featurehotel = htdao.getInfHotel(id) ;
    List<FeatureRoomDTO> featureroom = rdao.getInfAllRoom( id) ;
    
    
    
    RoomImageDAO daoRoom = new RoomImageDAO() ;
   List<RoomImageDTO> listImgRoom = daoRoom.load();
   
   request.setAttribute("ftroom", featureroom);
    request.setAttribute("fthotel", featurehotel);
    request.setAttribute("RoomImg", listImgRoom); // danh sách ảnh của room
   request.setAttribute("HotelImg", list); // danh sách ảnh của Hotel

   
   
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
