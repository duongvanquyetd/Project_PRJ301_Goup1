/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Date;

/**
 *
 * @author Truong
 */
public class BookingDTO {

    private String hotelid;
    private String roomid;
    private String personname;
    private int numberchild;
    private int numberadult;
    private Date departuredate;
    private Date arrivedate;
    private Date timebooking;
    private String status;

    public BookingDTO(String hotelid, String roomid, String personname, int numberchild, int numberadult, Date departuredate, Date arrivedate, Date timebooking, String status) {
        this.hotelid = hotelid;
        this.roomid = roomid;
        this.personname = personname;
        this.numberchild = numberchild;
        this.numberadult = numberadult;
        this.departuredate = departuredate;
        this.arrivedate = arrivedate;
        this.timebooking = timebooking;
        this.status = status;
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

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personid) {
        this.personname = personid;
    }

    public int getNumberchild() {
        return numberchild;
    }

    public void setNumberchild(int numberchild) {
        this.numberchild = numberchild;
    }

    public int getNumberadult() {
        return numberadult;
    }

    public void setNumberadult(int numberadult) {
        this.numberadult = numberadult;
    }

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date depaturedate) {
        this.departuredate = depaturedate;
    }

    public Date getArrivedate() {
        return arrivedate;
    }

    public void setArrivedate(Date arrivedate) {
        this.arrivedate = arrivedate;
    }

    public Date getTimebooking() {
        return timebooking;
    }

    public void setTimebooking(Date timebooking) {
        this.timebooking = timebooking;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingDTO{" + "hotelid=" + hotelid + ", roomid=" + roomid + ", personname=" + personname + ", numberchild=" + numberchild + ", numberadult=" + numberadult + ", depaturedate=" + departuredate + ", arrivedate=" + arrivedate + ", timebooking=" + timebooking + ", status=" + status + '}';
    }

}
