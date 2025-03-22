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
import java.util.ArrayList;
import java.util.List;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class RoomDAO {

    public int NumberOfRoom() {

        try {
            Connection con = DBUtils.getConnection();
            String sql = "select count(*)'NumberOfRoom' from Room  ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumberOfRoom");
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public List<RoomDTO> loadRoomByHotelID(String hotelID) {
        List<RoomDTO> list = new ArrayList<RoomDTO>();
        try {
            String sql = " select * from Room where HotelID = ? ";
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hotelID);
            ResultSet rs = stm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    String HotelID = rs.getString("HotelID").trim();
                    String RoomID = rs.getString("RoomID").trim();
                    int CapacityChild = rs.getInt("CapacityChild");
                    int CapacityAdult = rs.getInt("CapacityAdult");
                    int Price = rs.getInt("Price");
                    double Discount = rs.getDouble("Discount");
                    String TypeRoom = rs.getString("TypeRoom").trim();
                    int NumberOFbed = rs.getInt("NumberOFbed");
                    int Area = rs.getInt("Area");
                    String Status = rs.getString("Status").trim();
                    RoomDTO room = new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, NumberOFbed, Area, Status);
                    list.add(room);
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Load Room Data fail " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public void updateRoom(String hotelID, String roomID, int capacityAdult, int capacityChild, int price, double discount, int area, int numofbed, String typeRoom) {
        String sql = "update Room set CapacityAdult = ?, CapacityChild = ?, Price = ?, Discount = ?, TypeRoom = ?, Status= 0, Area = ?, NumberOfBed = ? where HotelID = ? and RoomID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, capacityAdult);
            stm.setInt(2, capacityChild);
            stm.setInt(3, price);
            stm.setDouble(4, discount);
            stm.setString(5, typeRoom);
            stm.setInt(6, area);
            stm.setInt(7, numofbed);
            stm.setString(8, hotelID);
            stm.setString(9, roomID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Update hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertRoom(String hotelID, String roomID, int capacityAdult, int capacityChild, int price, double discount, int area, int numofbed, String typeRoom) {
        String sql = " insert into Room values (?, ?,?,?,?,?,?,?,?,?) ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, roomID);
            stm.setInt(3, capacityChild);
            stm.setInt(4, capacityAdult);
            stm.setInt(5, price);
            stm.setDouble(6, discount);
            stm.setNString(7, typeRoom);
            stm.setInt(8, 0);
            stm.setInt(9, area);
            stm.setInt(10, numofbed);
            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Insert hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteRoom(String hotelID, String roomID) {
        String sql = "delete from ImageRoom where HotelID = ? and RoomID = ?\n"
                + "delete from Booking where  HotelID = ? and RoomID = ?\n"
                + "delete from FeatureRoom where  HotelID = ? and RoomID = ?\n"
                + "delete from Room where HotelID = ? and RoomID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, roomID);
            stm.setString(3, hotelID);
            stm.setString(4, roomID);
            stm.setString(5, hotelID);
            stm.setString(6, roomID);
            stm.setString(7, hotelID);
            stm.setString(8, roomID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Delete room fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<String> getRoomFeature(String hotelid, String roomid) {
        String sql = "select * from FeatureRoom fr where fr.HotelID = ? and fr.RoomID = ?";
        List<String> feature = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelid);
            stm.setString(2, roomid);

            ResultSet rs = stm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    String ft = rs.getString("Gift");
                    feature.add(ft);
                }
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Fail to load room feature");
        }
        return feature;
    }

    public String newRoomIDByHotel(String id) {
        String sql = "select RoomID from Room where HotelID = ?";
        Integer newID = 0;
        List<Integer> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    String oldRoomID = rs.getString("RoomID");
                    int numID = Integer.parseInt(oldRoomID.replaceAll("[^0-9]", ""));
                    list.add(numID);
                }
            }
            for (Integer integer : list) {
                if (newID <= integer) {
                    newID = integer;
                }
            }
        } catch (Exception e) {
        }
        return "R" + ++newID;
    }

    public RoomDTO getRoomById(String hotelID, String roomId) {
        String sql = "select * from Room where HotelID = ? and RoomID = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelID);
            stm.setString(2, roomId);
            ResultSet rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String HotelID = rs.getString("HotelID").trim();
                    String RoomID = rs.getString("RoomID").trim();
                    int CapacityChild = rs.getInt("CapacityChild");
                    int CapacityAdult = rs.getInt("CapacityAdult");
                    int Price = rs.getInt("Price");
                    double Discount = rs.getDouble("Discount");
                    String TypeRoom = rs.getString("TypeRoom").trim();
                    int NumberOFbed = rs.getInt("NumberOFbed");
                    int Area = rs.getInt("Area");
                    String Status = rs.getString("Status").trim();
                    RoomDTO room = new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, NumberOFbed, Area, Status);
                    return room;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public RoomDTO getRoomByRevenue(String personID, Date fromDate, Date toDate) {
        String sql = "SELECT TOP 1 r.HotelID, r.RoomID, r.CapacityChild, r.CapacityAdult, SUM(r.Price) AS TotalRevenue, r.Discount, r.TypeRoom, r.Status,r.Area,r.NumberOfBed\n"
                + "FROM Booking b\n"
                + "JOIN Room r ON b.HotelID = r.HotelID AND b.RoomID = r.RoomID\n"
                + "JOIN Hotel h ON b.HotelID = h.HotelID\n"
                + "WHERE h.PersonID = ? AND b.Status = 'Confirmed' AND b.TimeBooking >= ? AND b.TimeBooking <= ?\n"
                + "GROUP BY r.HotelID, r.RoomID, r.CapacityChild, r.CapacityAdult, r.Discount, r.TypeRoom, r.Status,r.Area,r.NumberOfBed\n"
                + "ORDER BY TotalRevenue DESC";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, personID);
            stm.setDate(2, fromDate);
            stm.setDate(3, toDate);

            ResultSet rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String HotelID = rs.getString("HotelID").trim();
                    String RoomID = rs.getString("RoomID").trim();
                    int CapacityChild = rs.getInt("CapacityChild");
                    int CapacityAdult = rs.getInt("CapacityAdult");
                    int Price = rs.getInt("TotalRevenue");
                    double Discount = rs.getDouble("Discount");
                    String TypeRoom = rs.getString("TypeRoom").trim();
                    int NumberOFbed = rs.getInt("NumberOFbed");
                    int Area = rs.getInt("Area");
                    String Status = rs.getString("Status").trim();
                    RoomDTO room = new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, NumberOFbed, Area, Status);
                    return room;
                }
            }
        } catch (Exception e) {
            printStackTrace();
        }
        return null;
    }

    public RoomDTO getRoomByMostBooking(String personID, Date fromDate, Date toDate) {
        String sql = "SELECT TOP 1 \n"
                + "    r.HotelID, r.RoomID, r.CapacityChild,r.CapacityAdult, r.Price, r.Discount, r.TypeRoom, r.Status, r.Area, r.NumberOfBed ,COUNT(*) AS NumberOfBookings\n"
                + "FROM Booking b\n"
                + "JOIN Room r ON b.HotelID = r.HotelID AND b.RoomID = r.RoomID\n"
                + "JOIN Hotel h ON r.HotelID = h.HotelID\n"
                + "WHERE h.PersonID = ? AND b.ArriveDate >= ? AND b.ArriveDate <= ?\n"
                + "GROUP BY r.HotelID, r.RoomID, r.CapacityChild,r.CapacityAdult, r.Price, r.Discount, r.TypeRoom, r.Status, r.Area, r.NumberOfBed\n"
                + "ORDER BY NumberOfBookings DESC;";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, personID);
            stm.setDate(2, fromDate);
            stm.setDate(3, toDate);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                String HotelID = rs.getString("HotelID").trim();
                String RoomID = rs.getString("RoomID").trim();
                int CapacityChild = rs.getInt("CapacityChild");
                int CapacityAdult = rs.getInt("CapacityAdult");
                int Price = rs.getInt("Price");
                double Discount = rs.getDouble("Discount");
                String TypeRoom = rs.getString("TypeRoom").trim();
                int NumberOFbed = rs.getInt("NumberOFbed");
                int Area = rs.getInt("Area");
                String Status = rs.getString("Status").trim();
                RoomDTO room = new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, NumberOFbed, Area, Status);
                return room;

            }
        } catch (Exception e) {
            printStackTrace();
        }
        return null;
    }

    

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
//       dao.insertRoom("h16", "r1", 3, 2, 255555, 0, 34, 2, "truong sieu cap vip pro no 1 st in the world");

        String id = dao.newRoomIDByHotel("h16");
        System.out.println(id);

    }
}
