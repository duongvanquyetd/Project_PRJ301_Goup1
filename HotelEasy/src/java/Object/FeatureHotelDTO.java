/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;


import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author pvand
 */
public class FeatureHotelDTO {
    private String id ;
    public String Feature ;
    public String nameHotel ;
    public String rateHotel ;
    public String streets ;
    public String districts ;
    public String city ;
    public List<String> featureList = new ArrayList<>() ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeature() {
        return Feature;
    }

    public void setFeature(String Feature) {
        this.Feature = Feature;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getRateHotel() {
        return rateHotel;
    }

    public void setRateHotel(String rateHotel) {
        this.rateHotel = rateHotel;
    }

    public String getStreets() {
        return streets;
    }

    public void setStreets(String streets) {
        this.streets = streets;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFeatureList(List<String> featureList) {
        this.featureList = featureList;
    }
    
    
    public  List<String> getFeatureList(){
        
        return featureList;
    }
    

    
    
    
}
