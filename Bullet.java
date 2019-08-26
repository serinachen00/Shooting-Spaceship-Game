package TankGame;

import java.awt.*;

public class Bullet extends GameObject {

    private Handler handler;

    public Bullet(int x, int y, ID id, Handler handler, int mx, int my, ImageLoader ss){

        super(x,y,id, ss);
        this.handler= handler;

        velX = (mx-x) /10;
        velY = (my-y) /10;

    }

    public void tick(){

        x+= velX;
        y+= velY;

        for (int i=0; i< handler.obj.size() ; i++){

            GameObject tempObject = handler.obj.get(i);

            if(tempObject.getId() == ID.Block){
                if (getBounds().intersects((tempObject.getBounds()))){

                    handler.removeObject(this);
                }

            }
        }
    }


    public void render(Graphics g){

        g.setColor(Color.GREEN);
        g.fillOval(x,y,8,8);

    }

    public  Rectangle getBounds(){

        return  new Rectangle(x,y,8,8);
    }
}
