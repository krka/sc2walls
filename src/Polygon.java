import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private final List<Point> points;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public static Polygon parse(String contour) {
        String[] split = contour.split(":");
        List<Point> points = parsePoints(split[0]);
        return new Polygon(points);
    }

    private static List<Point> parsePoints(String s) {
        ArrayList<Point> result = new ArrayList<>();
        for (String point : s.split(";")) {
            result.add(Point.parse(point));
        }
        return result;
    }

    public Polygon add(Point p) {
        ArrayList<Point> newPoints = new ArrayList<>();
        for (Point point : points) {
            newPoints.add(point.add(p));
        }
        return new Polygon(newPoints);
    }

    public List<Point> getPoints() {
        return points;
    }

    public double distance(Point other) {
        double min = Double.MAX_VALUE;
        Point prev = points.get(points.size() - 1);
        for (Point point : points) {
            double newMin = lineDistance(other, prev, point);
            min = Math.min(min, newMin);
            prev = point;
        }
        return min;
    }

    public static double lineDistance(Point point, Point lineStart, Point lineEnd) {
        Point line = lineEnd.minus(lineStart);
        double lengthSquared = line.lengthSquared();

        final Point pointToLineStart = point.minus(lineStart);
        if (lengthSquared == 0.0) {
            return pointToLineStart.length();
        }

        final double t = Math.max(0, Math.min(1, pointToLineStart.dotProd(line) / lengthSquared));
        final Point projection = lineStart.add(line.multiply(t));
        return projection.minus(point).length();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
