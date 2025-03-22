/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
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

    public List<RoomDTO> load() {
        List<RoomDTO> list = new ArrayList<RoomDTO>();
        try {
            String sql = " select * from Room ";
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    String HotelID = rs.getString("HotelID").trim();
                    String RoomID = rs.getString("RoomID").trim();
                    int CapacityChild = rs.getInt("CapacityChild");
                    int CapacityAdult = rs.getInt("CapacityAdult");
                    int Price = rs.getInt("Price");
                    String Discount = rs.getString("Discount").trim();
                    String TypeRoom = rs.getString("TypeRoom").trim();
                    String Status = rs.getString("Status").trim();
                    RoomDTO room = new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, Status);
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

    public void updateRoom(String hotelID, String roomID, int capacityAdult, int capacityChild, int price, int discount, String typeRoom) {
        String sql = " update Room set CapacityAdult = ?, CapacityChild = ?, Price = ?, Discount = ?, TypeRoom = ?, Status= 0 where HotelID = ? and RoomID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, capacityAdult);
            stm.setInt(2, capacityChild);
            stm.setInt(3, price);
            stm.setInt(4, discount);
            stm.setString(5, typeRoom);
            stm.setString(6, hotelID);
            stm.setString(7, roomID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Update hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertRoom(String hotelID, String roomID, int capacityAdult, int capacityChild, int price, int discount, String typeRoom) {
        String sql = " insert into Room values(?, ?, ?, ?, ?, ?, ?, 0) ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, roomID);
            stm.setInt(3, capacityAdult);
            stm.setInt(4, capacityChild);
            stm.setInt(5, price);
            stm.setInt(6, discount);
            stm.setString(7, typeRoom);

            stm.executeQuery();

            conn.close();

        } catch (Exception e) {
            System.out.println("Insert hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteRoom(String hotelID, String roomID) {
        String sql = " delete from Room where HotelID = ? and RoomID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, roomID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Delete room fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getStatusOfRoom(String roomID, String hotelId) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "select r.Status   from Room r  where r.RoomID = ? and r.HotelID = ? ";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, roomID);
            stm.setString(2, hotelId);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Status");
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return -2;
    }

    public RoomDTO GetCapacityPerson(String roomID, String hotelId) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "select  r.CapacityAdult,r.CapacityChild from Room r  where r.RoomID = ? and r.HotelID = ?";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, roomID);
            stm.setString(2, hotelId);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                RoomDTO r = new RoomDTO();
                r.setCapacityAdult(rs.getInt("CapacityAdult"));
                r.setCapacityChild(rs.getInt("CapacityChild"));

                return r;
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public RoomDTO getRoomByID(String RoomID, String HotelID) {
          

        
        try {
            String sql = " select HotelID,RoomID,CapacityChild,CapacityAdult,Price,Discount,TypeRoom,Status from Room where HotelID =? and RoomID = ? ";
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, HotelID);
            stm.setString(2, RoomID);
            ResultSet rs = stm.executeQuery();

                if (rs.next()) {
                    
                    String hid = rs.getString("HotelID").trim();
                    String rid = rs.getString("RoomID").trim();
                    int CapacityChild = rs.getInt("CapacityChild");
                    int CapacityAdult = rs.getInt("CapacityAdult");
                    int Price = rs.getInt("Price");
                    String Discount = rs.getString("Discount").trim();
                    String TypeRoom = rs.getString("TypeRoom").trim();
                    String Status = rs.getString("Status").trim();
                    RoomDTO room = new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, Status);
                   return room;
                }
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Load Room Data fail " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    
}

public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
//        List<RoomDTO> list = dao.load();
//        for (RoomDTO arg : list) {
//            System.out.println(arg);

        System.out.println(dao.getRoomByID("R1", "H1"));
//        }
//
    }
}
