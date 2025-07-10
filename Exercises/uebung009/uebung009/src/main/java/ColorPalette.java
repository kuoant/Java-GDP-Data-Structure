import java.awt.*;

/**
 * Hilfsklasse, welche Methoden zur Verfügung stellt, um Resultate
 * der Mandelbrot-berechnungen eine Farbe zuzuordnen.
 */
class ColorPalette {

    static Color getColor(MandelbrotResult result) {

        float brightness;
        if (result.hasEscaped())  {
            brightness = 1.0f;
        } else {
            brightness = 0.0f;
        }

        double nsmooth = (result.numberOfIterationsUntilEscaped + 1)
            - (Math.log(Math.log(result.number.abs())) / Math.log(2.0));


        return new Color(
            Color.HSBtoRGB((float) nsmooth / (float) (result.maxIterations),
            1.0f,
            brightness
            )
        );
    }

    /**
     * Nimmt eine Farbe und wandelt die gegebenen Farbe in einen Grauwert um.
     */
    static Color colorToGreyscale(Color color) {
        return color;
    }
}
