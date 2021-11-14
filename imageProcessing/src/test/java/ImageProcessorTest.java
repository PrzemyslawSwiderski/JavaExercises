import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageProcessorTest {

    @Test
    public void applyMedianaFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> {

            Optional<BufferedImage> medianaImage = imageProcessor
                    .applyFilter(new MedianFilter(), bufferedImage);

            medianaImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1, "src\\main\\resources\\medianaImage.jpg"));

        });

    }

    @Test
    public void applySobelFilter() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> {

            Optional<BufferedImage> sobelImage = imageProcessor
                    .applyFilter(new SobelFilter(), bufferedImage);

            sobelImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1, "src\\main\\resources\\sobelImage.jpg"));

        });

    }


    @Test
    public void sharpImage() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> {

            Optional<BufferedImage> sharpenImage = imageProcessor
                    .applyFilter(new SharpenFilter(), bufferedImage);

            sharpenImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1, "src\\main\\resources\\sharpenImage.jpg"));

        });

    }


    @Test
    public void grayScale() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> {

            Optional<BufferedImage> grayScaledImage = imageProcessor
                    .applyFilter(new GrayScaleFilter(), bufferedImage);

            grayScaledImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1, "src\\main\\resources\\grayScaleImage.jpg"));

        });

    }

    @Test
    public void smoothImage() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> {

            Optional<BufferedImage> smoothedImage = imageProcessor
                    .applyFilter(new SmoothingFilter(), bufferedImage);

            smoothedImage.ifPresent(bufferedImage1 -> imageProcessor
                    .writeImageToPath(bufferedImage1, "src\\main\\resources\\outSmoothImage.jpg"));

        });

    }

    @Test
    public void deepCopy() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> {
            Optional<BufferedImage> copiedImage = ImageProcessor.deepCopy(bufferedImage);

            assertTrue(copiedImage.isPresent());
            assertNotSame(copiedImage.get(), bufferedImage);
        });
    }

    @Test
    public void readImageFromPath() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        assertTrue(image.isPresent());

    }

    @Test
    public void writeImageToPath() {
        ImageProcessor imageProcessor = new ImageProcessor();

        Optional<BufferedImage> image = imageProcessor
                .readImageFromPath("src\\main\\resources\\inputImage.jpg");

        image.ifPresent(bufferedImage -> imageProcessor
                .writeImageToPath(bufferedImage, "src\\main\\resources\\outImage.jpg"));

    }

}