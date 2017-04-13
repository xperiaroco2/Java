import java.awt.*;


public class FPS {

    private int fps;

    public FPS(){
        fps = 0;
    }

    public void update(){
        fps = GamePanel.getFPS();
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(new Color(255,255,255));

        graphics2D.setFont(new Font("Consoles",Font.BOLD, 12));
        graphics2D.drawString("FPS "+fps, GamePanel.WIDTH-45,GamePanel.HEIGHT-(GamePanel.HEIGHT-20));
    }
}
