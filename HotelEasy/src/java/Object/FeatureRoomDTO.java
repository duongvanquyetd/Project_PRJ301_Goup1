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
public class FeatureRoomDTO {
    private String hotelID ;
    private String roomID ;
    public List<String> gift = new ArrayList<>();
    public int price ;
    public int capacityChild ;
    public int capacityAdult ;
    public int discount ;
    public String type ;
    public int numberOfBed ;
    public int area ;
    public List<String> image = new ArrayList<>();

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }


    

    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacityChild() {
        return capacityChild;
    }

    public void setCapacityChild(int capacityChild) {
        this.capacityChild = capacityChild;
    }

    public int getCapacityAdult() {
        return capacityAdult;
    }

    public void setCapacityAdult(int capacityAdult) {
        this.capacityAdult = capacityAdult;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }
    

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public List<String> getGift() {
        return gift;
    }

    public void setGift(List<String> gift) {
        this.gift = gift;
    }

  
    
    
}
