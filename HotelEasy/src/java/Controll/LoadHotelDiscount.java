package Controll;

import Object.HotelDAO;
import Object.HotelDTO;
import Object.HotelImageDAO;
import Object.HotelImageDTA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huybe
 */
@WebServlet(name = "LoadHotelDiscount", urlPatterns = {"/LoadHotelDiscount"})
public class LoadHotelDiscount extends HttpServlet {

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
        String nump = request.getParameter("index");
        try (PrintWriter out = response.getWriter()) {
            
             if (nump == null) {
                    nump = "1" ;
                     }
            int  index = Integer.parseInt(nump);
       System.out.println("Số" + index);
            
        HotelDAO h = new HotelDAO();
            List<HotelDTO>list = h.getHotelDiscount(index);
            HotelImageDAO img = new HotelImageDAO();
            List<HotelImageDTA> b = img.getAllImgHotel();
            HotelDAO dao = new HotelDAO();
            int count = dao.getCountHotel()/10 ;
            if(count != 0){
                count++ ;
            }
            System.out.println(count);
            System.out.println(list.size());
            request.setAttribute("numberp", count);
            
            request.setAttribute("Img", b);
            request.setAttribute("List", list);
            
            
            request.getRequestDispatcher("MainPage_1.jsp").forward(request, response);
            


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