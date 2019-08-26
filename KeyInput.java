package TankGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {

        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();
        int key2 = e.getKeyCode();

        for (int i =0; i< handler.obj.size(); i++) {

            GameObject tempObject = handler.obj.get(i);

            if (tempObject.getId() == ID.Player) {

                if (key == KeyEvent.VK_W) handler.setW(true);
                if (key == KeyEvent.VK_S) handler.setS(true);
                if (key == KeyEvent.VK_A) handler.setA(true);
                if (key == KeyEvent.VK_D) handler.setD(true);

            }

            if(tempObject.getId() == ID.Player2){

                if(key2 == KeyEvent.VK_UP) handler.setUp(true);
                if(key2 == KeyEvent.VK_DOWN) handler.setDown(true);
                if(key2 == KeyEvent.VK_LEFT) handler.setLeft(true);
                if(key2 == KeyEvent.VK_RIGHT) handler.setRight(true);


            }

        }

        }

    public void keyReleased (KeyEvent e){
        int key = e.getKeyCode();
        int key2 = e.getKeyCode();

        for (int i =0; i< handler.obj.size(); i++) {

            GameObject tempObject = handler.obj.get(i);

            if (tempObject.getId() == ID.Player) {

                if (key == KeyEvent.VK_W) handler.setW(false);
                if (key == KeyEvent.VK_S) handler.setS(false);
                if (key == KeyEvent.VK_A) handler.setA(false);
                if (key == KeyEvent.VK_D) handler.setD(false);


            }

            if(tempObject.getId() == ID.Player2){

                if(key2 == KeyEvent.VK_UP) handler.setUp(false);
                if(key2 == KeyEvent.VK_DOWN) handler.setDown(false);
                if(key2 == KeyEvent.VK_LEFT) handler.setLeft(false);
                if(key2 == KeyEvent.VK_RIGHT) handler.setRight(false);


            }

        }


    }
}
