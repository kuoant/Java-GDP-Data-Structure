package images;

/**
 * Repräsentiert einen 2D Punkt 
 */
public class Point {

  public final double x;
  public final double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gibt die Distanz zum Koordinatenursprung zurück
   */
  public double distOrigin() {
    return (double)Math.sqrt(x * x + y * y);
  }
}