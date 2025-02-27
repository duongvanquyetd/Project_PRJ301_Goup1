/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.List;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author Lenovo
 */
public class HotelImageDTA {
    private String HotelID;
    private List<String> Image;

    public HotelImageDTA(String HotelID, List<String> Image) {
        this.HotelID = HotelID;
        this.Image = Image;
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
        return "HotelImageDTA{" + "HotelID=" + HotelID + ", Image=" + String.join(",", Image)+ '}';
    }

}