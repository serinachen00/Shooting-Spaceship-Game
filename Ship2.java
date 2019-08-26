package TankGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ship2 extends GameObject {

    Handler handler;
    Game game;
    private BufferedImage ship_image;

    public Ship2(int x, int y, ID id, Handler handler, Game game, ImageLoader ss) {

        super(x, y, id, ss);
        this.handler = handler;
        this.game = game;

       // ship_image= ss.grabShip2();

    }


    public void tick() {
        x+= velX;
        y+= velY;

        collision();

        //movement for First Ship
        if(handler.isUp()) velY = -5;
        else if (!handler.isDown()) velY = 0;

        if(handler.isDown()) velY = 5;
        else if (!handler.isUp()) velY =0;

        if(handler.isRight()) velX=5;
        else if (!handler.isLeft()) velX=0;

        if(handler.isLeft()) velX = -5;
        else if (!handler.isRight()) velX=0;

    }

    private void collision(){

        for(int i=0; i< handler.obj.size(); i++){

            GameObject tempObject = handler.obj.get(i);

            if(tempObject.getId() == ID.Block){

                if(getBounds().intersects(tempObject.getBounds())){

                    x+= velX* (-1);
                    y+= velY * (-1);
                }
            }

            if(tempObject.getId() == ID.Player){

                if(getBounds().intersects(tempObject.getBounds())){

                    x+= velX* (-3);
                    y+= velY * (-3);
                }
            }

            if(tempObject.getId() == ID.Crate){

                if(getBounds().intersects(tempObject.getBounds())){

                    game.amo2 += 10;
                    handler.removeObject(tempObject);

                }
            }

            if(tempObject.getId() == ID.Enemy){

                if(getBounds().intersects(tempObject.getBounds())){

                    game.hp2--;

                }
            }



        }
    }

    public void render(Graphics g) {

        // g.setColor(Color.blue);
        // g.fillRect(x,y,32,48);

        g.drawImage(ship_image, x,y,null);
    }


    public Rectangle getBounds() {

        return new Rectangle(x,y,32,48);
    }
}
