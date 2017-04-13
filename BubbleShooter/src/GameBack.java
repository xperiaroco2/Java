import java.awt.*;


public class GameBack {

    private Color color;

    public GameBack(){
        color = Color.CYAN;
    }

    public void update(){

    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);
    }
}
