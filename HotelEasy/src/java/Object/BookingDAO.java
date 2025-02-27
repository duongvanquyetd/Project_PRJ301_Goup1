/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class BookingDAO {
       public int NumberOfBooking()
    {
        
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select count(*)'NumberOfBooking' from Booking  ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
               return rs.getInt("NumberOfBooking"); 
            }
            
                    
                  

        } catch (Exception e) {
        }
        return 0;
    }
          public long NumberOfBookingPrice()
    {
        
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select sum(DATEDIFF(DAY, b.DepatureDate,b.ArriveDate )*(Price-((r.Discount/100)*Price)))'TotalPriceBooking'from Booking b , Room r where b.HotelID = r.HotelID and r.RoomID = b.RoomID ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
               return rs.getLong("TotalPriceBooking");
            }
            
                    
                  

        } catch (Exception e) {
        }
        return 0;
    }
    public static void main(String[] args) {
        BookingDAO d = new  BookingDAO();
        System.out.println(d.NumberOfBookingPrice()); 
              
    }
}
