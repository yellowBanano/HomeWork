public class Polygon implements Practicable {

    private Point[] points;

    public Polygon(Point... points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public double area() {
        double sumOfFirstStep = 0;
        double sumOfSecondStep = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sumOfFirstStep += points[i].getX().getCoordinate() * points[i + 1].getY().getCoordinate();
            sumOfSecondStep += points[i].getY().getCoordinate() * points[i + 1].getX().getCoordinate();
        }
        sumOfFirstStep += points[points.length - 1].getX().getCoordinate() * points[0].getY().getCoordinate();
        sumOfSecondStep += points[points.length - 1].getY().getCoordinate() * points[0].getX().getCoordinate();
        double finalArea = Math.abs(sumOfFirstStep - sumOfSecondStep) / 2;
        return finalArea;
    }

    @Override
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.length - 1; i++) {
            perimeter += points[i].distance(points[i + 1]);
        }
        perimeter += points[points.length - 1].distance(points[0]);
        return perimeter;
    }

    @Override
    public String toString() {
        String nameOfPolygon;
        switch (points.length) {
            case 1:
                nameOfPolygon = "Точка";
                return (nameOfPolygon + ":\n-Координаты точки:\n  X = "
                        + points[0].getX().getCoordinate() + " Y = " + points[0].getY().getCoordinate());
            case 2:
                nameOfPolygon = "Линия";
                return (nameOfPolygon + ":\n-Координаты первой точки:\n  X = "
                        + points[0].getX().getCoordinate() + " Y = " + points[0].getY().getCoordinate()
                        + "\n-Координаты второй точки:\n  X = " + points[1].getX().getCoordinate() + " Y = "
                        + points[1].getY().getCoordinate());
            case 3:
                return new Triangle(points).toString();
            default:
                nameOfPolygon = points.length + "-угольник";
                return (nameOfPolygon + "\n-Периметр = " + perimeter() + "\n-Площадь = " + area());
        }
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
