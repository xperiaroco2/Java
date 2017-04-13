import java.awt.*;

/**
 * Created by h on 02.04.2017.
 */
public class ChanceAndChest extends Field {



    public ChanceAndChest(int number) {

//        this.name = name;
//        this.count = count;
        this.number = number;
//        this.type = type;
        Purchasedable = false;

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
            g.setFont(new Font("Plant",Font.PLAIN, 5));
          if(number == 3) {
              g.drawString("COMMUNITY", x + 2, y + 10);
              g.drawString("CHEST", x + 7, y + 17);
          }
          if(number == 8){
              g.drawString("CHANCE", x + 6, y + 10);

          }






        }
        if (number >= 12 && number <= 20) {
            x = 50;
            y = 50 + (9 * 36 + 63) - (36 * (number - 1 - 10));
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 5));
            g.drawString("COMMUNITY CHEST",x+2,y+10);


        }
        if (number >= 22 && number <= 30) {

            x = 50  + (36 * (number - 1-21))+63;
            y = 50;


            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 5));
            g.drawString("COMMUNITY",x+2,y+10);
            g.drawString("CHEST",x+7,y+17);


        }
        if (number >= 32 && number <= 40) {
            x = 50 + (9 * 36 + 63);
            y = 50  + 63 +(36*(number-32));
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            g.drawRect(x, y, width, height);
            g.setFont(new Font("Plant",Font.PLAIN, 5));
          if(number == 34)
                g.drawString("COMMUNITY CHEST",x+2,y+10);

          if(number == 37)
                g.drawString("CHANCE",x+14,y+10);

        }
    }
}
