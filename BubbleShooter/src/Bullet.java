import java.awt.*;

public class Bullet {

    private double x;
    private double y;
    private int radius;
    private Color color1;
    private int speed;




    //Constructor
    public Bullet(){
        x = GamePanel.player.getX();
        y = GamePanel.player.getY();
        radius = 2;
        speed = 10;
        color1 = Color.white;

    }

    public boolean remove(){
        if(y < 0 || y > GamePanel.HEIGHT|| x < 0 || x > GamePanel.WIDTH)
            return true;

            return false;

    }

    //Functions

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void updateUp(){
            y -= speed;
    }

    public void updateRight(){
            x += speed;
    }

    public void updateLeft(){
            x -= speed;
    }

    public void updateDown(){
            y += speed;
    }


    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color1);
        graphics2D.fillOval((int)x,(int)y,2*radius,2*radius);
    }
}
