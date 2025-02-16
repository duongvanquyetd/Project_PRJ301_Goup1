/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdk.nashorn.internal.ir.TryNode;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class PersonDAO {

    public PersonDTA Login(String username, String pass) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select PersonID, Password, Name,Gender,Phone,RoleName from Person p, Role r  where p.PersonID = ? and p.Password = ? and r.RoleID = p.RoleID";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                PersonDTA p = new PersonDTA(rs.getString("PersonID").trim(), rs.getString("Password").trim(), rs.getString("Name").trim(), rs.getString("Gender").trim(), rs.getString("Phone").trim(), rs.getString("RoleName").trim());
                return p;
            }

        } catch (Exception e) {
        }
        return null;

    }
//lý do mà nó dư một khoảng trắng phía sau theo t nghĩ thì là do lúc tạ bảng mình tạo 255 ký tự nên nó dư ra nhiêu nên phải dùng trim vào xóa khoảng trắng
    public static void main(String[] args) {
        PersonDAO p = new PersonDAO();

        System.out.println(p.Login("quyet", "quyet").toString());
    }

}
