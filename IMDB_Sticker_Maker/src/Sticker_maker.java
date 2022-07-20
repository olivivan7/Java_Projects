import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sticker_maker {

    public void create(InputStream inputFig, String archiveName) throws Exception {

        // InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
        //InputStream inputFig = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        
        BufferedImage original_image = ImageIO.read(inputFig);

        // creates a new image in memory with transparency and new size
        int width = original_image.getWidth();
        int height = original_image.getHeight();
        //int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);

        // copy original image to new image (in memory)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(original_image, 0, 0, null);

        // font configuration
        /*var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);*/

        // writing a sentence on the new image
        //graphics.drawString("Sticker", 100, newHeight - 100);

        // write the new image to a file
        ImageIO.write(newImage, "png", new File(archiveName));

    }

}