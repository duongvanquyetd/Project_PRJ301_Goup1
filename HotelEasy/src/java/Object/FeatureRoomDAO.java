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

    
  public List<FeatureRoomDTO> getInfAllRoom(String idHotel, int price_se, int numberbed, int numberpeople, int numberChild) {
    List<FeatureRoomDTO> list = new ArrayList<>();
    try {
        Connection con = DBUtils.getConnection();

        String sql = "SELECT " +
                "r.RoomID, r.HotelID, r.NumberOfBed, r.Price, r.Area, r.CapacityAdult, r.CapacityChild, " +
                "r.Discount, r.TypeRoom, " +
                "(SELECT STRING_AGG(Path, ',') FROM (SELECT DISTINCT Path FROM ImageRoom WHERE RoomID = r.RoomID AND HotelID = r.HotelID) AS img) AS Images, " +
                "(SELECT STRING_AGG(Gift, ',') FROM (SELECT DISTINCT Gift FROM FeatureRoom WHERE RoomID = r.RoomID AND HotelID = r.HotelID) AS ft) AS Features " +
                "FROM Room r WHERE r.HotelID = ? ";

        // Tạo các điều kiện lọc nếu có
        List<Object> parameters = new ArrayList<>();
        parameters.add(idHotel);

        if (price_se > 0) {
            sql += " AND r.Price <= ? ";
            parameters.add(price_se);
        }

        if (numberbed > 0) {
            sql += " AND r.NumberOfBed = ? ";
            parameters.add(numberbed);
        }

        if (numberpeople > 0) {
            sql += " AND r.CapacityAdult >= ? ";
            parameters.add(numberpeople);
        }

        if (numberChild > 0) {
            sql += " AND r.CapacityChild >= ? ";
            parameters.add(numberChild);
        }

        PreparedStatement stm = con.prepareStatement(sql);

        // Thiết lập các tham số theo thứ tự
        for (int i = 0   ; i < parameters.size(); i++) {
            Object param = parameters.get(i);
            if (param instanceof String) {
                stm.setString(i + 1, (String) param);
            } else if (param instanceof Integer) {
                stm.setInt(i + 1, (Integer) param);
            }
        }

        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            FeatureRoomDTO room = new FeatureRoomDTO();
            room.setRoomID(rs.getString("RoomID"));
            room.setHotelID(rs.getString("HotelID"));
            room.setNumberOfBed(rs.getInt("NumberOfBed"));
            room.setPrice(rs.getInt("Price"));
            room.setCapacityAdult(rs.getInt("CapacityAdult"));
            room.setCapacityChild(rs.getInt("CapacityChild"));
            room.setDiscount(rs.getInt("Discount"));
            room.setType(rs.getString("TypeRoom"));
            room.setArea(rs.getInt("Area"));

            String image = rs.getString("Images");
            String features = rs.getString("Features");

            if (image != null && !image.trim().isEmpty()) {
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

