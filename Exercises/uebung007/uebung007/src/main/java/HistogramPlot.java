import static ch.unibas.informatik.jturtle.TurtleCommands.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class HistogramPlot {

    Histogram histogram = null;

    static final double PLOT_WIDTH = 100;
    static final double PLOT_HEIGHT = 100;
    static final Point LOWER_LEFT_CORNER_POINT = new Point(-50, -50);


    /**
     * Kreiert ein neues HistogramPlot Objekt, welches ein Histogram
     * mit numberOfBin Klassen der gegebenen Daten repräsentiert,
     */
    HistogramPlot(double[] data, int numberOfBins) {
        this.histogram = new Histogram(data, numberOfBins);
    }


    /**
     * Diese Methode nutzt ein gegebenes Turtle Objekt um das Histogram zu zeichnen.
     * Dabei sollen die Klassen PlotAxes und Rectangle benutzt werden um die einzelnen
     * Elemente zu zeichnen. Die Länge und Breite der Achsen ist dabei durch die
     * vordefinierten Konstanten PLOT_WIDTH und PLOT_HEIGHT festgelegt.
     * Die Breite jedes Balkens soll entsprechend der Anzahl Klassen im Histogram
     * festgelegt werden.
     * Die Höhe des Balkens soll proportional zu den Anzahl Einträgen in jeder Histogram
     * Klasse sein. Dabei soll der höchste Balken genau der Höhe des Plots (PLOT_HEIGHT)
     * entsprechen.
     *
     */
    void draw() {

        PlotAxes plotaxes = new PlotAxes(LOWER_LEFT_CORNER_POINT, PLOT_WIDTH, PLOT_HEIGHT);
        plotaxes.draw();

        double maxBinNumber = 0;
        for (int i = 0; i < histogram.data.length; i++) {
            if (maxBinNumber < histogram.getNumberOfEntriesInBin(i)) {
                maxBinNumber = histogram.getNumberOfEntriesInBin(i);
            }
        }
        double factor = PLOT_HEIGHT / maxBinNumber;
        Point newPoint = new Point(LOWER_LEFT_CORNER_POINT.x, LOWER_LEFT_CORNER_POINT.y);

        for (int i = 0; i <= this.histogram.numberOfBins ;i++) {
            Rectangle rectangle = new Rectangle(newPoint, (PLOT_WIDTH / this.histogram.numberOfBins), (histogram.getNumberOfEntriesInBin(i) * factor));
            rectangle.draw();
            newPoint.x += (PLOT_WIDTH / this.histogram.numberOfBins);
        }
        

    }

    /**
     * Kreiert und speichert ein Bild des Histogramplots unter angegebenem Dateinamen.
     */
    void saveToImage(String filename) {

        this.draw();
        BufferedImage img  = drawing();

        try {
            ImageIO.write(img, "png", new java.io.File(filename));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        home();
        clear();

        // Einfacher Testcode. Gut zum Debuggen
        double[] simpleData = {1, 2, 2.1, 2, 4, 2.3, 4.1, 4.2, 3, 4, 4.1, 7, 7.1};
        HistogramPlot simplePlot = new HistogramPlot(simpleData, 7);
        simplePlot.saveToImage("./histogram-simple.png");

        home();
        clear();

        // Etwas komplexerer Testcase. Hier wird ein Zufallsgenerator
        // genutzt um 1000 Normalverteilte Zufallszahlen zu generieren.
        java.util.Random rng = new java.util.Random(42);
        double[] normalData = new double[1000];
        for (int i = 0; i < normalData.length; i++) {
            normalData[i] = rng.nextGaussian();
        }
        HistogramPlot normalPlot = new HistogramPlot(normalData, 30);
        normalPlot.saveToImage("./histogram-normal.png");
    }
}
