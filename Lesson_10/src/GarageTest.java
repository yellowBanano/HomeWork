public class GarageTest {

    public static void main(String[] args) {

        Garage garage = new Garage();
        Car bogdan1 = new Van("Bogdan", "2310", 2009, 2800, 80, 110);
        Car bogdan2 = new Van("Bogdan", "2310", 2012, 3000, 85, 120);
        Car zil = new Phaeton("ЗИЛ", "111", 1959, 13000, 200, 170);
        Car mercedes = new Hardtop("Mercedes-Benz", "CL600", 2013, 20000, 435, 220);
        Car international = new Wagon("International", "MXL", 2010, 110000, 310, 180);
        System.out.println(bogdan1.equals(bogdan2));
        System.out.println(bogdan1.equals(zil));
        garage.park(bogdan1);
        garage.park(bogdan1);
        garage.park(bogdan2);
        garage.park(zil);
        garage.park(mercedes);
        System.out.println(garage.numberOf(bogdan1) + " шт.");
        garage.departure(international);
        garage.park(international);
        System.out.println(garage);
        garage.departure(bogdan1);
        garage.departure(bogdan2);
        System.out.println(garage);
    }
}
