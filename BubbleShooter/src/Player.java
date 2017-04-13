
import java.awt.*;

public class Player {

    private double x;
    private double y;
    private int radius;
    private Color color1;
    private Color color2;
    private int speed;
    private double dx;
    private double dy;
    private int health;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    public static boolean fireUp;
    public static boolean fireDown;
    public static boolean fireLeft;
    public static boolean fireRight;


    public Player(){

        x = GamePanel.WIDTH/2;
        y = GamePanel.HEIGHT/2;

        radius = 5;

        speed = 5;

        health = 3;

        dx = 0;
        dy = 0;

        color1 = Color.MAGENTA;

        up = false;
        down = false;
        left = false;
        right = false;

        fireUp = false;
        fireDown = false;
        fireLeft = false;
        fireRight = false;

    }

        public double getX(){
        return x;
        }

        public double getY(){
        return y;
        }

    public double getRadius(){
        return radius;
    }

    public void hit(){
        health--;
    }

    public boolean TheEnd(){
        if(health<=0)
            return true;

        return false;
    }

    public void update(){
        if(up && y>radius)
            dy = -speed;

        if(down && y<GamePanel.HEIGHT-radius)
            dy = speed;

        if(left && x>radius)
            dx = -speed;

        if(right && x<GamePanel.WIDTH-radius)
            dx = speed;

        if(up && left || up && right || down && left || down && right){
            double angle = Math.toRadians(45);
            dy = dy * Math.sin(angle);
            dx = dx* Math.cos(angle);
        }

        y += dy;
        x += dx;

        dy = 0;
        dx = 0;

        if(fireUp){
            GamePanel.bulletsUp.add(new Bullet());
        }

        if(fireDown){
            GamePanel.bulletsDown.add(new Bullet());
        }

        if(fireLeft){
            GamePanel.bulletsLeft.add(new Bullet());
        }

        if(fireRight){
            GamePanel.bulletsRight.add(new Bullet());
        }
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color1);
        graphics2D.fillOval((int)(x-radius),(int)(y-radius),2*radius,2*radius);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setColor(color1.darker());
        graphics2D.drawOval((int)(x-radius),(int)(y-radius),2*radius,2*radius);
        graphics2D.setStroke(new BasicStroke(1));
    }

}
