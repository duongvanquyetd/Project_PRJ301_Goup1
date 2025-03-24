/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.FavoriteDAO;
import Object.FavoriteDTO;
import Object.HotelDAO;
import Object.HotelDTA;
import Object.HotelImageDAO;
import Object.HotelImageDTA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pvand
 */
public class FavariteController extends HttpServlet {

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

    try {
        // Lấy userID từ session (hoặc gán cố định để test)
        // String userID = (String) request.getSession().getAttribute("userID");
        String userID = "vangia";  // Tạm thời hard-code để test
        
//         HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user"); // Lấy người dùng đã login
    String hotelIdStr = request.getParameter("hotelid");
//        if (user == null) {
//            response.sendRedirect("login.jsp"); // Chuyển hướng nếu chưa login
//            return;
//        }
    FavoriteDAO daofa = new FavoriteDAO();

        if (daofa.isFavorite(userID, hotelIdStr)) {
                    daofa.removeFavorite(userID, hotelIdStr);
} else {
            daofa.addFavorite(userID, hotelIdStr);
}
        
        // Lấy danh sách khách sạn yêu thích
        HotelDAO hotelDAO = new HotelDAO();
        List<HotelDTA> favoriteHotels = hotelDAO.getAllHotelFA(userID);
          
      
        // Lấy danh sách ảnh khách sạn
        HotelImageDAO imageDAO = new HotelImageDAO();
        List<HotelImageDTA> allImages = imageDAO.getAllImgHotel();

        // Gán dữ liệu cho request
        request.setAttribute("Listfa", favoriteHotels);
        request.setAttribute("Img", allImages);

        // In ra console để kiểm tra
        System.out.println("Số lượng khách sạn yêu thích: " + favoriteHotels.size());
        System.out.println("số lượng ảnh" + allImages.size());

        // Chuyển tiếp đến trang favorite.jsp
        request.getRequestDispatcher("MainPage_4.jsp").forward(request, response);

    } catch (Exception e) {
        System.out.println("loi" + e.getLocalizedMessage());
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
