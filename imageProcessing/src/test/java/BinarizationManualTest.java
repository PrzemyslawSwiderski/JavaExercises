import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.Optional;

public class BinarizationManualTest {

    @Test
    public void applyBinarizationManual200TresholdFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationManualFilter(200), readImage);

            binarizedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1,
                            "src\\main\\resources\\binarizationManual200tImage.jpg"));

        });
    }

    @Test
    public void applyBinarizationManual105TresholdFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationManualFilter(), readImage);

            binarizedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1,
                            "src\\main\\resources\\binarizationManual105tImage.jpg"));

        });

    }


    @Test
    public void applyBinarizationManual150TresholdFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationManualFilter(150), readImage);

            binarizedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1,
                            "src\\main\\resources\\binarizationManual150tImage.jpg"));

        });

    }
}
