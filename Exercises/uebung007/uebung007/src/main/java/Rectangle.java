import static ch.unibas.informatik.jturtle.TurtleCommands.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class Rectangle {

    Point lowerLeftCorner;
    double width;
    double height;

    /**
     * Kreiert ein neues Rectangle Objekt, welches ein Rechteck durch den
     * unteren Linken Punkt, sowie dessen Breite und Höhe definiert.
     */
    Rectangle(Point lowerLeftCorner, double width, double height) {
        this.lowerLeftCorner = lowerLeftCorner;
        this.width = width;
        this.height = height;
    }

    /*
     * Zeichnet das Rechteck mit gegebener Breite und Höhe an der angegebenen Position
     * Nutzen Sie die Methode TurtleUtils.setTurtlePosition um die Position vom Turtle
     * zu setzen.
     */
    void draw() {
        TurtleUtils.setTurtlePosition(lowerLeftCorner);
        forward(height);
        turnRight(90);
        forward(width);
        turnRight(90);
        forward(height);
        turnRight(90);
        forward(width);
        turnRight(90);
    }

    /**
     * Einfaches Testprogramm um Ihre Zeichnung zu testen
     */
    public static void main(String[] args) {

        clear();
        Rectangle rect = new Rectangle(new Point(-30, -50), 60, 100);
        rect.draw();

        BufferedImage img  = drawing();

        try {
            ImageIO.write(img, "png", new java.io.File("rectangle.png"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
