package prakinglot.api;

import prakinglot.enties.Level;
import prakinglot.enties.ParkingSpot;
import prakinglot.enties.VehicleType;

public class ParkingSpotServiceImpl implements ParkingSpotService{
    @Override
    public ParkingSpot findParkingSpot(VehicleType parkingType) {

        ParkingSpaceDB instance = ParkingSpaceDB.getInstance();

        for(Level level:instance.spaceDb){
            for (ParkingSpot spot : level.spots) {
                if(spot.isNotAvailable && spot.getParkingType().equals(parkingType)){
                    return spot;
                }
            }

        }

        return null;
    }

    @Override
    public boolean isGivenSlotisFree(ParkingSpot spot) {
        return false;
    }

    @Override
    public boolean occupySpot(ParkingSpot spot) {
        return false;
    }

    @Override
    public boolean freeSpot(ParkingSpot spot) {
        return false;
    }
}
