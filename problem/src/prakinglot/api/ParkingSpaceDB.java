package prakinglot.api;

import prakinglot.enties.Level;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceDB {


    List<Level> spaceDb;

    private static ParkingSpaceDB instance = new ParkingSpaceDB();


    private ParkingSpaceDB() {
        spaceDb = new ArrayList<>();

    }

    public void addLevel(Level level) {
        spaceDb.add(level);
    }

    public static ParkingSpaceDB getInstance() {
        return instance;
    }


}
