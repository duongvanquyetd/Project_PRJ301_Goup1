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

    public List<HotelDTA> getHotelDiscount(int index) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " SELECT H.HotelID,H.City,H.District,H.Streets,H.NameHotel,H.RateHotel,R.Discount,R.Price\n"
                    + "FROM Hotel H, Room R where H.HotelID = R.HotelID and R.RoomID = 'R1' and Approved != 0\n"
                    + "ORDER BY CAST(SUBSTRING(H.HotelID, 2, LEN(H.HotelID)) AS INT)\n"
                    + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, (index-1)*10);
            List<HotelDTA> list = new ArrayList();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");
                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");
                String rate = rs.getString("RateHotel");
                double discount = rs.getDouble("Discount");
                double price = rs.getDouble("Price");
                HotelDTA ht = new HotelDTA(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);
            }
            con.close();
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public List<HotelDTA> getNotApproveHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select HotelID,p.Name,City,District,Streets,NameHotel,RateHotel,Approved from hotel h, Person p\n"
                    + "where Approved = 0 and h.PersonID  =p.PersonID";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelDTA> list = new ArrayList();

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                list.add(new HotelDTA(rs.getString("HotelID").trim(), rs.getString("Name"), rs.getString("City"), rs.getString("District"), rs.getString("Streets"), rs.getString("NameHotel"), rs.getString("RateHotel"), rs.getInt("Approved")));
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

    public HotelDTA getHotelByOwnerID(String PersonID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select * from Hotel where PersonID = ? ";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, PersonID);
            ResultSet rs = stm.executeQuery();
            String id = rs.getString("HotelID").trim();
            String city = rs.getString("City");
            String district = rs.getString("District");
            String streets = rs.getString("Streets");
            String nameHotel = rs.getString("NameHotel");
            String rate = rs.getString("RateHotel");
            double discount = rs.getDouble("Discount");
            double price = rs.getDouble("Price");
            HotelDTA ht = new HotelDTA(id, city, district, streets, nameHotel, rate, discount, price);
            return ht;
        } catch (Exception e) {
            System.out.println("Load hotel by owner id fail " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public HotelDTA getHotelByID() {
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
    
    public void deleteHotel(String hotelID){
        String sql = " delete from Hotel where HotelID = ? ";
        try {
            Connection conn= DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            
            stm.setString(1, hotelID);
            
            stm.executeUpdate();
            
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Delete hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
     public int  getCountHotel(){
        String sql = "select count(*) from Hotel where Approved != 0 " ;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet st = stm.executeQuery();
            while(st.next()){
                return st.getInt(1) ;
            }
            
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        HotelDAO d = new HotelDAO();

        List<HotelDTA> list = d.getHotelDiscount(1);
        for (HotelDTA hotelDTA : list) {
            System.out.println(hotelDTA.getHotelID());
            
        }
HotelDAO dao = new HotelDAO();
            int count = dao.getCountHotel();
            System.out.println("" + count);

    }
   

}
