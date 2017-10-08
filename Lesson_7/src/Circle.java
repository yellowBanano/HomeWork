public class Circle extends Ellipse{

    public Circle(Point center, double radius) {
        super(center, radius, radius);
    }

    @Override
    public String toString() {
        return ("Окружность:\n-Координаты центра: Х = " + super.getCenter().getX().getCoordinate()
                + " Y = " + super.getCenter().getY().getCoordinate() + "\n-Радиус = " + super.getSemiMajorAxis()
                + "\n-Периметр = " + super.perimeter() + "\n-Площадь = " + super.area());
    }
}
