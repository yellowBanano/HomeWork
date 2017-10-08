public class Rectangle extends Parallelogram {

    public Rectangle(Point upperLeftPoint, Point lowerRightPoint, Point lowerLeftPoint) {
        super(upperLeftPoint, lowerRightPoint, lowerLeftPoint);
    }

    @Override
    public double area() {
        return getLowerLeftPoint().distance(getUpperLeftPoint()) * getLowerLeftPoint().distance(getLowerRightPoint());
    }

    @Override
    public String toString() {
        return ("Прямоугольник:\n-Длина диагонали = " + lengthOfDiagonal()
                + "\n-Периметр = " + perimeter() + "\n-Площадь = " + area());
    }
}
