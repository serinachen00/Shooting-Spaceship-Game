package TankGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HealthLife extends GameObject{

    private Handler handler;

    //to get Random movement from the Enemies
    int choose =0;
    int hp = 100;

    private BufferedImage heart;
    Game game;

    public HealthLife(int x, int y, ID id, Handler handler, Game game, ImageLoader ss){

        super(x,y,id,ss);
        this.handler = handler;
        this.game = game;

        heart = ss.grabHeart();

    }
  
    public void tick() {


        // When Player shoots
        for (int i=0; i< handler.obj.size(); i++){

            GameObject tempObject = handler.obj.get(i);


            if(tempObject.getId() == ID.Bullet){

                if(getBounds().intersects(tempObject.getBounds())){

                    hp -= 100;

                    if (game.hp1 <100) {

                        game.hp1 += 20;
                    }

                    handler.removeObject(tempObject);
                }

            }
        }

        if(hp <= 0)
            handler.removeObject(this);



    }


    public void render(Graphics g) {

        g.drawImage(heart,x,y,null);
        // g.setColor(Color.yellow);
        //g.fillRect(x,y, 32,32);


    }


    public Rectangle getBounds() {

        return new Rectangle(x,y,32,32);
    }



}