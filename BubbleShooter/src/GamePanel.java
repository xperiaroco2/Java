import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    //Window sizes
    public final static int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static int mouseX;
    public static int mouseY;
    public static boolean LCM;

    private Thread thread;

    private BufferedImage image;
    private Graphics2D graphics2D;

    private int FPS;
    private long FpsTimer;
    private static long sleepTime;
    private double FpsPerMillis;

    public static enum STATES {
        MENU,
        PLAY
    }

    public static STATES state = STATES.MENU;

    public static GameBack background;

    public static Player player;

    public static ArrayList<Bullet> bulletsUp, bulletsDown, bulletsLeft, bulletsRight, bullets;

    public static ArrayList<Enemy> enemies;

    public static Wave wave;

    public static FPS fps;

    public static Menu menu;

    //Frame constructor
    public GamePanel() {
        super(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(new Controler());
        addMouseListener(new Controler());
        addMouseMotionListener(new Controler());


    }

    public static int getFPS() {
        return (int) sleepTime;
    }

    public void runThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        FPS = 40;
        FpsPerMillis = 1000 / FPS;
        sleepTime = 0;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D) image.getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        LCM = false;
        background = new GameBack();
        player = new Player();
        bullets = new ArrayList<Bullet>();
        bulletsUp = new ArrayList<Bullet>();
        bulletsDown = new ArrayList<Bullet>();
        bulletsLeft = new ArrayList<Bullet>();
        bulletsRight = new ArrayList<Bullet>();


        enemies = new ArrayList<Enemy>();
        wave = new Wave();
        fps = new FPS();
        menu = new Menu();


        //Game stats
        while (true) {
            FpsTimer = System.nanoTime();

            if (state.equals(STATES.MENU)) {
                background.update();
                background.draw(graphics2D);
                menu.update();
                menu.draw(graphics2D);
                gameDraw();

            }

            if (state.equals(STATES.PLAY)) {

                if (player.TheEnd())
                    System.exit(0);

                gameUpdate();
                gameRender();
                gameDraw();
            }

            FpsTimer = (System.nanoTime() - FpsTimer) / 1000000;

            if (FpsPerMillis > FpsTimer)
                sleepTime = (int) (FpsPerMillis - FpsTimer);
            else sleepTime = 1;

            try {  //FPS
                thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            FpsTimer = 0;

        }
    }


    public void gameUpdate() {
    //Background update
    background.update();

    //FPS update
    fps.update();

    //Player update
    player.update();

    //Bullets update
    for (int i = 0; i < bulletsUp.size(); i++) {
        bulletsUp.get(i).updateUp();
        boolean remove = bulletsUp.get(i).remove();
        if (remove) {
            bulletsUp.remove(i);
            i--;
        }

    }

    for (int i = 0; i < bulletsLeft.size(); i++) {
        bulletsLeft.get(i).updateLeft();
        boolean remove = bulletsLeft.get(i).remove();
        if (remove) {
            bulletsLeft.remove(i);
            i--;
        }

    }

    for (int i = 0; i < bulletsRight.size(); i++) {
        bulletsRight.get(i).updateRight();
        boolean remove = bulletsRight.get(i).remove();
        if (remove) {
            bulletsRight.remove(i);
            i--;
        }

    }

    for (int i = 0; i < bulletsDown.size(); i++) {
        bulletsDown.get(i).updateDown();
        boolean remove = bulletsDown.get(i).remove();
        if (remove) {
            bulletsDown.remove(i);
            i--;
        }

    }

    //Enemy update
    for (int i = 0; i < enemies.size(); i++) {
        enemies.get(i).update();
        boolean remove = enemies.get(i).remove();
        if (remove)
            enemies.remove(i);
    }

    //Enemy hit
    for (int i = 0; i < enemies.size(); i++) {
        for (int j = 0; j < bulletsUp.size(); j++) {
            Enemy e = enemies.get(i);
            Bullet b = bulletsUp.get(j);
            double dx = e.getX() - b.getX();
            double dy = e.getY() - b.getY();
            double dist = Math.sqrt((dx * dx) + (dy * dy));
            if ((int) dist <= e.getRadius()) {
                e.hit();
                bulletsUp.remove(j);
                j--;
            }
        }
    }

    for (int i = 0; i < enemies.size(); i++) {
        for (int j = 0; j < bulletsDown.size(); j++) {
            Enemy e = enemies.get(i);
            Bullet b = bulletsDown.get(j);
            double dx = e.getX() - b.getX();
            double dy = e.getY() - b.getY();
            double dist = Math.sqrt((dx * dx) + (dy * dy));
            if ((int) dist <= e.getRadius()) {
                e.hit();
                bulletsDown.remove(j);
                j--;
            }
        }
    }

    for (int i = 0; i < enemies.size(); i++) {
        for (int j = 0; j < bulletsLeft.size(); j++) {
            Enemy e = enemies.get(i);
            Bullet b = bulletsLeft.get(j);
            double dx = e.getX() - b.getX();
            double dy = e.getY() - b.getY();
            double dist = Math.sqrt((dx * dx) + (dy * dy));
            if ((int) dist <= e.getRadius()) {
                e.hit();
                bulletsLeft.remove(j);
                j--;
            }
        }
    }

    for (int i = 0; i < enemies.size(); i++) {
        for (int j = 0; j < bulletsRight.size(); j++) {
            Enemy e = enemies.get(i);
            Bullet b = bulletsRight.get(j);
            double dx = e.getX() - b.getX();
            double dy = e.getY() - b.getY();
            double dist = Math.sqrt((dx * dx) + (dy * dy));
            if ((int) dist <= e.getRadius()) {
                e.hit();
                bulletsRight.remove(j);
                j--;
            }
        }
    }


    //Player hit
    for (int i = 0; i < enemies.size(); i++) {
        Enemy e = enemies.get(i);
        double dx = e.getX() - player.getX();
        double dy = e.getY() - player.getY();
        double dist = Math.sqrt((dx * dx) + (dy * dy));
        if ((int) dist <= player.getRadius()) {
            player.hit();
            enemies.remove(i);
        }
    }

    //Wave update
    wave.update();
}

    public void gameRender() {
        //Background draw
        background.draw(graphics2D);

        //FPS draw
        fps.draw(graphics2D);

        //Player draw
        player.draw(graphics2D);

        //Bullets draw
        bullets.addAll(bulletsUp);
        bullets.addAll(bulletsDown);
        bullets.addAll(bulletsLeft);
        bullets.addAll(bulletsRight);
        for (Bullet bl : bullets) {
            bl.draw(graphics2D);
        }
        while (bullets.size() != 0)
            bullets.remove(0);

        //Enemies draw
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(graphics2D);
        }

        //Wave draw
        if (wave.ShowWave())
            wave.draw(graphics2D);
    }

    private void gameDraw() {
        Graphics graphics = this.getGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();


    }



}