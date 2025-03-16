/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilies.DBUtils;
import Object.FeatureRoomDTO ;
import java.util.Arrays;

/**
 *
 * @author pvand
 */
public class FeatureRoomDAO {

    // Trả về danh sách gift dưới dạng String
    public List<String> getInfRoom(String idroom, String idHotel) {
        List<String> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT Gift FROM FeatureRoom WHERE RoomID = ? AND HotelID = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idroom);
            stm.setString(2, idHotel);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String feature = rs.getString("Gift");
                list.add(feature);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ở getInfRoom: " + e.getMessage());
        }
        return list;
    }

    
  public List<FeatureRoomDTO> getInfAllRoom(String idHotel) {
    List<FeatureRoomDTO> list = new ArrayList<>();
    try {
        Connection con = DBUtils.getConnection();

        String sql = "SELECT " +
    "r.RoomID, " +
    "r.HotelID, " +
    "r.NumberOfBed, " +
    "r.Price, " +
    "r.CapacityAdult, " +
    "r.CapacityChild, " +
    "r.Discount, " +
    "r.TypeRoom, " +
    "(SELECT STRING_AGG(Path, ',') FROM (SELECT DISTINCT Path FROM ImageRoom WHERE RoomID = r.RoomID AND HotelID = r.HotelID) AS img) AS Images, " +
    "(SELECT STRING_AGG(Gift, ',') FROM (SELECT DISTINCT Gift FROM FeatureRoom WHERE RoomID = r.RoomID AND HotelID = r.HotelID) AS ft) AS Features " +
    "FROM Room r " +
    "WHERE r.HotelID = ?";


        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, idHotel);

        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            String roomid = rs.getString("RoomID");
            String hotelid = rs.getString("HotelID");
            int numberofbed = rs.getInt("NumberOfBed");
            int price = rs.getInt("Price");
            int capacityAdult = rs.getInt("CapacityAdult");
            int capacityChild = rs.getInt("CapacityChild");
            int discount = rs.getInt("Discount");
            String typeroom = rs.getString("TypeRoom");
            String features = rs.getString("Features");
            String image = rs.getString("Images");

            FeatureRoomDTO room = new FeatureRoomDTO();
            room.setRoomID(roomid);
            room.setHotelID(hotelid);
            room.setNumberOfBed(numberofbed);
            room.setPrice(price);
            room.setCapacityAdult(capacityAdult);
            room.setCapacityChild(capacityChild);
            room.setDiscount(discount);
            room.setType(typeroom);

            if (image != null && !image.isEmpty()) {
                room.setImage(Arrays.asList(image.split("\\s*,\\s*")));
            } else {
                room.setImage(new ArrayList<>());
            }

            if (features != null && !features.trim().isEmpty()) {
                room.setGift(Arrays.asList(features.split("\\s*,\\s*")));
            } else {
                room.setGift(new ArrayList<>());
            }

            list.add(room);
        }

        con.close();
    } catch (SQLException e) {
        System.out.println("Lỗi ở getInfAllRoom: " + e.getMessage());
    }
    return list;
}


}

