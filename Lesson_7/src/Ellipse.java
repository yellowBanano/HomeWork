import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Ellipse implements Practicable{

    private Point center;
    private double semiMajorAxis;
    private double semiMinorAxis;

    public Ellipse(Point center, double semiMajorAxis, double semiMinorAxis) {
        this.center = center;
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    public Point getCenter() {
        return center;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    @Override
    public String toString() {
        return ("Эллипс:\n-Координаты центра: Х = " + center.getX().getCoordinate()
                + " Y = " + center.getY().getCoordinate() + "\n-Большая полуось = " + semiMajorAxis
                + "\n-Малая полуось = " + semiMinorAxis + "\n-Периметр = " + perimeter() + "\n-Площадь = " + area());
    }

    @Override
    public double perimeter() {
        return 2 * PI * sqrt((pow(semiMajorAxis, 2) + pow(semiMinorAxis, 2)) / 2);
    }

    @Override
    public double area() {
        return PI * semiMinorAxis * semiMajorAxis;
    }

    @Override
    public boolean isAreaEqualTo(Polygon polygon) {
        return this.area() == polygon.area();
    }

    @Override
    public boolean isAreaEqualTo(Ellipse ellipse) {
        return this.area() == ellipse.area();
    }
}
