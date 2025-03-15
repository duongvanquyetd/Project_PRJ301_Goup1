/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Lenovo
 */
public class PersonDTO {

    private String personid, password, name, gender, phone, rolename;

    public PersonDTO(String personid, String password, String name, String gender, String phone, String rolename) {
        this.personid = personid;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.rolename = rolename;
    }

    public PersonDTO() {
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "personid=" + personid + ", password=" + password + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", rolename=" + rolename + '}';
    }

}
