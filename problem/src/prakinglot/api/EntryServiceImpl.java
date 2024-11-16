package prakinglot.api;

import prakinglot.enties.ParkingSpot;
import prakinglot.enties.ParkingType;
import prakinglot.enties.Vehicle;
import prakinglot.enties.VehicleType;

import java.util.Objects;

public class EntryServiceImpl implements EntyService {

    ParkingSpotService parkingSpotService;

    public void addParkingSerive(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public void enter(Vehicle vehicle) {

        //punch enrty time


        ParkingSpot parkingSpot = parkingSpotService.findParkingSpot(vehicle.getVehicleType());

        if (Objects.isNull(parkingSpot)) {
            //no parking
            System.out.println("no parking");
            return;
        }
        parkingSpot.vehicle = vehicle;

        vehicle.parkingSpot = parkingSpot;

        parkingSpot.isAvailable = false;


    }

    @Override
    public void exit(Vehicle vehicle, int checkout) {

        ParkingSpot parkingSpot = vehicle.parkingSpot;
        parkingSpot.vehicle = null;
        parkingSpot.isAvailable = false;
        int checkinTime = vehicle.getCheckin_time();
        vehicle.setCheckout_time(checkout);
        int checkoutTime = vehicle.getCheckout_time();


    }
}
