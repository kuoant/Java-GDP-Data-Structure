import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTests {


    @Test(timeout = 1000)
    public void testPointRetainsCoordinates() {
       Point p1 = new Point(3, 7);
       assertEquals(3, p1.getX(), 1e-8);
       assertEquals(7, p1.getY(), 1e-8);

       Point p2 = new Point(-3.1, 7.7);
       assertEquals(-3.1, p2.getX(), 1e-8);
       assertEquals(7.7, p2.getY(), 1e-8);

    }

}
