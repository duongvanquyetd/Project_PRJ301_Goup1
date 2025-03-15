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

    private String roomid;
    private String hotelid;
    private List<String> image;

    public RoomImageDTO(String RoomID, String HotelID, List<String> Image) {
        this.roomid = RoomID;
        this.hotelid = HotelID;
        this.image = Image;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RoomImageDTO{" + "roomid=" + roomid + ", hotelid=" + hotelid + ", image=" + image + '}';
    }

   

}