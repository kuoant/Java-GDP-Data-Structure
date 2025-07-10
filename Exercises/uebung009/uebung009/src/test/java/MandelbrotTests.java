
import org.junit.Test;
import java.io.PrintStream;
import java.awt.Color;
import java.beans.Transient;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MandelbrotTests {


    @Test(timeout = 1000)
	public void testComputeMandelbrot() {
        Mandelbrot mb = new Mandelbrot();
        Complex c1 = new Complex(0, 0);
        MandelbrotResult res1 = mb.computeMandelbrot(c1, 10);
        assertEquals(10, res1.maxIterations);
        assertEquals(0.0, res1.number.real, 1e-8);
        assertEquals(0.0, res1.number.imag, 1e-8);
        assertEquals(10, res1.numberOfIterationsUntilEscaped);

        Complex c2 = new Complex(7, 15);
        MandelbrotResult res2 = mb.computeMandelbrot(c2, 10);
        assertEquals(10, res2.maxIterations);
        assertEquals(7.0, res2.number.real, 1e-8);
        assertEquals(15.0, res2.number.imag, 1e-8);
        assertEquals(1, res2.numberOfIterationsUntilEscaped);


        Complex c3 = new Complex(0.025, 0.17);
        MandelbrotResult res3 = mb.computeMandelbrot(c3, 10);

        assertEquals(10, res3.maxIterations);
        assertEquals(-0.0035, res3.number.real, 1e-2);
        assertEquals(0.17, res3.number.imag, 1e-2);
        assertEquals(10, res3.numberOfIterationsUntilEscaped);
    }

    @Test
    public void testPixelPosToComplexNumber() {
        Mandelbrot mb = new Mandelbrot();
        Complex c1 = mb.pixelPosToComplexNumber(2, 4, 0.5, 10, 11);

        assertEquals(11, c1.real, 1e-8);
        assertEquals(13, c1.imag, 1e-8);
    }

    @Test(timeout = 1000)
    public void testColorToGreyscale() {

        Color color1 = ColorPalette.colorToGreyscale(new Color(0, 0, 0));
        assertEquals(0, color1.getRed());
        assertEquals(0, color1.getGreen());
        assertEquals(0, color1.getBlue());

        Color color2 = ColorPalette.colorToGreyscale(new Color(100, 200, 150));
        float value = (0.2989f * 100 + 0.5870f * 200 + 0.1140f * 150);
        //assertEquals(value, color2.getRed(), 0.5);
        //assertEquals(value, color2.getGreen(), 0.5);
        //assertEquals(value, color2.getBlue(), 0.5);
    }

}
