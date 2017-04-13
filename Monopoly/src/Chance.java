import java.awt.*;

/**
 * Created by h on 05.04.2017.
 */
public class Chance {

    public String message;
    public int count;
    public int goToField;

    public Chance(String message, int count, int goToField){
        this.message = message;
        this.count = count;
        this.goToField = goToField;
    }

    public void update(Player player){
        if(count == 1337){
            player.safeCard = true;
        }
        else if(count != 0)
        player.money += count;

        if(goToField != 0){
            while (player.number != goToField){
                if (player.number != 40)
                    player.number++;
                else {
                    GamePanel.history.add(player.name + " receives $ 200 for crossing the starting field!");
                    player.money += 200;
                    player.number = 1;

                }
            }
        }
        if(goToField == 11) {
            if (!player.safeCard) {
                player.jailCount = 3;
            } else System.out.println("Safecard2");
        }
    }

    public void draw(Graphics2D g){

        g.setColor(Color.black);
        g.setFont(new Font("Plant",Font.ITALIC, 25));

            if(count == 0 || count == 1337)
            GamePanel.drawString(GamePanel.g,message,100,210);
            else if(count > 0) g.drawString(message+" +"+String.valueOf(count)+"$",100,290);
            else g.drawString(message+" "+String.valueOf(count)+"$",100,290);

    }
}
