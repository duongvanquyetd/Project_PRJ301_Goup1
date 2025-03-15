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
public class HotelDTO {

    private String hotelid, personname, city, district, streets, namehotel;
    private String ratehotel;
    private int approved;
    private double discount;
    private double price;

    public HotelDTO() {
    }
    
    public HotelDTO(String hotelid, String personname, String city, String district, String streets, String namehotel, String ratehotel, double discount, double price,int approved) {
        this.hotelid = hotelid;
        this.personname = personname;
        this.city = city;
        this.district = district;
        this.streets = streets;
        this.namehotel = namehotel;
        this.ratehotel = ratehotel;
        this.approved = approved;
        this.discount = discount;
        this.price = price;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
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
        return streets;
    }

    public void setStreets(String streets) {
        this.streets = streets;
    }

    public String getNamehotel() {
        return namehotel;
    }

    public void setNamehotel(String namehotel) {
        this.namehotel = namehotel;
    }

    public String getRatehotel() {
        return ratehotel;
    }

    public void setRatehotel(String ratehotel) {
        this.ratehotel = ratehotel;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelDTA{" + "hotelid=" + hotelid + ", personname=" + personname + ", city=" + city + ", district=" + district + ", streets=" + streets + ", namehotel=" + namehotel + ", ratehotel=" + ratehotel + ", approved=" + approved + ", discount=" + discount + ", price=" + price + '}';
    }

  

}
