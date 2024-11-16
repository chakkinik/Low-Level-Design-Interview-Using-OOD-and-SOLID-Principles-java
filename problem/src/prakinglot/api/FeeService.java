package prakinglot.api;

import prakinglot.enties.ParkingType;
import prakinglot.enties.Vehicle;
import prakinglot.enties.VehicleType;

public interface FeeService {

    int calculateFee(int duration, VehicleType parkingType);
}
