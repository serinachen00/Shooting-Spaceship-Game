package TankGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    static BufferedImage ship;
    static BufferedImage image;
    private int width, height;


    public ImageLoader(BufferedImage image){

        this.image = image;
    }

    public BufferedImage grabShip (){

        try {
            ship = ImageIO.read(new File("resources/ship1.png"));

            width = ship.getWidth();
            height= ship.getHeight();

        }

        catch (IOException e) {

            e.printStackTrace();
        }

        return ship.getSubimage(0, 0, width, height);

    }


    public BufferedImage grabTrees (){

        try {
            ship = ImageIO.read(new File("resources/Trees.png"));

            width = ship.getWidth();
            height= ship.getHeight();

        }

        catch (IOException e) {

            e.printStackTrace();
        }

        return ship.getSubimage(0, 0, width, height);

    }

    public BufferedImage grabBullets(){

        try {
            ship = ImageIO.read(new File("resources/box.png"));

            width = ship.getWidth();
            height= ship.getHeight();

        }

        catch (IOException e) {

            e.printStackTrace();
        }

        return ship.getSubimage(0, 0, width, height);

    }


    public BufferedImage grabGround (){

        try {
            ship = ImageIO.read(new File("resources/ground.png"));

            width = ship.getWidth();
            height= ship.getHeight();

        }

        catch (IOException e) {

            e.printStackTrace();
        }

        return ship.getSubimage(0, 0, width, height);

    }

    public BufferedImage grabPiglet (){

        try {
            ship = ImageIO.read(new File("resources/Piglet.png"));

            width = ship.getWidth();
            height= ship.getHeight();

        }

        catch (IOException e) {

            e.printStackTrace();
        }

        return ship.getSubimage(0, 0, width, height);

    }

    public BufferedImage grabHeart (){

        try {
            ship = ImageIO.read(new File("resources/Heart.png"));

            width = ship.getWidth();
            height= ship.getHeight();

        }

        catch (IOException e) {

            e.printStackTrace();
        }

        return ship.getSubimage(0, 0, width, height);

    }


}