/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controll;

import Object.HotelDAO;
import Object.HotelDTO;
import Object.HotelImageDAO;
import Object.HotelImageDTA;
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
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

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

            List<HotelDTO> list = new ArrayList<HotelDTO>();

            String action = request.getParameter("action");
            if (action == null || action.isEmpty()) {
                String s = request.getParameter("txt");
                list = h.getHotelBySearch(s, null, null);
            }
            else if (action.equals("Steets")){
                String s[] = request.getParameterValues("txt");
                list = h.searachAll(null, null, null, null, s, null, null);
            }
            else if (action.equals("NumberOfPerson")){
                String s = request.getParameter("txt");
                int i =  0 ; 
                try {
                    i = Integer.parseInt(s);
                } catch (Exception e) {
                    s = null;
                }
                list = h.searachAll(null, null, null, s, null, null, null);
                
            }
             else if (action.equals("star")){
                String s[] = request.getParameterValues("txt");
                list = h.searachAll(null, null, null, null,null , s, null);
            }
             else if (action.equals("feature")){
                String s[] = request.getParameterValues("txt");
                list = h.searachAll(null, null, null, null,null , null, s);
            }
                         

//            request.setAttribute("List", list);
//            request.getRequestDispatcher("Search.jsp").forward(request, response);

            for (HotelDTO ht : list) {

                out.print("<div class=\"sub-right-search\" >"
                        + "<div class=\"anh\">\n"
                        + "\n"
                        + "                        <img src=\"" + h.getImageHotel(ht.getHotelID()) + "\">\n"/// anh khach sans
                        + "\n"
                        + "                        <div  class=\"discoutn\"> Tiết Kiệm " + ht.getDiscount() + "%</div>\n"
                        + "\n"
                        + "                    </div>\n"
                        + "\n"
                        + "                    <div class=\"sub-content-rights-search\">\n"
                        + "\n"
                        + "                        <div class=\"sosao\">\n"
                        + "                            <img src=\"" + ht.getRateHotel() + "\">\n"
                        + "\n"
                        + "                        </div> \n"
                        + "                        <div class=\"nameks\">\n"
                        + "\n"
                        + "                            " + ht.getNameHotel() + "\n"
                        + "\n"
                        + "                        </div>\n"
                        + "                        <div class=\"diachi\">\n"
                        + "\n"
                        + "                            " + ht.getStreets() + "," + ht.getDistrict() + "," + ht.getCity() + "\n"
                        + "                        </div>\n"
                        + "\n"
                        + "                        <div  class=\"giatien\">\n"
                        + "\n"
                        + "                            " + ht.getPrice() + "/Mỗi Đêm\n"
                        + "\n"
                        + "\n"
                        + "                        </div>\n"
                        + "\n"
                        + "\n"
                        + "                    </div>  "
                        + "                    </div>  "
                );

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
