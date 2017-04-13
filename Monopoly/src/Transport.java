import java.awt.*;

/**
 * Created by h on 02.04.2017.
 */
public class Transport extends Field {


    public Transport(int number,int rent,String name,int count,String type) {

        this.name = name;
        this.count = count;
        this.number = number;
        this.type = type;
        this.rent = rent;

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
        if (number >= 2 && number <= 10) {

            x = 50 + (9 * 36 + 63) - (36 * (number - 1));
            y = 50 + (9 * 36 + 63);

            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setColor(Color.black);
            g.setFont(new Font("Plant",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+2);

            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString("200$",x+4,y+60);

        }
        if (number >= 12 && number <= 20) {
            x = 50;
            y = 50 + (9 * 36 + 63) - (36 * (number - 1 - 10));
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+2);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString("200$",x+4,y+35);

        }
        if (number >= 22 && number <= 30) {

            x = 50  + (36 * (number - 1-21))+63;
            y = 50;

            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+2);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString("200$",x+4,y+60);
        }
        if (number >= 32 && number <= 40) {
            x = 50 + (9 * 36 + 63);
            y = 50  + 63 +(36*(number-32));
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+2);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString("200$",x+4,y+35);
        }
    }
}
