package TankGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject{

    private Handler handler;

    //to get Random movement from the Enemies
    Random r = new Random();
    int choose =0;
    int hp = 100;

    private BufferedImage piglet_image;

    public Enemy (int x, int y, ID id, Handler handler, ImageLoader ss){

        super(x,y,id, ss);
        this.handler = handler;

       piglet_image = ss.grabPiglet();

    }

    public void tick() {

        x+= velX;
        y+= velY;

        // To make Enemy move around randomly//
        choose = r.nextInt(10);

        for (int i=0; i< handler.obj.size(); i++){

            GameObject tempObject = handler.obj.get(i);

            if(tempObject.getId() == ID.Block){
                if (getBoundsBig().intersects(tempObject.getBounds())){

                    x += (velX*5) * -3;
                    y += (velY*5) * -3;

                    velX = (velX*1) * -3;
                    velY = (velY*1) * -3;

                }

                else if(choose == 0){

                    velX = (r.nextInt((2 - -2) + -2));
                    velY = (r.nextInt((1 - -1) + -1));

                }
            }

            if(tempObject.getId() == ID.Bullet){

                if(getBounds().intersects(tempObject.getBounds())){

                    hp -= 50;
                    handler.removeObject(tempObject);
                }

            }
        }

        if(hp <= 0)
            handler.removeObject(this);



    }


    public void render(Graphics g) {

        g.drawImage(piglet_image,x,y,null);
         // g.setColor(Color.yellow);
          //g.fillRect(x,y, 32,32);


    }


    public Rectangle getBounds() {

        return new Rectangle(x,y,32,32);
    }

    public Rectangle getBoundsBig() {

        return new Rectangle(x-16,y-16,64,64);
    }


}