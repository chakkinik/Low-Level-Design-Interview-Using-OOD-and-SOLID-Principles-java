package carrentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

  static   Map<String, List<Car>> inventory = new ConcurrentHashMap<>();

  static {
      String s ="bangalore";
      String d="chennai";
      String key = s+"-"+d;
      inventory.put(key, new ArrayList<>());
  }


  public  static List<Car> getCar(String source, String dest){
      String key = source+"-"+dest;
      return inventory.get(key);
  }


  public static void addCar(String source, String dest,Car car){
      String key = source+"-"+dest;
      List<Car> cars = inventory.get(key);
      cars.add(car);
      inventory.put(key,cars);
  }

}
