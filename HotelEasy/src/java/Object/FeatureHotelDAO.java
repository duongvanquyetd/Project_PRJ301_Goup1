/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Array;
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
//public class FeatureHotelDAO {
//
//    public List<String> getFeatureHotelByHotelID(String hotelID) {
//        try {
//            Connection con = DBUtils.getConnection();
//            String sql = " select   Feature from FeatureHotel where hotelid = ? ";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, hotelID);
//
//            List<String> list = new ArrayList();
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//
//                list.add(rs.getNString("Feature"));
//
//            }
//            return list;
//        } catch (Exception e) {
//        }
//
//        return null;
//    }
//
//    public List<String> getFeatureHotelByHotelID(List<HotelDTO> ho) {
//        try {
//            List<String> hotelID = new ArrayList<>();
//            for (HotelDTO hotelDTA : ho) {
//               hotelID.add(hotelDTA.getHotelID());
//            }
//            Connection con = DBUtils.getConnection();
//            String a = "";
//            for (int i = 0; i < hotelID.size(); i++) {
//                  if(i == hotelID.size()-1)
//                  {
//                      a+="'"+hotelID.get(i)+"'";
//                  }
//                  else
//                  {
//                      a+="'" +hotelID.get(i)+"',";
//                  }
//            }
//                 
//            String sql = " select   Feature from FeatureHotel where hotelid in("+a+") group by Feature ";
//            PreparedStatement stm = con.prepareStatement(sql);
//
//           
//            List<String> list = new ArrayList();
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//
//                list.add(rs.getNString("Feature"));
//
//            }
//            return list;
//        } catch (Exception e) {
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        FeatureHotelDAO d = new FeatureHotelDAO();
//       
//=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ultilies.DBUtils;

/**
 *
 * @author pvand
 */
public class FeatureHotelDAO {

    public List<String> getInfImgHotel(String idHotel) {
        List<String> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "Select Feature from FeatureHotel where HotelID = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idHotel);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String featureHotel = rs.getString("Feature");
                list.add(featureHotel);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ở feature Hotel DAO" + e.getLocalizedMessage());
        }
        return list;
    }

    public List<FeatureHotelDTO> getInfHotel(String idHotel) {
        List<FeatureHotelDTO> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT h.HotelID, h.NameHotel, h.Streets, h.District, h.City, h.RateHotel,\n"
                    + "       STRING_AGG(f.Feature, ', ') AS AllFeatures\n"
                    + "FROM FeatureHotel f\n"
                    + "JOIN Hotel h ON f.HotelID = h.HotelID\n"
                    + "WHERE f.HotelID = ?\n"
                    + "GROUP BY h.HotelID, h.NameHotel, h.Streets, h.District, h.City, h.RateHotel ;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, idHotel);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String featureHotel = rs.getString("AllFeatures");
                String hotelName = rs.getString("NameHotel");
                String allFeature = rs.getString("AllFeatures");
                String streets = rs.getString("Streets");
                String district = rs.getString("District");
                String city = rs.getString("City");
                String rate = rs.getString("RateHotel");
                FeatureHotelDTO hotel = new FeatureHotelDTO();
                hotel.setFeature(featureHotel);
                hotel.setFeatureList(Arrays.asList(allFeature.split(",\\s*")));
                hotel.setNameHotel(hotelName);
                hotel.setStreets(streets);
                hotel.setDistricts(district);
                hotel.setCity(city);
                hotel.setRateHotel(rate);
                list.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ở feature Hotel DAO" + e.getLocalizedMessage());
        }
        return list;

    }
}
