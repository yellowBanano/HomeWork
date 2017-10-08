public class Point {

    private Coordinate x;
    private Coordinate y;

    public Point(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        double deltaX = x.getCoordinate() - point.x.getCoordinate();
        double deltaY = y.getCoordinate() - point.y.getCoordinate();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public Coordinate getX() {
        return x;
    }

    public Coordinate getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Точка[" + getX().getCoordinate() + ", " + getY().getCoordinate() + "]";
    }
}
