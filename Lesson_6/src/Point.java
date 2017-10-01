public class Point {

    private OX x;
    private OY y;

    public Point() {}

    public Point(OX x, OY y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        double deltaX = x.getCoordinate() - point.x.getCoordinate();
        double deltaY = y.getCoordinate() - point.y.getCoordinate();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public OX getX() {
        return x;
    }

    public void setX(OX x) {
        this.x = x;
    }

    public OY getY() {
        return y;
    }

    public void setY(OY y) {
        this.y = y;
    }
}
