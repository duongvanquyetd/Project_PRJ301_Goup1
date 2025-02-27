/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class RoomDAO {
    
    public int NumberOfRoom()
    {
        
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select count(*)'NumberOfRoom' from Room  ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
               return rs.getInt("NumberOfRoom"); 
            }
            
                    
                  

        } catch (Exception e) {
        }
        return 0;
    }
    
    public static void main(String[] args) {
        RoomDAO d = new RoomDAO();
        System.out.println(d.NumberOfRoom()); 
              
    }
}
