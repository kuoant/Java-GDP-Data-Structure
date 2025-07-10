import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class BMITests {

    @Test
    public void testAufgabe2BerechnungRichtig() {
        String output = runBMIAndCaptureOutput("188", "88");
        String[] lines = output.split("\\r?\\n");
        assertTrue(lines.length > 0);
        String[] tokens = lines[0].split(":");
        assertTrue(tokens.length > 1);
        String res = tokens[1].trim();
        assertTrue(Math.abs(Double.parseDouble(res) - 24.9) < 0.1);
    }

    @Test
    public void testAufgabe2AusgabeRichtig() {

        String output = "";
        double answer = 0;

        output = runBMIAndCaptureOutput("188", "88");
        answer = Double.parseDouble(output.split(":")[1]);
        assertEquals(24.89, answer, 0.05);

        output = runBMIAndCaptureOutput("188", "60");
        answer = Double.parseDouble(output.split(":")[1]);
        assertEquals(16.97, answer, 0.05);

        output = runBMIAndCaptureOutput("120", "90");
        answer = Double.parseDouble(output.split(":")[1]);
        assertEquals(62.5, answer, 0.05);


    }


    private String runBMIAndCaptureOutput(
        String argument1,
        String argument2
    ) {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));

        String[] args = {argument1, argument2};

        BMI.main(args);
        String output = outContent.toString();

        System.setOut(originalOut);
        return output;

    }
}
