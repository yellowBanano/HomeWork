import java.util.Objects;

public class Hardtop extends Car {

    public Hardtop(String brand, String model, int yearOfIssue, int price, int power, int topSpeed) {
        super(brand, model, yearOfIssue, price, power, topSpeed);
    }

    @Override
    public boolean equals(Car car) {
        return this.getBrand().equals(car.getBrand()) && this.getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel());
    }

    @Override
    public String toString() {
        return "----------------------------\nХардтоп \"" + getBrand() + "\""
                + ":\n-Модель: " + getModel()
                + "\n-Год выпуска: " + getYearOfIssue()
                + "\n-Цена: " + getPrice() + "$"
                + "\n-Мощность: " + getPower() + " л.с."
                + "\n-Максимальная скорость: " + getTopSpeed() + " км/ч";
    }
}
