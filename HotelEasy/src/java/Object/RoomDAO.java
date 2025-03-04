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
        String sql = " select * from Room ";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int HotelID = rs.getInt("HotelID");
                    int RoomID = rs.getInt("RoomID");
                    int CapacityChild = rs.getInt("CapacityChild");
                    int CapacityAdult = rs.getInt("CapacityAdult");
                    int Price = rs.getInt("Price");
                    int Discount = rs.getInt("Discount");
                    String TypeRoom = rs.getString("TypeRoom");
                    int Status = rs.getInt("Status");

                    list.add(new RoomDTO(HotelID, RoomID, CapacityChild, CapacityAdult, Price, Discount, TypeRoom, Status));
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
        RoomDAO d = new RoomDAO();
        System.out.println(d);

    }
}
