import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;


public class BinarizationManualFilter implements ImageFilter {

  public BinarizationManualFilter() {

  }


  public BinarizationManualFilter(int threshold) {
    this.threshold = threshold;
  }

  @Setter
  @Getter
  private int threshold = 105;

  @Override
  public Optional<BufferedImage> processImage(BufferedImage input) {
    Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
    imageWorkingCopy.ifPresent(image ->
    {
      for (int h = 0; h < input.getHeight(); ++h) {
        for (int w = 0; w < input.getWidth(); ++w) {
          Color c = new Color(input.getRGB(w, h));
          int red = c.getRed();
          int blue = c.getBlue();
          int green = c.getGreen();
          double result = ((double) (red + green + blue)) / 3;
          green = (int) result;
          if (green < threshold) {
            image.setRGB(w, h, Color.BLACK.getRGB());
          } else {
            image.setRGB(w, h, Color.WHITE.getRGB());
          }
        }
      }
    });

    return imageWorkingCopy;
  }
}
