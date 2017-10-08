public class CoordinatePlane {

    public static void main(String[] args) {

        Point center = new Point(new Coordinate(0), new Coordinate(0));

        Ellipse circle = new Circle(center, 2);
        System.out.println(circle);

        Ellipse ellipse = new Ellipse(center, 2, 1);
        System.out.println(ellipse);

        System.out.println(ellipse.isAreaEqualTo(circle));

        Point point1 = new Point(new Coordinate(0), new Coordinate(0));
        Point point2 = new Point(new Coordinate(3), new Coordinate(1));
        Point point3 = new Point(new Coordinate(2), new Coordinate(2));
        Point point4 = new Point(new Coordinate(7), new Coordinate(5));
        Point point5 = new Point(new Coordinate(6), new Coordinate(9));
        Point point6 = new Point(new Coordinate(5), new Coordinate(8));

        Polygon point = new Polygon(point1);
        System.out.println(point);

        Polygon line = new Polygon(point1, point2);
        System.out.println(line);

        Polygon triangle = new Polygon(point1, point2, point3);
        System.out.println(triangle);

        Polygon fourAngles = new Polygon(point1, point2, point3, point4);
        System.out.println(fourAngles);

        Polygon sixAngles = new Polygon(point1, point2, point3, point4, point5, point6);
        System.out.println(sixAngles);

        System.out.println(fourAngles.isAreaEqualTo(sixAngles));

        Polygon triangle2 = new Triangle(point3, point4, point5);
        System.out.println(triangle2);

        Polygon parallelogram = new Parallelogram(point3, point4, point5);
        System.out.println(parallelogram);

        Polygon rectangle = new Rectangle(point3, point4, point5);
        System.out.println(rectangle);

        Polygon square = new Square(new Point(new Coordinate(0), new Coordinate(2)),
                        new Point(new Coordinate(2), new Coordinate(0)),
                        new Point(new Coordinate(0), new Coordinate(0)));
        System.out.println(square);

        System.out.println(ShapeUtils.isSquareUsingInharitation(square));
        System.out.println(ShapeUtils.isRectangleUsingInharitation(parallelogram));
        System.out.println(ShapeUtils.isRectangleUsingInharitation(rectangle));
        System.out.println(ShapeUtils.isTriangleUsingPoints(parallelogram));
        System.out.println(ShapeUtils.isTriangleUsingInharitation(parallelogram));
        System.out.println(ShapeUtils.isCircleUsingPoints(circle));
        System.out.println(ShapeUtils.isCircleUsingInharitation(circle));
    }
}
