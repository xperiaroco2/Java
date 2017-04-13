import java.awt.*;

/**
 * Created by h on 02.04.2017.
 */
public class BigArea extends Field {



    public BigArea(int number) {
        this.number = number;
//        this.name = name;
//        this.count = count;
//        this.number = number;
        Purchasedable = false;
        width = 62;
        height = 62;

    }



    public void draw(Graphics2D g){
        switch (number){
            case (1):{x = 50+(9*36+63);
            y = 50+(9*36+63);
                g.setFont(new Font("Plant",Font.BOLD, 20));
                g.drawString("GO",x+15,y+35);
                g.setFont(new Font("Plant",Font.ITALIC, 10));
                g.drawString("Take 200$",x+8,y+50);
                break;
            }
            case (11):{x = 50;
                y = 50+(9*36+63);
                g.setFont(new Font("Plant",Font.BOLD, 20));
                g.drawString("JAIL",x+15,y+35);
                break;
            }
            case (21):{x = 50;
                y = 50;
                g.setFont(new Font("Plant",Font.BOLD, 12));
                g.drawString("PARKING",x+8,y+35);
                break;
            }
            case (31):{x = 50+(9*36+63);
                y = 50;
                g.setFont(new Font("Plant",Font.BOLD, 12));
                g.drawString("GO TO",x+8,y+25);
                g.drawString("JAIL",x+12,y+40);
                break;
            }
        }



            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x,y,62,62);




        }
    }

