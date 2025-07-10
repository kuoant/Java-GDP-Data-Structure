import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ComplexTests {


    @Test(timeout = 1000)
	public void testAddAndMultiplyInplace() {
        testAddInplace();
        testMultiplyInplace();
        testMultiplyInplaceSameObject();
    }

    @Test
    public void testAddInplace() {
        Complex c1 = new Complex(5, 3);
        Complex c2 = new Complex(3, 7.0);
        c1.addInplace(c2);
        assertEquals(8, c1.real, 1e-10);
        assertEquals(10.0, c1.imag, 1e-10);
    }

    @Test
    public void testMultiplyInplace() {
        Complex c1 = new Complex(5, 3);
        Complex c2 = new Complex(3, 7.0);
        c1.multiplyInplace(c2);
        assertEquals(-6.0, c1.real, 1e-10);
        assertEquals(44.0, c1.imag, 1e-10);
    }

    @Test
    public void testMultiplyInplaceSameObject() {
        Complex c = new Complex(4, -3.0);
        c.multiplyInplace(c);
        assertEquals(7, c.real, 1e-10);
        assertEquals(-24, c.imag, 1e-10);
    }


    @Test(timeout = 1000)
	public void testAddMultiplyAndAbs() {
        testAdd();
        testMultiply();
        testAbs();
    }

    @Test
    public void testAdd() {
        Complex c1 = new Complex(5, 3);
        Complex c2 = new Complex(3, 7.0);
        Complex c3 = c1.add(c2);
        assertEquals(8, c3.real, 1e-10);
        assertEquals(10.0, c3.imag, 1e-10);
    }

    @Test
    public void testMultiply() {
        Complex c1 = new Complex(5, 3);
        Complex c2 = new Complex(3, 7.0);
        Complex c3 = c1.multiply(c2);

        assertEquals(-6.0, c3.real, 1e-10);
        assertEquals(44.0, c3.imag, 1e-10);
    }

    @Test
    public void testAbs() {
        Complex c1 = new Complex(3, 4);
        assertEquals(5.0, c1.abs(), 1e-10);
    }
}
