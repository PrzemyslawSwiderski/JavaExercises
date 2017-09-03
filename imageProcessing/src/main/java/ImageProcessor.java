import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImageProcessor {


  public Optional<BufferedImage> readImageFromPath(String path) {
    BufferedImage image;
    try {
      image = ImageIO.read(new File(path));
      return Optional.of(image);
    } catch (IOException ioException) {
      log.info("IOException occured: ", ioException);
      return Optional.empty();
    }
  }

  public void writeImageToPath(BufferedImage bufferedImage, String path) {
    try {
      ImageIO.write(bufferedImage, "jpg", new File(path));
    } catch (IOException ioException) {
      log.info("IOException occured: ", ioException);
    }
  }

  public static Optional<BufferedImage> deepCopy(BufferedImage bufferedImage) {
    log.info("Creating deep copy of image");
    ColorModel cm = bufferedImage.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = bufferedImage.copyData(null);
    return Optional.of(new BufferedImage(cm, raster, isAlphaPremultiplied, null));
  }

  public Optional<BufferedImage> applyFilter(ImageFilter filter, BufferedImage inputImage) {
    log.info("Filtering image with filter: " + filter.getClass());
    return filter.processImage(inputImage);

  }

}
