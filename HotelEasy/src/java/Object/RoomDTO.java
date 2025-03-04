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

    private int HotelID;
    private int RoomID;
    private int CapacityChild;
    private int CapacityAdult;
    private int Price;
    private int Discount;
    private String TypeRoom;
    private int Status;

    public RoomDTO(int HotelID, int RoomID, int CapacityChild, int CapacityAdult, int Price, int Discount, String TypeRoom, int Status) {

        this.HotelID = HotelID;
        this.RoomID = RoomID;
        this.CapacityChild = CapacityChild;
        this.CapacityAdult = CapacityAdult;
        this.Price = Price;
        this.Discount = Discount;
        this.TypeRoom = TypeRoom;
        this.Status = Status;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
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

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }

    public String getTypeRoom() {
        return TypeRoom;
    }

    public void setTypeRoom(String TypeRoom) {
        this.TypeRoom = TypeRoom;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "HotelID=" + HotelID + ", RoomID=" + RoomID + ", CapacityChild=" + CapacityChild + ", CapacityAdult=" + CapacityAdult + ", Price=" + Price + ", Discount=" + Discount + ", TypeRoom=" + TypeRoom + ", Status=" + Status + '}';
    }

}
