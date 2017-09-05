import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

public class BinarizationPercentageFilter implements ImageFilter {


  public BinarizationPercentageFilter() {

  }

  public BinarizationPercentageFilter(int percentage) {
    this.percentage = percentage;
  }

  @Setter
  @Getter
  private int percentage = 20;

  @Override
  public Optional<BufferedImage> processImage(BufferedImage input) {
    Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
    int[] pixelTable = new int[256];

    imageWorkingCopy.ifPresent(image ->
    {
      for (int h = 0; h < input.getHeight(); ++h) {
        for (int w = 0; w < input.getWidth(); ++w) {
          Color c = new Color(input.getRGB(w, h));
          int red = c.getRed();
          int blue = c.getBlue();
          int green = c.getGreen();
          double newColor = ((double) (red + green + blue)) / 3;
          pixelTable[(int) newColor]++;
          int finalValue = (int) newColor;
          Color finalColor = new Color(finalValue, finalValue, finalValue);
          image.setRGB(w, h, finalColor.getRGB());
        }
      }

      int all = 0;
      for (int i = 0; i < 256; ++i) {
        all = all + pixelTable[i];
      }
      int[] LUT = new int[256];
      double limes = 0;
      limes = ((double) percentage / 100) * ((double) all);
      int nextSum = 0;
      for (int i = 0; i < 256; ++i) {
        nextSum = nextSum + pixelTable[i];
        LUT[i] = nextSum < limes ? 0 : 1;
      }

      for (int h = 0; h < input.getHeight(); ++h) {
        for (int w = 0; w < input.getWidth(); ++w) {

          Color c = new Color(image.getRGB(w, h));
          int red = c.getRed();
          if (LUT[red] == 0) {
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
