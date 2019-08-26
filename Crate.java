package TankGame;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Crate extends GameObject {

    private BufferedImage box_image;

    public Crate(int x, int y, ID id, ImageLoader ss ) {
        super(x, y, id, ss);

        box_image = ss.grabBullets();

    }


    public void tick() {

    }


    public void render(Graphics g) {

        g.drawImage(box_image, x,y,null);
          //g.setColor(Color.cyan);
          //g.fillRect(x,y,32,32);
    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
