import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonTest {
    @Test
    public void testLineDistance() {
        double actual = Polygon.lineDistance(
                new Point(10, 100),
                new Point(11, 10),
                new Point(11, 200));
        assertEquals(1, actual, 0.00001);
    }
}