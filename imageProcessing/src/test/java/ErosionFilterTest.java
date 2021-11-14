import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.Optional;

public class ErosionFilterTest {

    @Test
    public void processImageTest() throws Exception {

        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationPercentageFilter(50), readImage);

            binarizedImage.ifPresent(bufferedImage -> {
                Optional<BufferedImage> erodedImage = imageProcessor
                        .applyFilter(new ErosionFilter(), bufferedImage);

                erodedImage.ifPresent(bufferedImage1 -> imageProcessor
                        .writeImageToPath(bufferedImage1,
                                "src\\main\\resources\\erodedImage.jpg"));
            });
        });


    }

}