import java.awt.image.BufferedImage;
import java.util.Optional;

public interface ImageFilter {

    Optional<BufferedImage> processImage(BufferedImage input);

}
