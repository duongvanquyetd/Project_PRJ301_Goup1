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
public class HotelImageDAO {

    public List<HotelImageDTO> getNotApHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select HotelID, Path from ImageHotel where HotelID in(select HotelID from Hotel where Approved = 0) ";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelImageDTO> list = new ArrayList();

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String hotelid = null;
                List<String> image = new ArrayList();
                for (int i = 0; i <= 4; i++) {

                    hotelid = rs.getString("hotelid").trim();
                    image.add(rs.getString("Path"));
                    if (i != 4) {
                        rs.next(); // tai sao can i != 4 thi moi rs.next vi khi = 4 nghia la chay duoc 5 lan roi nen khi rs.next no se xuong dong 6 xong len dieu kien while rs.next cai nua no se xuong dong so 7 va cai su se bi mat 1 anh 
                    }

                }

                list.add(new HotelImageDTO(hotelid, image));

            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public List<HotelImageDTO> getAllImgHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select HotelID, Path from ImageHotel where HotelID in(select HotelID from Hotel where Approved = 1) ";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelImageDTO> list = new ArrayList();

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String hotelid = null;
                List<String> image = new ArrayList();
                for (int i = 0; i <= 4; i++) {

                    hotelid = rs.getString("hotelid").trim();
                    image.add(rs.getString("Path"));
                    if (i != 4) {
                        rs.next(); // tai sao can i != 4 thi moi rs.next vi khi = 4 nghia la chay duoc 5 lan roi nen khi rs.next no se xuong dong 6 xong len dieu kien while rs.next cai nua no se xuong dong so 7 va cai su se bi mat 1 anh 
                    }

                }

                list.add(new HotelImageDTO(hotelid, image));

            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public List<String> getImgByHotelID(String id) {
        List<String> list = new ArrayList();
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select * from ImageHotel where HotelID = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String path = rs.getString("Path");

                    list.add(path);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("fail to load img by id " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public void updateHotelImg() {
        
    }
    
    

    public static void main(String[] args) {
        HotelImageDAO j = new HotelImageDAO();
        List<String> list = j.getImgByHotelID("h5");
        for (String string : list) {
            System.out.println(string);
        }
    }

}
