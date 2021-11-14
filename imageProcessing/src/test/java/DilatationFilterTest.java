import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.Optional;

public class DilatationFilterTest {

    @Test
    public void processImageTest() {

        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationPercentageFilter(50), readImage);
            if (binarizedImage.isPresent()) {
                Optional<BufferedImage> dilatatedImage = imageProcessor
                        .applyFilter(new DilatationFilter(), binarizedImage.get());
                dilatatedImage.ifPresent(bufferedImage1 -> imageProcessor
                        .writeImageToPath(bufferedImage1,
                                "src\\main\\resources\\dilatatedImage.jpg"));
            }

        });


    }

}