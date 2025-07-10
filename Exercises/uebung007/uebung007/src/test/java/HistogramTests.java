
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class HistogramTests {


    @Test(timeout = 1000)
    public void testHistogramRetainsValues() {
        double[] data = {1.1, 2.3, 2.6, 4.1, 4.2, 4.7};
        Histogram hist = new Histogram(data, 3);
        assertEquals(3, hist.getNumberOfBins());
        assertArrayEquals(data, hist.getData(), 1e-5);

    }

    @Test(timeout = 1000)
    public void testFindsCorrectMinMax() {
        double[] data = {-1.8, 1.1, 2.3, 2.6, 4.1, 4.2, 4.7};
        Histogram hist = new Histogram(data, 3);
        assertEquals(-1.8, hist.getMinValue(), 1e-5);

    }

    @Test(timeout = 1000)
    public void testFindsCorrectMax() {
        double[] data = {-1.8, 1.1, 2.3, 2.6, 4.1, 4.2, 4.7};
        Histogram hist = new Histogram(data, 3);
        assertEquals(4.7, hist.getMaxValue(), 1e-5);

    }


    @Test(timeout = 1000)
    public void testComputesCorrectBinSize() {
        double[] data = {-2, -1.8, 1.1, 2.3, 2.6, 4.1, 4.2, 4.7, 6};
        Histogram hist = new Histogram(data, 8);
        assertEquals(1.0, hist.getBinSize(), 1e-5);
        Histogram hist2 = new Histogram(data, 4);
        assertEquals(2.0, hist2.getBinSize(), 1e-5);

    }
    
    @Test(timeout = 1000)
    public void testFindsCorrectNumberOfEntriesPerBin() {
        double[] data = {-2, -1.8, 1.1, 2.3, 2.6, 4.1, 4.2, 4.7, 6};
        Histogram hist = new Histogram(data, 8);

        assertEquals(2, hist.getNumberOfEntriesInBin(0));
        assertEquals(0, hist.getNumberOfEntriesInBin(1));
        assertEquals(0, hist.getNumberOfEntriesInBin(2));
        assertEquals(1, hist.getNumberOfEntriesInBin(3));
        assertEquals(1, hist.getNumberOfEntriesInBin(7));

        Histogram hist2 = new Histogram(data, 4);

        assertEquals(1, hist2.getNumberOfEntriesInBin(1));
        assertEquals(2, hist2.getNumberOfEntriesInBin(2));

    }


    @Test(timeout = 1000)
    public void testNumberOfEntriesSumToTotalEntries() {
        double[] data = {-2, -1.8, 1.1, 2.3, 2.6, 4.1, 4.2, 4.7, 6};
        Histogram hist = new Histogram(data, 8);

        int nEntriesTotal = 0;
        for (int i = 0; i < hist.getNumberOfBins(); i++) {
            nEntriesTotal += hist.getNumberOfEntriesInBin(i);
        }

        assertEquals(data.length, nEntriesTotal);
    }
}
