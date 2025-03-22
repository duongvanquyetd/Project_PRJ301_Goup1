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
import jdk.nashorn.internal.ir.TryNode;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class PersonDAO {

    public PersonDTO Login(String username, String pass) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select PersonID, Password, Name,Gender,Phone,RoleName from Person p, Role r  where p.PersonID = ? and p.Password = ? and r.RoleID = p.RoleID";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                PersonDTO p = new PersonDTO(rs.getString("PersonID").trim(), rs.getString("Password").trim(), rs.getString("Name").trim(), rs.getString("Gender").trim(), rs.getString("Phone").trim(), rs.getString("RoleName").trim());
                return p;
            }

        } catch (Exception e) {
        }
        return null;

    }

    public void RegisterPerson(PersonDTO p) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "INSERT INTO Person (PersonID, Password, Name, Gender, Phone, RoleID) VALUES  \n"
                    + " (?,?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, p.getPersonid());
            stm.setString(2, p.getPassword());
            stm.setString(3, p.getName());
            stm.setString(4, p.getGender());
            stm.setString(5, p.getPhone());
            stm.setString(6, p.getRoleName());
            stm.executeQuery();
        } catch (Exception e) {
        }

    }

    public void RegisterPersonDatHO(PersonDTO p) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "insert into Person (PersonID,Name,Phone,RoleID) values (?,?,?,?)  ";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, p.getPersonid());
            stm.setString(2, p.getName());
            stm.setString(3, p.getPhone());
            stm.setString(4, p.getRoleName());
            stm.executeQuery();
        } catch (Exception e) {
        }

    }

    public boolean CheckUserName(String username) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select PersonID, Password, Name,Gender,Phone,RoleName from Person p, Role r  where p.PersonID = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean checkPassword(String password) {
        int countLetter = 0;
        int countNumber = 0;

        if (password.length() < 6 || password.length() > 18) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i))) {
                countLetter++;
            }
            if (Character.isDigit(password.charAt(i))) {
                countNumber++;
            }
        }
        if (countLetter == 0 || countNumber == 0) {
            return false;
        }
        return true;
    }
//lý do mà nó dư một khoảng trắng phía sau theo t nghĩ thì là do lúc tạ bảng mình tạo 255 ký tự nên nó dư ra nhiêu nên phải dùng trim vào xóa khoảng trắng

    public PersonDTO getAllPersonByID(String personid) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select PersonID, Name,Gender,Phone,RoleID from Person  where PersonID = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, personid);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                PersonDTO p = new PersonDTO(rs.getString("PersonID").trim(), rs.getString("Name").trim(), rs.getString("Gender"), rs.getString("Phone").trim(), rs.getString("RoleID").trim());
               return p;
            }
          
        } catch (Exception e) {
        }
        return null;
    }

    public List<PersonDTO> getAllPerson() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select PersonID, Name,Gender,Phone,RoleID from Person  where RoleID in('R2','R3') ";
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            List<PersonDTO> list = new ArrayList();
            while (rs.next()) {
                list.add(new PersonDTO(rs.getString("PersonID").trim(), rs.getString("Name").trim(), rs.getString("Gender"), rs.getString("Phone").trim(), rs.getString("RoleID").trim()));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void deletebyUserid(String id) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "delete  from Booking where PersonID = ?"
                    + " delete  from Person where PersonID = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, id);
            stm.executeQuery();

        } catch (Exception e) {
        }

    }

    public int NumberOfUser() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "Select count(PersonID)'NumberOfUser' from Person where roleid = 'R2' ";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.executeQuery();
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumberOfUser");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int NumberOfHotelOwner() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "Select count(PersonID)'NumberOfHotelOwner' from Person where roleid = 'R3' ";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.executeQuery();
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumberOfHotelOwner");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        PersonDAO p = new PersonDAO();
//        PersonDTO dd = new PersonDTO();
//        dd.setPersonid("aaa");
//        dd.setName("bbb");
//        dd.setPhone("234823");
//        dd.setRoleName("R2");
//      p.RegisterPersonDatHO(dd);

        System.out.println( p.getAllPersonByID("quyet"));

    }
}
