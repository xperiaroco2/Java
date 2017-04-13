import java.awt.*;

public class Menu {

    private int buttonWidth;
    private int buttonHeight;
    private Color color;
    private String s;
    private String title;
    private int transp;

    public Menu(){
        buttonWidth = 100;
        buttonHeight = 50;
        color = Color.pink;
        s = "PLAY";
        title = "MLG BUBBLE";
        transp = 0;
    }

    public void update(){
        if     (GamePanel.mouseX > GamePanel.WIDTH/2 - buttonWidth/2 &&
                GamePanel.mouseX < GamePanel.WIDTH/2 + buttonWidth/2 &&
                GamePanel.mouseY > GamePanel.HEIGHT/2 - buttonHeight/2 &&
                GamePanel.mouseY < GamePanel.HEIGHT/2 + buttonHeight/2)
        transp = 60;

        else transp = 0;

        if(GamePanel.LCM)
            GamePanel.state = GamePanel.STATES.PLAY;


    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 - buttonHeight/2,buttonWidth,buttonHeight);
        graphics2D.setColor(new Color(255,255,255,transp));
        graphics2D.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 - buttonHeight/2,buttonWidth,buttonHeight);
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setColor(color);
        graphics2D.setFont(new Font("Consoles",Font.BOLD, 35));
        long leght =  (int) graphics2D.getFontMetrics().getStringBounds(s,graphics2D).getWidth();
        graphics2D.drawString(s,(int)(GamePanel.WIDTH/2 - leght/2),(int)(GamePanel.HEIGHT/2 + buttonHeight/4));
        graphics2D.setColor(color);
        graphics2D.setFont(new Font("Consoles",Font.BOLD, 100));
        graphics2D.drawString(title,(int)(GamePanel.WIDTH - (GamePanel.WIDTH - 50)),100);

    }

}
