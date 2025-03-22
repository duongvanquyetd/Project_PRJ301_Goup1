/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class BookingDTO {

    private String hotelid, roomid, perosnid, Status;
    private Date depaturedate, arrivedate, TimeBooking;

    private  int numberofchild,numberofadult;
            
            
    public BookingDTO() {
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

    public String getPerosnid() {
        return perosnid;
    }

    public void setPerosnid(String perosnid) {
        this.perosnid = perosnid;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getDepaturedate() {
        return depaturedate;
    }

    public void setDepaturedate(Date depaturedate) {
        this.depaturedate = depaturedate;
    }

    public Date getArrivedate() {
        return arrivedate;
    }

    public void setArrivedate(Date arrivedate) {
        this.arrivedate = arrivedate;
    }

    public Date getTimeBooking() {
        return TimeBooking;
    }

    public void setTimeBooking(Date TimeBooking) {
        this.TimeBooking = TimeBooking;
    }

    public int getNumberofchild() {
        return numberofchild;
    }

    public void setNumberofchild(int numberofchild) {
        this.numberofchild = numberofchild;
    }

    public int getNumberofadult() {
        return numberofadult;
    }

    public void setNumberofadult(int numberofadult) {
        this.numberofadult = numberofadult;
    }

}