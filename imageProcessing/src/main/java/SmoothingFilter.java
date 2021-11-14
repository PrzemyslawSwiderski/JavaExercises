import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class SmoothingFilter implements ImageFilter {

    @Override
    public Optional<BufferedImage> processImage(BufferedImage input) {
        Optional<BufferedImage> imageWorkingCopy = ImageProcessor.deepCopy(input);
        imageWorkingCopy.ifPresent(image -> {
            for (int h = 1; h < input.getHeight() - 1; ++h) {
                for (int w = 1; w < input.getWidth() - 1; ++w) {
                    double red = 0, green = 0, blue = 0;
                    for (int currenth = h - 1; currenth < h + 2; ++currenth) {
                        for (int currentw = w - 1; currentw < w + 2; ++currentw) {
                            Color color = new Color(input.getRGB(currentw, currenth));
                            red += color.getRed();
                            green += color.getGreen();
                            blue += color.getBlue();
                        }
                    }
                    red = red / 9;
                    green = green / 9;
                    blue = blue / 9;
                    int redFinal = (int) red;
                    int greenFinal = (int) green;
                    int blueFinal = (int) blue;
                    Color finalColor = new Color(redFinal, greenFinal, blueFinal);
                    image.setRGB(w, h, finalColor.getRGB());
                }
            }
        });
        return imageWorkingCopy;
    }

}
