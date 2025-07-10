import static ch.unibas.informatik.jturtle.TurtleCommands.*;


class TurtleUtils {

    /**
     * Setzt die Position vom Turtle an die durch den Punkt gegebene Position.
     */
    static void setTurtlePosition(Point point) {
        penUp();
        home();
        forward(point.y);
        turnRight(90);
        forward(point.x);
        turnLeft(90);

        penDown();
    }
}
