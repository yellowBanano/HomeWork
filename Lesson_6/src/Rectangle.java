public class Rectangle {

    private Point upperLeftPoint;
    private Point lowerRightPoint;

    public Rectangle(Point point1, Point point2) {
        upperLeftPoint = new Point();
        lowerRightPoint = new Point();
        if (point1.getX().getCoordinate() <= point2.getX().getCoordinate()) {
            upperLeftPoint.setX(point1.getX());
            lowerRightPoint.setX(point2.getX());
        } else {
            upperLeftPoint.setX(point2.getX());
            lowerRightPoint.setX(point1.getX());
        }
        if (point1.getY().getCoordinate() >= point2.getY().getCoordinate()) {
            upperLeftPoint.setY(point1.getY());
            lowerRightPoint.setY(point2.getY());
        } else {
            upperLeftPoint.setY(point2.getY());
            lowerRightPoint.setY(point1.getY());
        }
    }

    public double space() {
        Point thirdPoint = new Point(upperLeftPoint.getX(), lowerRightPoint.getY());
        return thirdPoint.distance(upperLeftPoint) * thirdPoint.distance(lowerRightPoint);
    }

    public double lengthOfDiagonal() {
        return upperLeftPoint.distance(lowerRightPoint);
    }
}
