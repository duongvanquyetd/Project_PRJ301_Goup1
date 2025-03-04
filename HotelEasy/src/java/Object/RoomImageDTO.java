/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.List;

/**
 *
 * @author Truong
 */
public class RoomImageDTO {

    private String RoomID;
    private String HotelID;
    private List<String> Image;

    public RoomImageDTO(String RoomID, String HotelID, List<String> Image) {
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.Image = Image;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public String getHotelID() {
        return HotelID;
    }

    public void setHotelID(String HotelID) {
        this.HotelID = HotelID;
    }

    public List<String> getImage() {
        return Image;
    }

    public void setImage(List<String> Image) {
        this.Image = Image;
    }

    @Override
    public String toString() {
        return "RoomImageDTO{" + "RoomID=" + RoomID + ", HotelID=" + HotelID + ", Image=" + Image + '}';
    }

}