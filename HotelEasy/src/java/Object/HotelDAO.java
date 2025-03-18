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
public class HotelDAO {

    public List<HotelDTO> getHotelDiscount() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT TOP(5) H.HotelID,H.City,H.District,H.Streets,H.NameHotel,H.RateHotel,R.Discount,R.Price "
                    + "FROM Hotel H,Room R\n"
                    + "WHERE H.HotelID =R.HotelID AND Approved != 0\n"
                    + "ORDER BY R.Discount  DESC";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelDTO> list = new ArrayList();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("HotelID").trim();
                String personname = rs.getString("PersonID").trim();
                String city = rs.getString("City");
                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");
                String rate = rs.getString("RateHotel");
                double discount = rs.getDouble("Discount");
                double price = rs.getDouble("Price");
                int approve = rs.getInt("Approved");
                HotelDTO ht = new HotelDTO(id, personname, city, district, streets, nameHotel, rate, discount, price, approve);
                list.add(ht);
            }
            con.close();
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public List<HotelDTO> getNotApproveHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select HotelID,p.Name,City,District,Streets,NameHotel,RateHotel,Approved from hotel h, Person p\n"
                    + "where Approved = 0 and h.PersonID  =p.PersonID";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelDTO> list = new ArrayList();

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("HotelID").trim();
                String PersonID = rs.getString("PersonID");
                String city = rs.getString("City");
                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");
                String rate = rs.getString("RateHotel");
                double discount = rs.getDouble("Discount");
                double price = rs.getDouble("Price");
                HotelDTO ht = new HotelDTO(id, PersonID, city, district, streets, nameHotel, rate, price, discount, 0);
                list.add(ht);
            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public void AppvovedHotel(String HotelID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "update Hotel set Approved = 1 where HotelID =  ? ";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, HotelID);
            stm.executeQuery();

        } catch (Exception e) {
        }

    }

    public int NumberOfHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "Select count(HotelID)'NumberOfHotel' from Hotel where Approved =1 ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumberOfHotel");
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public HotelDTO getHotelByOwnerID(String PersonID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select * from Hotel h, Room r where r.HotelID = h.HotelID and h.PersonID = ? ";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, PersonID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");
                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");
                String rate = rs.getString("RateHotel");
                double discount = rs.getDouble("Discount");
                double price = rs.getDouble("Price");
                HotelDTO ht = new HotelDTO(id, PersonID, city, district, streets, nameHotel, rate, discount, price, 0);
                return ht;
            }
        } catch (Exception e) {
            System.out.println("Load hotel by owner id fail " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Integer getLowestPrice(String hotelID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select top 1 Price from Room where HotelID = ? order by Price asc";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelID);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                return Integer.parseInt(rs.getString("Price"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateHotel(String hotelID, String city, String distric, String Strees, String nameHotel, String rateHotel) {
        String sql = " update Hotel set City = ?, District = ?, Streets = ?, NameHotel = ?, RateHotel = ? where HotelID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, city);
            stm.setString(2, distric);
            stm.setString(3, Strees);
            stm.setString(4, nameHotel);
            stm.setString(5, rateHotel);
            stm.setString(6, hotelID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Update hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertHotel(String hotelID, String personID, String city, String distric, String Strees, String nameHotel, String rateHotel) {
        String sql = " insert into Hotel values(?, ?, ?, ?, ?, ?, ?, 0) ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, personID);
            stm.setString(3, city);
            stm.setString(4, distric);
            stm.setString(5, Strees);
            stm.setString(6, nameHotel);
            stm.setString(7, rateHotel);

            stm.executeQuery();

            conn.close();

        } catch (Exception e) {
            System.out.println("Insert hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteHotel(String hotelID) {
        String sql = "delete from Favorite where HotelID = ?\n"
                + "delete from Comment where HotelID = ?\n"
                + "delete from FeatureRoom where HotelID = ?\n"
                + "delete from FeatureHotel where HotelID = ?\n"
                + "delete from ImageRoom where HotelID = ?\n"
                + "delete from ImageHotel where HotelID = ?\n"
                + "delete from Booking where HotelID = ?\n"
                + "delete from Room where HotelID = ?\n"
                + "delete from Hotel where HotelID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, hotelID);
            stm.setString(3, hotelID);
            stm.setString(4, hotelID);
            stm.setString(5, hotelID);
            stm.setString(6, hotelID);
            stm.setString(7, hotelID);
            stm.setString(8, hotelID);
            stm.setString(9, hotelID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Delete hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HotelDAO d = new HotelDAO();

        d.getHotelByOwnerID("thihanh");
        System.out.println(d.toString());
    }

}
