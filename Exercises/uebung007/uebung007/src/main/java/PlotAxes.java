import static ch.unibas.informatik.jturtle.TurtleCommands.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


class PlotAxes {

    Point origin;
    double lengthXAxis;
    double lengthYAxis;

    /**
     * Kreiert ein Objekt der Klasse PlotAxes, welches durch den Koordinatenursprung
     * (also den Punkt unten Links) sowie die Längen der x und y-Achse definiert ist.
     */
    PlotAxes(Point origin, double lengthXAxis, double lengthYAxis) {
        this.origin = origin;
        this.lengthXAxis = lengthXAxis;
        this.lengthYAxis = lengthYAxis;
    }

    /**
     * Diese Methode zeichnet die Koordinatenachsen an der vorgegebenen Position.
     * Nutzen Sie die Methode TurtleUtils.setTurtlePosition um die Position
     * vom Turtle zu setzen.
     */
    void draw() {
        TurtleUtils.setTurtlePosition(origin);
        forward(lengthYAxis);
        TurtleUtils.setTurtlePosition(origin);
        turnRight(90);
        forward(lengthXAxis);
        TurtleUtils.setTurtlePosition(origin);

    }


    /**
     * Einfaches Testprogramm um Ihre Zeichnung zu testen
     */
    public static void main(String[] args) {

        clear();
        PlotAxes pa = new PlotAxes(new Point(-30, -50), 60, 100);
        pa.draw();

        BufferedImage img  = drawing();

        try {
            ImageIO.write(img, "png", new java.io.File("axes.png"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
