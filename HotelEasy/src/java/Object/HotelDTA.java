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
public class HotelDTA {
    private String HotelID, PersonName,city, district , Streets,NameHotel;
    private String RateHotel;
    private int approved;
    private  double  discount;
    private  double  price;
    private int roomCount;

    public HotelDTA(String city, int roomCount) {
        this.city = city;
        this.roomCount = roomCount;
    }

   
    
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public HotelDTA(String HotelID, String city, String district, String Streets, String NameHotel, String RateHotel, double discount, double price) {
        this.HotelID = HotelID;
        this.city = city;
        this.district = district;
        this.Streets = Streets;
        this.NameHotel = NameHotel;
        this.RateHotel = RateHotel;
        this.discount = discount;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    

    public HotelDTA(String HotelID, String PersonID, String city, String district, String Streets, String NameHotel, String RateHotel, int approved) {
        this.HotelID = HotelID;
        this.PersonName = PersonID;
        this.city = city;
        this.district = district;
        this.Streets = Streets;
        this.NameHotel = NameHotel;
        this.RateHotel = RateHotel;
        this.approved = approved;
        
    }

    public HotelDTA() {
    }

    public String getHotelID() {
        return HotelID;
    }

    public void setHotelID(String HotelID) {
        this.HotelID = HotelID;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String PersonName) {
        this.PersonName = PersonName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreets() {
        return Streets;
    }

    public void setStreets(String Streets) {
        this.Streets = Streets;
    }

    public String getNameHotel() {
        return NameHotel;
    }

    public void setNameHotel(String NameHotel) {
        this.NameHotel = NameHotel;
    }

    public String getRateHotel() {
        return RateHotel;
    }

    public void setRateHotel(String RateHotel) {
        this.RateHotel = RateHotel;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }
    
    

    
    
}
