public class ShapeUtils {

    public static boolean isRectangleUsingInharitation(Polygon polygon) {
        return polygon instanceof Rectangle;
    }

    public static boolean isTriangleUsingPoints(Polygon polygon) {
        return polygon.getPoints().length == 3;
    }

    public static boolean isTriangleUsingInharitation(Polygon polygon) {
        return polygon instanceof Triangle;
    }

    public static boolean isSquareUsingInharitation(Polygon polygon) {
        return polygon instanceof Square;
    }

    public static boolean isCircleUsingPoints(Ellipse ellipse) {
        return ellipse.getSemiMajorAxis() == ellipse.getSemiMinorAxis();
    }

    public static boolean isCircleUsingInharitation(Ellipse ellipse) {
        return ellipse instanceof Circle;
    }
}
