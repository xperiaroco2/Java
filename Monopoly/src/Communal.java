import java.awt.*;

/**
 * Created by h on 02.04.2017.
 */
public class Communal extends Field{


    public Communal(int number,String name,int count,String type) {

        this.name = name;
        this.count = count;
        this.number = number;
        this.type = type;


    }


    public void draw(Graphics2D g) {
        if(number >= 2 && number <= 10 || number >= 22 && number <= 30)
        {
            width = 36;
            height = 62;
        }
        else{
            width = 62;
            height = 36;
        }
        if (number >= 12 && number <= 20) {
            x = 50;
            y = 50 + (9 * 36 + 63) - (36 * (number - 1 - 10));
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 7));
            g.drawString(name,x+2,y+10);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString(String.valueOf(count)+"$",x+4,y+35);

        }
        if (number >= 22 && number <= 30) {

            x = 50  + (36 * (number - 1-21))+63;
            y = 50;


            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+8,y+2);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString(String.valueOf(count)+"$",x+4,y+60);

        }
    }

}
