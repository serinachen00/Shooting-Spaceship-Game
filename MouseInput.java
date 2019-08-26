package TankGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private  Handler handler;
    private Camera camera;
    private Game game;
    private ImageLoader ss;

    public  MouseInput(Handler handler, Camera camera, Game game, ImageLoader ss){

        this.handler = handler;
        this.camera= camera;
        this.game = game;
        this.ss = ss;
    }

    public void mousePressed(MouseEvent e){

        int mx = (int) (e.getX() + camera.getX());
        int my = (int) (e.getY() + camera.getY());

        // bullets for players
        for (int i =0; i< handler.obj.size(); i++){
            GameObject tempObject = handler.obj.get(i);

            if(tempObject.getId() == ID.Player && game.amo1 >= 1){

                handler.addObject(new Bullet(tempObject.getX()+16,tempObject.getY()+24, ID.Bullet ,handler, mx, my, ss));
                game.amo1--;

            }

            else if(tempObject.getId() == ID.Player2 && game.amo2 >= 1){

                handler.addObject(new Bullet(tempObject.getX()+16,tempObject.getY()+24, ID.Bullet ,handler, mx, my, ss));
                game.amo2--;

            }

        }

    }




}