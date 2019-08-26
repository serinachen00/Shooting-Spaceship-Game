package TankGame;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> obj = new LinkedList<GameObject>();

    private boolean W = false, S = false, A = false, D = false;
    private boolean Up = false, Down = false, Left = false, Right = false;

    public boolean isUp() {
        return Up;
    }

    public void setUp(boolean up) {
        Up = up;
    }

    public boolean isDown() {
        return Down;
    }

    public void setDown(boolean down) {
        Down = down;
    }

    public boolean isLeft() {
        return Left;
    }

    public void setLeft(boolean left) {
        Left = left;
    }

    public boolean isRight() {
        return Right;
    }

    public void setRight(boolean right) {
        Right = right;
    }

    public boolean isW() {
        return W;
    }

    public void setW(boolean w) {
        W = w;
    }

    public boolean isS() {
        return S;
    }

    public void setS(boolean s) {
        S = s;
    }

    public boolean isA() {
        return A;
    }

    public void setA(boolean a) {
        A = a;
    }

    public boolean isD() {
        return D;
    }

    public void setD(boolean d) {
        D = d;
    }

    public void tick(){

        for (int i = 0; i< obj.size(); i++){

            GameObject temp = obj.get(i);
            temp.tick();

        }
    }

    public void render(Graphics g){


        for (int i = 0; i< obj.size(); i++){
            GameObject temp = obj.get(i);
            temp.render(g);

        }
    }

    public void addObject (GameObject temp){

        obj.add(temp);
    }

    public void removeObject (GameObject temp){

        obj.remove(temp);
    }

}
