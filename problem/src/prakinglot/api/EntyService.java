package prakinglot.api;

import prakinglot.enties.ParkingSpot;
import prakinglot.enties.Vehicle;

public interface EntyService {

    public void addParkingSerive(ParkingSpotService parkingSpotService);

    public void enter(Vehicle vehicle);

    public void exit(Vehicle vehicle, int checkout);
}
