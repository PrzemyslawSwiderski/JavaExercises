import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class ErosionFilter implements ImageFilter {

  @Override
  public Optional<BufferedImage> processImage(BufferedImage input) {

    Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);

    imageWorkingCopy.ifPresent(image ->
    {
      for (int h = 1; h < input.getHeight() - 1; ++h) {
        for (int w = 1; w < input.getWidth() - 1; ++w) {
          for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
              if (i != 0 && j != 0) {
                Color currentColor = new Color(input.getRGB(w + i, h + j));
                if (currentColor.getRGB() == Color.WHITE.getRGB()) {
                  image.setRGB(w, h, Color.WHITE.getRGB());
                  break;
                }
              }
            }
          }
        }
      }
    });
    return imageWorkingCopy;

  }
}
