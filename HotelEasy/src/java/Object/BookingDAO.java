/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<BookingDTO> loadAllBooking() {
        List<BookingDTO> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select b.HotelID,b.RoomID, b.PersonID,b.NumberChild,b.NumberAdult, b.DepatureDate, b.ArriveDate, b.TimeBooking, b.Status, p.Name from Booking b, Person p where b.PersonID = p.PersonID and Status = 'Pending'";
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String hotelid = rs.getString("HotelID").trim();

                    String roomid = rs.getString("RoomID");
                    String personname = rs.getString("Name").trim();

                    int numberchild = rs.getInt("NumberChild");

                    int numberadult = rs.getInt("NumberAdult");
                    Date depaturedate = rs.getDate("DepatureDate");
                    Date arrivedate = rs.getDate("ArriveDate");
                    Date timebooking = rs.getDate("TimeBooking");
                    String status = rs.getString("Status");
                    BookingDTO booking = new BookingDTO(hotelid, roomid, personname, numberchild, numberadult, depaturedate, arrivedate, timebooking, status);

                    list.add(booking);
                }

            }
            con.close();

        } catch (Exception e) {
        }

        return list;
    }

    public List<BookingDTO> loadAllBookingByHotel(String hotelid) {
        List<BookingDTO> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select b.*, p.Name from Booking b, Person p where b.PersonID = p.PersonID and Status = 'Pending' and HotelID = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelid);
            ResultSet rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String roomid = rs.getString("RoomID").trim();
                    String personname = rs.getString("Name").trim();
                    int numberchild = rs.getInt("NumberChild");
                    int numberadult = rs.getInt("NumberAdult");
                    Date depaturedate = rs.getDate("DepatureDate");
                    Date arrivedate = rs.getDate("ArriveDate");
                    Date timebooking = rs.getDate("TimeBooking");
                    String status = rs.getString("Status");
                    BookingDTO booking = new BookingDTO(hotelid, roomid, personname, numberchild, numberadult, depaturedate, arrivedate, timebooking, status);

                    list.add(booking);
                }

            }
            con.close();

        } catch (Exception e) {
        }

        return list;
    }

    public int countAcceptBooking(String ownerID, Date fromDate, Date toDate) {
        int count = 0;
        String sql = "select count(b.PersonID) countAcceptBooking from Hotel h, Booking b where b.HotelID = h.HotelID and h.PersonID = ? and Status = 'Confirmed' AND TimeBooking BETWEEN ? AND ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, ownerID);
            stm.setDate(2, fromDate);
            stm.setDate(3, toDate);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("countAcceptBooking");
            }
            con.close();
        } catch (SQLException e) {
            printStackTrace();
        }
        return count;
    }

    public int countCancelledBooking(String ownerID, Date fromDate, Date toDate) {
        int count = 0;
        String sql = "select count(b.PersonID) countAcceptBooking from Hotel h, Booking b where b.HotelID = h.HotelID and h.PersonID = ? and Status = 'Cancelled' AND TimeBooking BETWEEN ? AND ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, ownerID);
            stm.setDate(2, fromDate);
            stm.setDate(3, toDate);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("countAcceptBooking");
            }
            con.close();
        } catch (SQLException e) {
            printStackTrace();
        }
        return count;
    }

    public int getTotalRevenueByDate(String personID, Date fromDate, Date toDate) {
        int TotalRevenue = 0;
        String sql = "SELECT SUM(r.Price) AS TotalRevenue\n"
                + "FROM Booking b\n"
                + "JOIN Room r ON b.HotelID = r.HotelID AND b.RoomID = r.RoomID\n"
                + "JOIN Hotel h ON b.HotelID = h.HotelID\n"
                + "WHERE h.PersonID = ?\n"
                + "  AND b.TimeBooking >= ?\n"
                + "  AND b.TimeBooking <= ?\n"
                + "  AND b.Status = 'Confirmed'";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, personID);
            stm.setDate(2, fromDate);
            stm.setDate(3, toDate);

            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                TotalRevenue = rs.getInt("TotalRevenue");
            }
            con.close();
        } catch (SQLException e) {
            printStackTrace();
        }

        return TotalRevenue;
    }
    
   

    public void accept(String hotelid, String roomid) {
        String sql = "update Booking set Status = 'Confirmed' where HotelID = ? and RoomID = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelid);
            stm.setString(2, roomid);

            stm.executeQuery();

            con.close();
        } catch (Exception e) {
        }

    }

    public void reject(String hotelid, String roomid) {
        String sql = "update Booking set Status = 'Cancelled' where HotelID = ? and RoomID = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelid);
            stm.setString(2, roomid);

            stm.executeQuery();

            con.close();
        } catch (Exception e) {
        }
    }

    public List<BookingDTO> loadAllBookingByHotelForReport(String hotelid) {
        List<BookingDTO> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select b.*, p.Name from Booking b, Person p where b.PersonID = p.PersonID and HotelID = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelid);
            ResultSet rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String roomid = rs.getString("RoomID").trim();
                    String personname = rs.getString("Name").trim();
                    int numberchild = rs.getInt("NumberChild");
                    int numberadult = rs.getInt("NumberAdult");
                    Date depaturedate = rs.getDate("DepatureDate");
                    Date arrivedate = rs.getDate("ArriveDate");
                    Date timebooking = rs.getDate("TimeBooking");
                    String status = rs.getString("Status");
                    BookingDTO booking = new BookingDTO(hotelid, roomid, personname, numberchild, numberadult, depaturedate, arrivedate, timebooking, status);

                    list.add(booking);
                }

            }
            con.close();

        } catch (Exception e) {
        }

        return list;
    }
    
    public static void main(String[] args) {
        BookingDAO dao = new BookingDAO();
        List<BookingDTO> f = dao.loadAllBookingByHotelForReport("h6");

        System.out.println(f);
    }
}
