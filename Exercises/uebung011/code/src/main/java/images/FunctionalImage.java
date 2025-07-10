package images;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class FunctionalImage {

  /**
   * Resolution of the picture
   */
  private static final int IMAGE_WIDTH = 512;
  private static final int IMAGE_HEIGHT = 512;

  /**
   * size of the picture (Domain of the function)
   */
  private static final double WIDTH = 2;
  private static final double HEIGHT = 2;

  /**
   * function, which returns either True or False for each point, and
   * thus determines whether the image at the point is black or white.
   */
  public Function<Point, Boolean> imageFunction;

  /**
  * Creates a new image, with given predicate
   */
  public FunctionalImage(Function<Point, Boolean> imageFunction) {
    this.imageFunction = imageFunction;
  }

  /**
   * Evaluates the image at a specific point.
   */
  public boolean apply(Point p) {
    return this.imageFunction.apply(p);
  }

  /**
   * Renders the image represented by this object and writes it to the
   * specified file.
   */
  void render(File file) throws IOException {
    BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, TYPE_INT_RGB);
    for (int i = 0; i < IMAGE_WIDTH; i++) {
      for (int j = 0; j < IMAGE_HEIGHT; j++) {
        boolean isBlack = this.apply(new Point(i * WIDTH / (double) IMAGE_WIDTH - WIDTH / 2.0,
            j * HEIGHT / (double) IMAGE_HEIGHT - HEIGHT / 2.0));
        if (isBlack) {
          image.setRGB(i, j, Color.BLACK.getRGB());
        } else {
          image.setRGB(i, j, Color.WHITE.getRGB());
        }
      }
    }
    ImageIO.write(image, "png", file);

  }

  /**
   * Creates a new image that shows a vertical black stripe in 
   * the center of the image (see exercise sheet).
   */
  public static FunctionalImage createStrip() {

    Function<Point, Boolean> imageFunction = (Point p) -> {
      if (Math.abs(p.x) < 0.5) {
        return true;
      } else {
        return false;
      }
    };
    return new FunctionalImage(imageFunction);
  }

  /**
  * Creates a new image by executing one after the other (composition).
   * the function representing the image and the passed function. */

  public FunctionalImage compose(Function<Point, Point> before) {

    imageFunction = (Point p) -> {
      Point a = before.apply(p);
      if (Math.abs(a.x) < 0.5) {
        return true;
      } else {
        return false;
      }
    };

    return new FunctionalImage(imageFunction);
  }

  /**
  * Creates a function which rotates each point by the angle theta.
  */
  public static Function<Point, Point> rotate(double theta) {
    
    Function<Point, Point> rotation = (Point p) -> {
      double a = p.x * Math.cos(theta) - p.y * Math.sin(theta);
      double b = p.y * Math.cos(theta) - p.x * Math.sin(theta);;
      return new Point(a,b);
    };
    return rotation;
  }

  /**
  * Generates a "swirl" transformation. formula: p → rotate(dist(p) · 2 · π/r)(p)  
   */
  public static Function<Point, Point> swirl(double r) {
    
    Function<Point, Point> swirling = (Point p) -> {
      Function<Point, Point> function = rotate( p.distOrigin() * 2 * Math.PI / r);
      p = function.apply(p);
      return p;
    };
    return swirling;
  }

  public static void main(String[] args) {

    try {

      createStrip()
           .compose(rotate(Math.PI / 4))
           .compose(swirl(1))
          .render(new File("image.png"));

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }
}
