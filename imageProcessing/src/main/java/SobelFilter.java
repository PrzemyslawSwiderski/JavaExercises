import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class SobelFilter implements ImageFilter {


  @Override
  public Optional<BufferedImage> processImage(BufferedImage input) {
    Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
    if (imageWorkingCopy.isPresent()) {
      imageWorkingCopy = new ImageProcessor()
          .applyFilter(new GrayScaleFilter(), imageWorkingCopy.get());
    }

    imageWorkingCopy.ifPresent(image ->
    {
      for (int h = 1; h < input.getHeight() - 1; ++h) {
        for (int w = 1; w < input.getWidth() - 1; ++w) {
          Color leftDown = new Color(input.getRGB(w + 1, h - 1));
          Color centerDown = new Color(input.getRGB(w + 1, h));
          Color rightDown = new Color(input.getRGB(w + 1, h + 1));

          Color leftUp = new Color(input.getRGB(w - 1, h - 1));
          Color centerUp = new Color(input.getRGB(w - 1, h));
          Color rightUp = new Color(input.getRGB(w - 1, h + 1));

          Color rightCenter = new Color(input.getRGB(w, h + 1));
          Color leftCenter = new Color(input.getRGB(w, h - 1));

          int x = leftDown.getRed();
          x = x + 2 * centerDown.getRed();
          x = x + rightDown.getRed();
          x -= leftUp.getRed();
          x = x - 2 * centerUp.getRed();
          x = x - rightUp.getRed();

          int y = rightUp.getRed();
          y = y + 2 * rightCenter.getRed();
          y = y + rightDown.getRed();

          y -= leftUp.getRed();
          y = y - 2 * leftCenter.getRed();
          y = y + leftDown.getRed();

          double x2 = Math.pow(x, 2);
          double y2 = Math.pow(y, 2);
          double x2y2 = x2 + y2;
          double rgb = Math.sqrt(x2y2);

          if (rgb > 255) {
            rgb = 255;
          }
          int finalRgb = (int) rgb;
          Color finalColor = new Color(finalRgb, finalRgb, finalRgb);
          image.setRGB(w, h, finalColor.getRGB());
        }
      }
    });

    return imageWorkingCopy;

  }
}
