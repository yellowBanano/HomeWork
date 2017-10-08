import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Triangle extends Polygon {

    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private double a;
    private double b;
    private double c;

    public Triangle(Point... points) {
        this.firstPoint = points[0];
        this.secondPoint = points[1];
        this.thirdPoint = points[2];
        a = firstPoint.distance(secondPoint);
        b = secondPoint.distance(thirdPoint);
        c = thirdPoint.distance(firstPoint);
    }

    public boolean isIsoscelesTriangle() {
        return (a == b) || (a == c) || (b == c);
    }

    public boolean isEquilateralTriangle() {
        return (a == b) && (b == c);
    }

    public boolean isRightTriangle() {
        return (a == sqrt(pow(b, 2) + pow(c, 2)))
                || (b == sqrt(pow(a, 2) + pow(c, 2)))
                || (c == sqrt(pow(a, 2) + pow(b, 2)));
    }

    @Override
    public double area() {
        double semiPerimeter = perimeter() / 2;
        return sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        String name = "";
        if (isEquilateralTriangle()) {
            name = "Равносторонний ";
        } else if (isIsoscelesTriangle()) {
            name = "Равнобедренный ";
        }
        if (isRightTriangle()) {
            name += "Прямоугольный ";
        }
        return (name + " Треугольник:" + "\n-Периметр = " + perimeter() + "\n-Площадь = " + area());
    }
}
