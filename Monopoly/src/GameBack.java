import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class GameBack {

    private static Image train;

    private Color color;

    public GameBack(){
        color = Color.WHITE;
    }

    public void draw(Graphics2D g) throws IOException {

        g.setColor(color);
        g.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);

        g.setColor(Color.black);
        g.drawLine(550,0,550,800);
        g.drawLine(0,550,550,550);



        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(50,50,450,450);
        g.fillRect(575,50,200,180);
        g.fillRect(575,250,200,520);

        g.setColor(Color.red);
        g.fillRect(235,130,80,40);
        g.setColor(Color.green);
        g.fillRect(235,380,80,40);

        g.setColor(Color.black);
        g.setFont(new Font("Consoles",Font.PLAIN, 40));
        g.drawString("MONOPOLY",160,290);
        g.setFont(new Font("Consoles",Font.BOLD, 17));
        g.drawString("CHANCE",237,155);
        g.drawString("CHEST",245,405);


        g.setFont(new Font("Consoles",Font.BOLD, 20));

        g.drawString("Players status",610,80);

        g.drawString("History",640,280);



        if(Player.cube1Count != null)
        g.drawString("Drop "+Player.cube1Count+" and "+Player.cube2Count,200,600);

//        train = ImageIO.read(GameBack.class.getResourceAsStream("image\\train1.jpg"));
//        g.drawImage(train,262,460,24,24,null);

        for(int i = 0;i < GamePanel.areas.size();i++){
            GamePanel.areas.get(i).draw(g);
        }

        for(int i = 0;i < GamePanel.history.size();i++) {
            g.setColor(Color.black);
            g.setFont(new Font("Consoles", Font.ITALIC, 8));
            g.drawString( GamePanel.history.get(i), 580, 280 - (i * 20) + (20 * GamePanel.history.size()));
        }


















        g.drawString("created by Dima B.",730,790);
    }
}


