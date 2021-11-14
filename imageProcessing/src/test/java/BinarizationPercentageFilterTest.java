import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.Optional;

public class BinarizationPercentageFilterTest {

    @Test
    public void applyBinarizationPercentage50TresholdFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationPercentageFilter(50), readImage);

            binarizedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1,
                            "src\\main\\resources\\binarizationPercentage50Image.jpg"));

        });

    }

    @Test
    public void applyBinarizationPercentage80TresholdFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationPercentageFilter(80), readImage);

            binarizedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1,
                            "src\\main\\resources\\binarizationPercentage80Image.jpg"));

        });

    }

    @Test
    public void applyBinarizationPercentage35TresholdFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(readImage -> {

            Optional<BufferedImage> binarizedImage = imageProcessor
                    .applyFilter(new BinarizationPercentageFilter(35), readImage);

            binarizedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1,
                            "src\\main\\resources\\binarizationPercentage35Image.jpg"));

        });

    }

}