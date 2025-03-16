/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class FeatureHotelDTO {
    
    private String hotelid;
    private List<String> feature;

    public FeatureHotelDTO(String hotelid, List<String> feature) {
        this.hotelid = hotelid;
        this.feature = feature;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "FeatureDTO{" + "hotelid=" + hotelid + ", feature=" + feature + '}';
    }
    
    
    
    
    
    
}
