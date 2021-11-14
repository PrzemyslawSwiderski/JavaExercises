import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class SharpenFilter implements ImageFilter {

    @Override
    public Optional<BufferedImage> processImage(BufferedImage input) {

        Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
        imageWorkingCopy.ifPresent(image ->
        {
            for (int h = 1; h < input.getHeight() - 1; ++h) {
                for (int w = 1; w < input.getWidth() - 1; ++w) {
                    Color up = new Color(input.getRGB(w, h - 1));
                    Color left = new Color(input.getRGB(w - 1, h));
                    Color right = new Color(input.getRGB(w + 1, h));
                    Color down = new Color(input.getRGB(w, h + 1));
                    Color center = new Color(input.getRGB(w, h));

                    int red = 5 * center.getRed() - up.getRed();
                    red = red - down.getRed();
                    red = red - left.getRed() - right.getRed();
                    int green = 5 * center.getGreen() - up.getGreen();
                    green = green - down.getGreen();
                    green = green - left.getGreen() - right.getGreen();
                    int blue = 5 * center.getBlue() - up.getBlue();
                    blue = blue - down.getBlue();
                    blue = blue - left.getBlue() - right.getBlue();

                    if (red > 255) {
                        red = 255;
                    }
                    if (green > 255) {
                        green = 255;
                    }
                    if (blue > 255) {
                        blue = 255;
                    }

                    if (red < 0) {
                        red = 0;
                    }
                    if (green < 0) {
                        green = 0;
                    }
                    if (blue < 0) {
                        blue = 0;
                    }

                    image.setRGB(w, h, new Color(red, green, blue).getRGB());

                }
            }
        });

        return imageWorkingCopy;
    }
}