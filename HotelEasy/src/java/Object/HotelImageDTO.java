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
public class HotelImageDTO {
    private String hotelid;
    private List<String> image;

    public HotelImageDTO() {
    }

    public HotelImageDTO(String hotelid, List<String> image) {
        this.hotelid = hotelid;
        this.image = image;
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
        return "HotelImageDTO{" + "hotelid=" + hotelid + ", image=" + image + '}';
    }

    

}