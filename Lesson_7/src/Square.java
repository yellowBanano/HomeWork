public class Square extends Parallelogram  {

    public Square(Point upperLeftPoint, Point lowerRightPoint, Point lowerLeftPoint) {
        super(upperLeftPoint, lowerRightPoint, lowerLeftPoint);
    }

    @Override
    public double area() {
        return Math.pow(lengthOfDiagonal(), 2) / 2;
    }

    @Override
    public double perimeter() {
        return 2 * Math.sqrt(2) * lengthOfDiagonal();
    }

    @Override
    public String toString() {
        return ("Квадрат:\n-Длина диагонали = " + lengthOfDiagonal()
                + "\n-Периметр = " + perimeter() + "\n-Площадь = " + area());
    }
}
