/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object ;

import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultilies.DBUtils;


/**
 *
 * @author pvand
 */
public class commentDAO {
    public List<commentDTO> getcomment(String hotelID){
        List<commentDTO> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT c.HotelID, c.PersonID, c.Desciption, p.Name , c.Star\n" +
            "FROM Comment c\n" +
              "JOIN Person p ON c.PersonID = p.PersonID\n" +
            "WHERE c.HotelID = ? " ;
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, hotelID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                String hotelID1 = rs.getString("HotelID");
                String personID = rs.getString("PersonID") ;
                String description = rs.getString("Desciption");
                String name = rs.getString("Name");
                int star = rs.getInt("Star");
                
                commentDTO cmt = new commentDTO();
                cmt.setHotelID(hotelID);
                cmt.setPerID(personID);
                cmt.setName(name);;
                cmt.setDesciption(description);
                cmt.setStar(star);
                
                list.add(cmt);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ở commentDAO" + e.getLocalizedMessage());
            
        }
        return list ;
    }
        
    
}
