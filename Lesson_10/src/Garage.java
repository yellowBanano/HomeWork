import java.util.HashMap;
import java.util.Map;

public class Garage {

    private Map<Car, Integer> garage = new HashMap<>();

    public void park(Car car) {
        garage.put(car, garage.containsKey(car) ? garage.get(car) + 1 : 1);
        System.out.println("Машина " + car.getBrand() + " " + car.getModel() + " припаркована");
    }

    public void departure(Car car) {
        if (garage.containsKey(car)) {
            if (garage.get(car) > 1) {
                garage.put(car, garage.get(car) - 1);
            } else {
                garage.remove(car);
            }
            System.out.println("Машина " + car.getBrand() + " " + car.getModel() + " выехала из гаража");
        } else {
            System.out.println("Нечему выезжать");
        }
    }

    public int numberOf(Car car) {
        int number = 0;
        for (Car parkedCar : garage.keySet()) {
            if (car.hashCode() == parkedCar.hashCode()) {
                number += garage.get(parkedCar);
            }
        }
        return number;
    }

    @Override
    public String toString() {
        garage.forEach((key, value) -> System.out.println(key + " - в гараже " + value + " шт."));
        return "";
    }
}
