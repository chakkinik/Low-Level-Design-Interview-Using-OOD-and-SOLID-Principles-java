package prakinglot.enties;

import java.util.Date;

public class Vehicle {

    private String vnum;

    public ParkingSpot parkingSpot;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    private VehicleType vehicleType;


    public String getVnum() {
        return vnum;
    }

    public void setVnum(String vnum) {
        this.vnum = vnum;
    }

    public int getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(int checkin_time) {
        this.checkin_time = checkin_time;
    }

    public int getCheckout_time() {
        return checkout_time;
    }

    public void setCheckout_time(int checkout_time) {
        this.checkout_time = checkout_time;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    private int checkin_time;
    private int checkout_time;
    private Date checkinDate;
    private Date checkoutDate;

    public Vehicle(String vnum, int checkin_time) {
        this.vnum = vnum;
        this.checkin_time = checkin_time;
    }
}
