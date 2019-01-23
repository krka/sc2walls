public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point parse(String s) {
        final String[] coordinates = s.split(",");
        return new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
    }

    public Point add(Point other) {
        return new Point(x + other.x, y + other.y);
    }

    public Point minus(Point other) {
        return new Point(x - other.x, y - other.y);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return x * x + y * y;
    }

    public double dotProd(Point other) {
        return x * other.x + y * other.y;
    }

    public double crossProd(Point other) {
        return x * other.y - y * other.x;
    }

    public Point multiply(double t) {
        return new Point(t * x , t * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
