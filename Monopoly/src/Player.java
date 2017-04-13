import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.awt.Font.BOLD;

/**
 * Created by h on 02.04.2017.
 */
public class Player {

    public int number = 1;
    public Color color;
    public int money;
    public String name;
    public double x;
    public double y;
    private int radius;
    public int playerNumber;
    public static Random random;
    public int jailCount;
    public static String cube1Count;
    public static String cube2Count;
    public boolean safeCard;
    public static int cube1;
    public static int cube2;
    public int transportCount;
    public int communalCount;
    public Map<String,Integer> possessions;

    public Player(String name, int playerNumber, Color color) {
        x = 50 + (9 * 36 + 63) + 30;
        y = 50 + (9 * 36 + 63) + 35;
        this.playerNumber = playerNumber;

        money = 1500;
        radius = 5;
        this.name = name;
        this.color = color;
        random = new Random(System.currentTimeMillis());
        jailCount = 0;
        safeCard = false;
        transportCount = 0;
        communalCount = 0;
        possessions = new HashMap<>();

        for(Field area : GamePanel.areas){
            if(!area.Purchasedable)
                continue;


               possessions.put(area.type,0);


        }





    }


    public static void move(Player player) throws InterruptedException {

        cube1 = random.nextInt(6) + 1;
        cube2 = random.nextInt(6) + 1;
        cube1Count = String.valueOf(cube1);
        cube2Count = String.valueOf(cube2);
        if(player.jailCount == 0) {
            for (int i = 0; i<cube1+cube2; i++) {
                if (player.number != 40){
                    player.number++;
                }
                else {
                    GamePanel.history.add(player.name + " receives $ 200 for crossing the starting field!");
                    player.money += 200;
                    player.number = 1;
                }
            }
        }else player.jailCount--;

            Thread.sleep(300);
           GamePanel.state = GamePanel.STATES.PLAYERCHOOSE;
        }



    public static Field check(Player player) {



        for (Field area : GamePanel.areas) {
            if (area.number == player.number) {
                    return area;
                }
            }
        return GamePanel.areas.get(0);
    }





    public void draw(Graphics2D g){
        for (Field area : GamePanel.areas) {
            if (area.number == number) {
                x = area.x + area.width / 2;
                y = area.y + area.height / 2;
                break;
            }
        }

        g.setColor(Color.black);
        g.setFont(new Font("Consoles",Font.ITALIC, 12));
        g.drawString(String.valueOf(money)+"$",700,120+(100*(playerNumber-1)));
        g.setFont(new Font("Consoles",Font.BOLD, 16));
        g.drawString(name,590,120+(100*(playerNumber-1)));

        g.setColor(color);
        g.fillOval((int)(x-radius),(int)y-radius+(20*(playerNumber-1)-10),2*radius,2*radius);

    }
}
