import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by h on 02.04.2017.
 */
public class Area extends Field {

Color color;


    public Area(Color color, int number,int count,String name,int rent,String type, int houseCost) {
        this.color = color;
        this.name = name;
        this.count = count;
        this.number = number;
        this.rent = rent;
        this.type = type;
        this.houseCost = houseCost;
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

            g.setStroke(new BasicStroke(1));
            g.setColor(color);
            g.fillRect(x + 1, y + 1, 35, 15);
            g.setColor(Color.black);
            g.setFont(new Font("Consoles",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+20);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString(String.valueOf(count)+"$",x+6,y+59);

            if(isPurchased){
                g.setColor(whoseProperty.color);
                g.drawString(String.valueOf(houseCount),x+10,y-5);
            }
        }
        if (number >= 12 && number <= 20) {
            x = 50;
            y = 50 + (9 * 36 + 63) - (36 * (number - 1 - 10));
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);

            g.setStroke(new BasicStroke(1));
            g.setColor(color);
            g.fillRect(x + 47, y + 1, 15, 35);
            g.setColor(Color.black);
            g.setFont(new Font("Consoles",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+4);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString(String.valueOf(count)+"$",x+2,y+33);

            if(isPurchased){
                g.setColor(whoseProperty.color);
                g.drawString(String.valueOf(houseCount),x+70,y+10);
            }
        }
        if (number >= 22 && number <= 30) {

            x = 50  + (36 * (number - 1-21))+63;
            y = 50;


            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);

            g.setStroke(new BasicStroke(1));
            g.setColor(color);
            g.fillRect(x + 1, y + 1, 35, 15);
            g.setColor(Color.black);
            g.setFont(new Font("Consoles",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+2,y+20);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString(String.valueOf(count)+"$",x+4,y+60);

            if(isPurchased){
                g.setColor(whoseProperty.color);
                g.drawString(String.valueOf(houseCount),x+10,y+75);
            }
        }
        if (number >= 32 && number <= 40) {
            x = 50 + (9 * 36 + 63);
            y = 50  + 63 +(36*(number-32));


            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);

            g.setStroke(new BasicStroke(1));
            g.setColor(color);
            g.fillRect(x + 1, y + 1, 15, 35);
            g.setColor(Color.black);
            g.setFont(new Font("Consoles",Font.PLAIN, 7));
            GamePanel.drawString(g,name,x+18,y+4);
            g.setFont(new Font("Consoles",Font.ITALIC, 8));
            g.drawString(String.valueOf(count)+"$",x+30,y+35);

            if(isPurchased){
                g.setColor(whoseProperty.color);
                g.drawString(String.valueOf(houseCount),x-10,y+10);
            }

        }
    }
}

