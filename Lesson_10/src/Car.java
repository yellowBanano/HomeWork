public abstract class Car {

    private String brand;
    private String model;
    private int yearOfIssue;
    private int price;
    private int power;
    private int topSpeed;

    public Car(String brand, String model, int yearOfIssue, int price, int power, int topSpeed) {
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.price = price;
        this.power = power;
        this.topSpeed = topSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public abstract boolean equals(Car car);
}
