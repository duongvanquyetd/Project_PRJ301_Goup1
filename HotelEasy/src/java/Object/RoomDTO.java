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

    private String HotelID;
    private String RoomID;
    private int CapacityChild;
    private int CapacityAdult;
    private int Price;
    private String Discount;
    private String TypeRoom;
    private String Status;

    public RoomDTO(String HotelID, String RoomID, int CapacityChild, int CapacityAdult, int Price, String Discount, String TypeRoom, String Status) {
        this.HotelID = HotelID;
        this.RoomID = RoomID;
        this.CapacityChild = CapacityChild;
        this.CapacityAdult = CapacityAdult;
        this.Price = Price;
        this.Discount = Discount;
        this.TypeRoom = TypeRoom;
        this.Status = Status;
    }

    public String getHotelID() {
        return HotelID;
    }

    public void setHotelID(String HotelID) {
        this.HotelID = HotelID;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public int getCapacityChild() {
        return CapacityChild;
    }

    public void setCapacityChild(int CapacityChild) {
        this.CapacityChild = CapacityChild;
    }

    public int getCapacityAdult() {
        return CapacityAdult;
    }

    public void setCapacityAdult(int CapacityAdult) {
        this.CapacityAdult = CapacityAdult;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    public String getTypeRoom() {
        return TypeRoom;
    }

    public void setTypeRoom(String TypeRoom) {
        this.TypeRoom = TypeRoom;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "HotelID=" + HotelID + ", RoomID=" + RoomID + ", CapacityChild=" + CapacityChild + ", CapacityAdult=" + CapacityAdult + ", Price=" + Price + ", Discount=" + Discount + ", TypeRoom=" + TypeRoom + ", Status=" + Status + '}';
    }
    
}
