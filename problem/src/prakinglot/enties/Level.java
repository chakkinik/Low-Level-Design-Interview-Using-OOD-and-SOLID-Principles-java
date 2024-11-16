package prakinglot.enties;

import java.util.ArrayList;
import java.util.List;

public class Level {

    String level;
    public List<ParkingSpot> spots;

    public Level(String level) {
        this.level = level;
         spots = new ArrayList<>();
        //add few sports
        for (int i = 1; i <= 5; i++) {
            ParkingSpot parkingSpot = new ParkingSpot(level + i);
            if (i % 2 == 0) {
                parkingSpot.parkingType(VehicleType.SEDAN);
            }
        }

    }


}
