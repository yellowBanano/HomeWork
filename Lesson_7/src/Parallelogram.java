import static java.lang.Math.*;

public class Parallelogram extends Polygon {

    private Point upperLeftPoint;
    private Point lowerRightPoint;
    private Point lowerLeftPoint;
    private double sinAngle;

    public Parallelogram(Point upperLeftPoint, Point lowerRightPoint, Point lowerLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
        this.lowerRightPoint = lowerRightPoint;
        this.lowerLeftPoint = lowerLeftPoint;
        double a = lowerLeftPoint.distance(upperLeftPoint);
        double b = lowerLeftPoint.distance(lowerRightPoint);
        sinAngle = sin(abs(acos((pow(a, 2) + pow(b, 2) - pow(lengthOfDiagonal(), 2)) / (2 * a * b))));
    }

    public double lengthOfDiagonal() {
        return upperLeftPoint.distance(lowerRightPoint);
    }

    public Point getUpperLeftPoint() {
        return upperLeftPoint;
    }

    public Point getLowerRightPoint() {
        return lowerRightPoint;
    }

    public Point getLowerLeftPoint() {
        return lowerLeftPoint;
    }

    @Override
    public double area() {
        return lowerLeftPoint.distance(upperLeftPoint) * lowerLeftPoint.distance(lowerRightPoint) * sinAngle;
    }

    @Override
    public double perimeter() {
        return 2 * (lowerLeftPoint.distance(upperLeftPoint) + lowerLeftPoint.distance(lowerRightPoint));
    }

    @Override
    public String toString() {
        return ("Параллелограмм:\n-Длина диагонали = " + lengthOfDiagonal()
                + "\n-Периметр = " + perimeter() + "\n-Площадь = " + area());
    }
}