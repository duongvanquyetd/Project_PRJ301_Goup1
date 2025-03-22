/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Truong
 */
public class RoomDTO {

    private String hotelid;
    private String roomid;
    private int capacitychild;
    private int capacityadult;
    private int price;
    private double discount;
    private String typeroom;
    private int numberofbed;
    private int area;
    private String status;

    public RoomDTO() {
    }

    public RoomDTO(String hotelid, String roomid, int capacitychild, int capacityadult, int price, double discount, String typeRoom, int numberofbed, int area, String status) {
        this.hotelid = hotelid;
        this.roomid = roomid;
        this.capacitychild = capacitychild;
        this.capacityadult = capacityadult;
        this.price = price;
        this.discount = discount;
        this.typeroom = typeRoom;
        this.numberofbed = numberofbed;
        this.area = area;
        this.status = status;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public int getCapacitychild() {
        return capacitychild;
    }

    public void setCapacitychild(int capacitychild) {
        this.capacitychild = capacitychild;
    }

    public int getCapacityadult() {
        return capacityadult;
    }

    public void setCapacityadult(int capacityadult) {
        this.capacityadult = capacityadult;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getTyperoom() {
        return typeroom;
    }

    public void setTyperoom(String typeRoom) {
        this.typeroom = typeRoom;
    }

    public int getNumberofbed() {
        return numberofbed;
    }

    public void setNumberofbed(int numberofbed) {
        this.numberofbed = numberofbed;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "hotelid=" + hotelid + ", roomid=" + roomid + ", capacitychild=" + capacitychild + ", capacityadult=" + capacityadult + ", price=" + price + ", discount=" + discount + ", typeroom=" + typeroom + ", numberofbed=" + numberofbed + ", area=" + area + ", status=" + status + '}';
    }

}
