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

    private String personid, password, name,gender,phone,rolename;

    public PersonDTO() {
    }

    public PersonDTO(String PersonID, String Name, String Gender, String Phone, String RoleName) {
        this.personid = PersonID;
        this.name = Name;
        this.gender = Gender;
        this.phone = Phone;
        this.rolename = RoleName;
    }
  
    public PersonDTO(String PersonID, String Password, String Name, String Gender, String Phone, String RoleName) {
        this.personid = PersonID;
        this.password = Password;
        this.name = Name;
        this.gender = Gender;
        this.phone = Phone;
        this.rolename = RoleName;
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

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public String getRoleName() {
        return rolename;
    }

    public void setRoleName(String RoleName) {
        this.rolename = RoleName;
    }

    @Override
    public String toString() {
        return "PersonDTA{" + "PersonID=" + personid + ", Password=" + password + ", Name=" + name + ", Gender=" + gender + ", Phone=" + phone + ", RoleName=" + rolename + '}';
    }

 
   
    
}
