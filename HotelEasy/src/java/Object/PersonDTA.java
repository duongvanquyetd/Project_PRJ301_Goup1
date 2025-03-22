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
public class PersonDTA {

    private String PersonID, Password, name,Gender,Phone,RoleName;

    public PersonDTA(String PersonID, String Name, String Gender, String Phone, String RoleName) {
        this.PersonID = PersonID;
        this.name = Name;
        this.Gender = Gender;
        this.Phone = Phone;
        this.RoleName = RoleName;
    }
  
    public PersonDTA(String PersonID, String Password, String Name, String Gender, String Phone, String RoleName) {
        this.PersonID = PersonID;
        this.Password = Password;
        this.name = Name;
        this.Gender = Gender;
        this.Phone = Phone;
        this.RoleName = RoleName;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    @Override
    public String toString() {
        return "PersonDTA{" + "PersonID=" + PersonID + ", Password=" + Password + ", Name=" + name + ", Gender=" + Gender + ", Phone=" + Phone + ", RoleName=" + RoleName + '}';
    }

 
   
    
}
