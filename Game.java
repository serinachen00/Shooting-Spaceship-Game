package TankGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private ImageLoader ss;

    private BufferedImage map1;
    private BufferedImage sprite_sheet = null;

    private BufferedImage ship, ship2, fruits = null;
    private BufferedImage ground = null;
    private Menu menu;


    public int amo1 =100 , amo2 = 100;
    public int hp1= 100 , hp2  = 100;




    public Game(){

        new Window(1000, 563, "Ship Game", this);

        menu = new Menu();

        // Game Menu

            start();

            handler = new Handler();
            camera = new Camera(0,0);

            //KeyInput Listener
            this.addKeyListener(new KeyInput(handler));

            //to read the map
            try {
                map1 = ImageIO.read(new File("resources/Map1.png"));
            } catch (IOException e) {

                e.printStackTrace();
            }

            //to load all the images into the game
            ss = new ImageLoader(sprite_sheet);

            ship = ss.grabShip();
            ground = ss.grabGround();


            this.addMouseListener(new MouseInput(handler, camera, this, ss));

            //Load the Map here
            loadLevel(map1);

        }


    private void start(){

        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }

    private void stop(){
        isRunning= false;
        try {
            thread.join();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();

        }

    }

    public void run() {

        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames =0;
        while (isRunning){
            long now = System.nanoTime();
            delta += (now- lastTime) /ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;

            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer>1000){
                timer += 1000;
                frames=0;

            }

        }
        stop();


    }

    public void  tick(){


        handler.tick();


            for (int i =0; i< handler.obj.size(); i++){

                if(handler.obj.get(i).getId() == ID.Player){

                    camera.tick(handler.obj.get(i));
                }

            }
        }



    public void render(){

        //removethis
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null){
            this.createBufferStrategy(3);
            return;

        }

        Graphics graphics = bs.getDrawGraphics();
        Graphics2D  g2d = (Graphics2D) graphics;

        graphics.setColor(Color.red);
        graphics.fillRect(0,0,1000,563);


        //Game Menu

            graphics.setColor(Color.red);
            graphics.fillRect(0,0,1000,563);

            g2d.translate(-camera.getX(),- camera.getY());
            handler.render(graphics);

            //IF GAMEOVER TRUE OR NOT


            /////////////////////////////////////draw anything here start /////////////////////////////////////////////////////////

            //to Draw the image for the ground
            for(int xx =0; xx < 30*72 ; xx+=32){

                for (int yy=0; yy < 30* 72; yy+= 32){

                    graphics.drawImage(ground, xx,yy,null);
                }
            }

            handler.render(graphics);

            g2d.translate(camera.getX(), camera.getY());

            //Health Bar for FirstShip
            graphics.setColor(Color.gray);
            graphics.fillRect(2,2,100,20);
            graphics.setColor(Color.green);
            graphics.fillRect(2,2, hp1,20);
            graphics.setColor(Color.black);
            graphics.drawRect(2,2,100,20);

            graphics.setColor(Color.white);
            graphics.drawString("Bullets: " + amo1, 5, 50);


            ////////////////////////////////////draw anything here end /////////////////////////////////////////////////////////


        graphics.dispose();
        bs.show();

    }

    private void loadLevel(BufferedImage image){

        int w = image.getWidth();
        int h = image.getHeight();

        for(int xa=0; xa< w; xa++){

            for (int ya=0; ya< h; ya++) {

                int pixel = image.getRGB(xa, ya);

                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255 && blue ==0 && green == 0)
                    handler.addObject(new Block( xa*32, ya*32, ID.Block, handler, ss));

                if(blue==255 && green ==0 && red == 0)
                    handler.addObject(new Ship1(xa*32, ya*32, ID.Player, handler, this, ss));

                if( green == 255 && blue ==0)
                    handler.addObject(new Enemy(xa * 32, ya * 32, ID.Enemy, handler, ss));

                if( green == 255 && blue ==255)
                    handler.addObject(new Crate(xa * 32, ya * 32, ID.Crate, ss));

                if( blue == 175)
                    handler.addObject(new HealthLife(xa * 32, ya * 32, ID.Breakable_Block, handler,this,  ss));



            }

        }
    }
    public static void main(String args[]){

        new Game();
    }
}
