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

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        List<RoomDTO> list = dao.load();
        for (RoomDTO arg : list) {
            System.out.println(arg);
        }

    }
}
