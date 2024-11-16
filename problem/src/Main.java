import prakinglot.api.EntryServiceImpl;
import prakinglot.api.EntyService;
import prakinglot.api.FeeService;
import prakinglot.api.FeeServiceImpl;
import prakinglot.api.ParkingSpaceDB;
import prakinglot.api.ParkingSpotService;
import prakinglot.api.ParkingSpotServiceImpl;
import prakinglot.enties.Level;
import prakinglot.enties.Vehicle;

public class Main {

    /*
    The parking lot should have multiple levels, each level with a certain number of parking spots.
The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
Each parking spot should be able to accommodate a specific type of vehicle.
The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
The system should track the availability of parking spots and provide real-time information to customers.
The system should handle multiple entry and exit points and support concurrent access.

     */


    /*

      Entities:

      ParkingSpot
      vehicle
      ParkingType
      Level
      ParkingFee
      checking-in cheakingtime


      Levels
      id,
      List<ParkingSpot>

      ParkingSpot
      parkingType
      id,
      Vechile--can have vechile
      free

      Vehicle.
      check-in
      check-out


      Parkingfee.
      hourFee
      type of vechile.


      API:

      Spot entry(Vehicle)
      exit(Vehicle)
      calculteFee(Vehicle)

     boolean FeePayment(



     */
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Vehicle vehicle = new Vehicle("01",1400);

        Level level = new Level("A");

        ParkingSpaceDB instance = ParkingSpaceDB.getInstance();
        instance.addLevel(level);

        ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();
        EntyService  entyService = new EntryServiceImpl();
        entyService.addParkingSerive(parkingSpotService);
        entyService.enter(vehicle);

        FeeService feeService = new FeeServiceImpl();
        // cucluate duration
        int fee = feeService.calculateFee(2, vehicle.getVehicleType());
        //pay fee
        entyService.enter(vehicle);


    }
}