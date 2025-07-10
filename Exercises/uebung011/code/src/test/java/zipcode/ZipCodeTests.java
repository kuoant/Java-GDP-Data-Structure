package zipcode;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ZipCodeTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test(timeout = 1000)
    public void testExistingNameForZipCode() {
        try {
            ZipCode code = new ZipCode(new java.io.File("./src/test/resources/Adressdaten.csv"));
            String n = code.getNameForZipCode(8355);

            assertEquals("Aadorf", n);

            n = code.getNameForZipCode(8126);
            assertEquals("Zumikon", n);
        } catch (FileNotFoundException f) {
            Assert.fail(f.getMessage());
        }
    }

    @Test(timeout = 1000)
    public void testNonExistingZipCode() {
        try {
            ZipCode code = new ZipCode(new java.io.File("./src/test/resources/Adressdaten.csv"));

            String n = code.getNameForZipCode(1111);
            exception.expect(NoSuchElementException.class); //
        } catch (FileNotFoundException f) {
            Assert.fail(f.getMessage());
        } catch (Exception e) {
        }
    }

    /**
     * 
     */
    @Test(timeout = 1000)
    public void testCantonsForName() {
        try {
            ZipCode code = new ZipCode(new java.io.File("./src/test/resources/Adressdaten.csv"));
            List<String> cantons = code.getAllCantonsForName("Abtwil");
            assertEquals(2, cantons.size());
            assertTrue(cantons.contains("SG") && cantons.contains("AG"));

            cantons = code.getAllCantonsForName("Zweisimmen");
            assertEquals(1, cantons.size());
            assertTrue(cantons.contains("BE"));

            cantons = code.getAllCantonsForName("EinOrtDasNichtExistiert");

            assertEquals(0, cantons.size());

        } catch (FileNotFoundException f) {
            Assert.fail(f.getMessage());
        }
    }

}
