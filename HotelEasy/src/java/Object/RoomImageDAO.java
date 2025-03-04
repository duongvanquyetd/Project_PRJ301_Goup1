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
 * @author Truong
 */
public class RoomImageDAO {

    public List<RoomImageDTO> load() {
        
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select imgr.* from Room r, Hotel h, ImageRoom imgr where imgr.HotelID = h.HotelID and imgr.RoomID = r.RoomID ";
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
                    if(i!= 1)
                    {
                        rs.next(); // tai sao can i != 4 thi moi rs.next vi khi = 4 nghia la chay duoc 5 lan roi nen khi rs.next no se xuong dong 6 xong len dieu kien while rs.next cai nua no se xuong dong so 7 va cai su se bi mat 1 anh 
                    }

                }

                list.add(new RoomImageDTO(roomid, hotelid, image));
              
            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }
}
