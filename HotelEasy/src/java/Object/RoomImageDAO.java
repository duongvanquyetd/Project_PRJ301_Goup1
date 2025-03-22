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
import java.util.HashMap;
import java.util.LinkedHashMap;
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
                    roomid = rs.getString("RoomID").trim();
                    image.add(rs.getString("Path").trim());
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

    public List<String> getRoomImagesByHotelandRoomID(String hotelid, String roomid) {
        List<String> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT HotelID,RoomID,Path FROM ImageRoom where hotelid = ? and RoomID  =? ";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, hotelid);
            stm.setString(2, roomid);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                list.add(rs.getString("Path"));

            }

            return list;
        } catch (Exception e) {
            System.out.println("Load room img fail");
        }

        return null;
    }

    public void insertImg(String hotelid, String roomid, List<String> imgs) {
        String sql = "insert into ImageRoom (HotelID, RoomID, Path) values (?, ? ,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            for (String img : imgs) {
                stm.setString(1, hotelid);
                stm.setString(2, roomid);
                stm.setString(2, img);
                stm.executeUpdate();
            }
            conn.close();
        } catch (Exception e) {
        }
    }

    public void updateImg(String hotelID, String roomID, List<String> imgs) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "delete from ImageRoom where HotelID = ? and RoomID = ?";
            PreparedStatement stm1 = conn.prepareStatement(sql);
            stm1.setString(1, hotelID);
            stm1.setString(2, roomID);
            stm1.executeUpdate();

            sql = "insert into ImageRoom values (?, ?, ?)";
            PreparedStatement stm2 = conn.prepareStatement(sql);
            for (String img : imgs) {
                stm2.setString(1, hotelID);
                stm2.setString(2, roomID);
                stm2.setString(3, img);
                stm2.executeUpdate();
            }
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        //      RoomDAO d = new RoomDAO();
        RoomImageDAO d = new RoomImageDAO();
//
//        List<RoomDTO> roomList = roomDAO.loadRoomByHotelID("h2");
//        Map<String, List<String>> roomImages = imageDAO.getRoomImagesByHotelID("h2");
//
//        // Gắn danh sách ảnh vào từng phòng (không sửa DTO)
//        Map<RoomDTO, List<String>> roomWithImages = new LinkedHashMap<>();
//        for (RoomDTO room : roomList) {
//            List<String> images = roomImages.getOrDefault(room.getRoomid(), new ArrayList<>());
//            roomWithImages.put(room, images);
//        }
//
//        for (Map.Entry<RoomDTO, List<String>> entry : roomWithImages.entrySet()) {

        System.out.println(d.load());

    }
}
