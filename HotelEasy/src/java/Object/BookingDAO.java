/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class BookingDAO {

    public int NumberOfBooking() {

        try {
            Connection con = DBUtils.getConnection();
            String sql = "select count(*)'NumberOfBooking' from Booking  ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumberOfBooking");
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public long NumberOfBookingPrice() {

        try {
            Connection con = DBUtils.getConnection();
            String sql = "select sum(DATEDIFF(DAY, b.DepatureDate,b.ArriveDate )*(Price-((r.Discount/100)*Price)))'TotalPriceBooking'from Booking b , Room r where b.HotelID = r.HotelID and r.RoomID = b.RoomID ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getLong("TotalPriceBooking");
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public void Booking(BookingDTO b) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "insert Booking (HotelID,RoomID,PersonID,NumberChild,NumberAdult,DepatureDate,ArriveDate,TimeBooking,Status)\n"
                    + "values (?,?,?,?,?,?,?,?,?) ";
            LocalDate l = LocalDate.now();
            String time = String.valueOf(l.getYear()) + "-" + String.valueOf(l.getMonthValue()) + "-" + String.valueOf(l.getDayOfMonth());
            System.out.println(time);
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, b.getHotelid());
            stm.setString(2, b.getRoomid());
            stm.setString(3, b.getPerosnid());
            stm.setInt(4, b.getNumberofchild());
            stm.setInt(5, b.getNumberofadult());
            stm.setDate(6, b.getDepaturedate());
            stm.setDate(7, b.getArrivedate());
            stm.setDate(8, Date.valueOf(time));
            stm.setString(9, "pending");
            stm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public boolean CheckDateBooking(BookingDTO b) {

        try {
            Connection con = DBUtils.getConnection();
            String sql = "select *from Booking r where (? >=r.DepatureDate and r.DepatureDate >=? \n"
                    + " or r.ArriveDate <= ? and r.ArriveDate >=?)  and r.HotelID = ? and r.RoomID =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDate(1, b.getDepaturedate());
            stm.setDate(2, b.getArrivedate());
            stm.setDate(3, b.getArrivedate());
            stm.setDate(4, b.getDepaturedate());
            stm.setString(5, b.getHotelid());
            stm.setString(6, b.getRoomid());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (Exception e) {
        }
        return true;
    }

    public static void main(String[] args) {
        
        
//        PersonDAO  dd = new PersonDAO();
//        dd.RegisterPerson(new PersonDTO("aaa", null, null, "302489324", "R2"));
////                
        BookingDAO d = new BookingDAO();
        BookingDTO b = new BookingDTO();
        b.setHotelid("H1");
        b.setRoomid("R1");
        b.setPerosnid("aaa");
        b.setNumberofchild(2);
        b.setNumberofadult(3);
        b.setDepaturedate(Date.valueOf("2024-08-20"));
        b.setArrivedate(Date.valueOf("2024-08-26"));

     d.Booking(b);
//        
       

    }
}
