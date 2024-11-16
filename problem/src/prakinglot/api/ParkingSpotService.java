package prakinglot.api;

import prakinglot.enties.ParkingSpot;
import prakinglot.enties.ParkingType;
import prakinglot.enties.VehicleType;

public interface ParkingSpotService {

    public ParkingSpot findParkingSpot(VehicleType parkingType);

    public boolean isGivenSlotisFree(ParkingSpot spot);

    public boolean occupySpot(ParkingSpot spot);

    public boolean freeSpot(ParkingSpot spot);

}
