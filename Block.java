package TankGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends GameObject {


    private BufferedImage box_image;
    Handler handler;

    public Block(int x, int y, ID id, Handler handler, ImageLoader ss) {


        super(x, y, id, ss);
        this.handler= handler;
        box_image = ss.grabTrees();
    }


    public void tick() {

    }


    public void render(Graphics g) {

        //g.setColor(Color.black);
        //g.fillRect(x,y,32,32);
        g.drawImage(box_image, x,y,null);
    }


    public Rectangle getBounds() {

        return new Rectangle(x,y,32,32);
    }
}
