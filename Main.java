import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(128, 128, 1);
        Graphics graphics = bufferedImage.getGraphics();

        for (int i = 128; i >= 0; i--) {
            for (int o = 0; o < 128; o++) {
                int i1 = (i * i + o * o) & 0x0000ff;
                graphics.setColor(new Color(i1 + (i1 << 8)));
                graphics.drawRect(i, o, 1, 1);
            }
        }

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 128/3));
        graphics.drawString("Anmol", 2, 64);

        graphics.setColor(Color.RED);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 128/3));
        graphics.drawString("1032", 16, 96);


        try {
            ImageIO.write(bufferedImage, "png", new File("abc.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}