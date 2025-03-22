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
public class FeatureHotelDAO {

    public List<String> getFeatureHotelByHotelID(String hotelID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select   Feature from FeatureHotel where hotelid = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelID);

            List<String> list = new ArrayList();
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                list.add(rs.getNString("Feature"));

            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public List<String> getFeatureHotelByHotelID(List<HotelDTO> ho) {
        try {
            List<String> hotelID = new ArrayList<>();
            for (HotelDTO hotelDTA : ho) {
               hotelID.add(hotelDTA.getHotelID());
            }
            Connection con = DBUtils.getConnection();
            String a = "";
            for (int i = 0; i < hotelID.size(); i++) {
                  if(i == hotelID.size()-1)
                  {
                      a+="'"+hotelID.get(i)+"'";
                  }
                  else
                  {
                      a+="'" +hotelID.get(i)+"',";
                  }
            }
                 
            String sql = " select   Feature from FeatureHotel where hotelid in("+a+") group by Feature ";
            PreparedStatement stm = con.prepareStatement(sql);

           
            List<String> list = new ArrayList();
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                list.add(rs.getNString("Feature"));

            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public static void main(String[] args) {
        FeatureHotelDAO d = new FeatureHotelDAO();
       
    }
}
