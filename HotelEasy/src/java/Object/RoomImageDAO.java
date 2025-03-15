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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ultilies.DBUtils;

/**
 *
 * @author Truong
 */
public class RoomImageDAO {

    public List<RoomImageDTO> load() {

        try {
            Connection con = DBUtils.getConnection();
            String sql = " select imgr.* from  ImageRoom imgr  ";
            PreparedStatement stm = con.prepareStatement(sql);

            List<RoomImageDTO> list = new ArrayList();

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String hotelid = null;
                String roomid = null;
                List<String> image = new ArrayList();
                for (int i = 0; i <= 1; i++) {

                    hotelid = rs.getString("hotelid").trim();
                    roomid = rs.getString("RoomID");
                    image.add(rs.getString("Path"));
                    if (i != 1) {
                        rs.next();
                    }

                }

                list.add(new RoomImageDTO(roomid, hotelid, image));

            }
            return list;
        } catch (Exception e) {
            System.out.println("Load room img fail");
        }

        return null;
    }

    public List<RoomImageDTO> getAllRoomsByHotelID(String hotelID) {
        List<RoomImageDTO> roomList = new ArrayList<>();
        String sql = "SELECT RoomID, HotelID, Path FROM ImageRoom WHERE HotelID = ? ORDER BY RoomID";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, hotelID);
            ResultSet rs = stm.executeQuery();

            Map<String, RoomImageDTO> roomMap = new HashMap<>();

            while (rs.next()) {
                String roomID = rs.getString("RoomID");
                String path = rs.getString("Path");

                if (!roomMap.containsKey(roomID)) {
                    roomMap.put(roomID, new RoomImageDTO(roomID, hotelID, new ArrayList<>()));
                }
                roomMap.get(roomID).getImage().add(path);
            }

            roomList.addAll(roomMap.values());

        } catch (Exception e) {
            System.out.println("Error loading room images: " + e.getMessage());
        }

        return roomList;
    }

    public static void main(String[] args) {
        HotelDAO hotelDAO = new HotelDAO();
        HotelDTO hotel = hotelDAO.getHotelByOwnerID("vanbinh");
        RoomDAO roomDAO = new RoomDAO();

        RoomImageDAO imgDAO = new RoomImageDAO();
        List<RoomImageDTO> listRoomImg = imgDAO.load();
        for (RoomImageDTO roomImageDTO : listRoomImg) {
            if (roomImageDTO.getHotelid().equals(hotel.getHotelid())) {
                for (String string : roomImageDTO.getImage()) {
                    System.out.println(string);
                }
            }
        }

    }
}
