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
            if(rs.next())
            {
               return rs.getInt("NumberOfHotel"); 
            }
            
                    
                  

        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        HotelDAO d = new HotelDAO();
       
         
                 System.out.println(d.NumberOfHotel());
                         
                         
        List<HotelDTA> list = d.getNotApproveHotel();
        for (HotelDTA hotelDTA : list) {
            System.out.println(hotelDTA);

        }

    }
}
