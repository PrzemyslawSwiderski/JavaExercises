import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Optional;

public class MedianFilter implements ImageFilter {


  @Override
  public Optional<BufferedImage> processImage(BufferedImage input) {
    Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
    imageWorkingCopy.ifPresent(image ->
    {
      for (int h = 1; h < image.getHeight() - 1; ++h) {
        for (int w = 1; w < image.getWidth() - 1; ++w) {
          int[] values = new int[9];
          int index = 0;
          for (int currenth = h - 1; currenth < h + 2; ++currenth) {
            for (int currentw = w - 1; currentw < w + 2; ++currentw) {
              values[index] = input.getRGB(currentw, currenth);
              ++index;
            }
          }
          Arrays.sort(values);
          int mediana = values[4];
          image.setRGB(w, h, mediana);

        }
      }
    });

    return imageWorkingCopy;

  }
}
