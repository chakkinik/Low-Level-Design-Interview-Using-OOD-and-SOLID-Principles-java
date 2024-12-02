package prakinglot.enties;

public class ParkingSpot {
    private String id;
    public boolean isNotAvailable;
    public Vehicle vehicle;
    private VehicleType parkingType;

    public ParkingSpot(String id) {
        this.id = id;
    }

    public VehicleType getParkingType() {
        return parkingType;
    }

    public void parkingType(VehicleType vehicleType) {
        this.parkingType = vehicleType;
    }
}
