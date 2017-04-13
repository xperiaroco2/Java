import java.awt.*;
import java.util.Map;

/**
 * Created by h on 02.04.2017.
 */
public class MyButton {
    private int buttonWidth;
    private int buttonHeight;
    private Color color;
    private String s;
    private int id;
    private int x;
    private int y;
    private Field currentArea;


    public MyButton(String s, int id,int x,int y){
        buttonWidth = 110;
        buttonHeight = 30;
        this.s = s;
        this.id = id;
        this.x = x;
        this.y = y;
        currentArea = null;
    }

    public void update(Player player) {
        switch (id) {
            case (1): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        GamePanel.state = GamePanel.STATES.PLAYERMOVE;
                    }
                }
                break;
            }

            case (2): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        GamePanel.waitForChoose = false;
                        GamePanel.state = GamePanel.STATES.PLAYERENDTURN;
                    }
                }
                break;
            }

            case (3): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        GamePanel.waitForChoose = false;
                        currentArea = Player.check(GamePanel.currentPlayer);
                        currentArea.isPurchased = true;
                        currentArea.whoseProperty = GamePanel.currentPlayer;
                        player.money -= currentArea.count;
                        if (currentArea.getClass().equals(Transport.class))
                            player.transportCount++;

                        if (currentArea.getClass().equals(Communal.class))
                            player.communalCount++;

                        for (Map.Entry map : player.possessions.entrySet()) {
                            if (map.getKey().equals(currentArea.type)) {
                                int x = (int) map.getValue();
                                x++;
                                map.setValue(x);
                            }
                        }

                        GamePanel.history.add(player.name + " bought a " + currentArea.name + " for " + currentArea.count + "$.\n ");
                    }
                }
                break;
            }


            case (4): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        currentArea = Player.check(GamePanel.currentPlayer);
                        GamePanel.waitForChoose = false;
                        GamePanel.state = GamePanel.STATES.PLAYERENDTURN;
                    }
                }
                break;
            }
            case (5): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        GamePanel.waitForChoose = false;
                    }
                }
                break;
            }
            case (6): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        GamePanel.waitForChoose = false;
                        GamePanel.houseTime = true;
                    }
                }
                break;
            }
            case (7): {
                if (GamePanel.mouseX > x && GamePanel.mouseX < x + buttonWidth
                        && GamePanel.mouseY > y && GamePanel.mouseY < y + buttonHeight) {
                    if (GamePanel.LCM) {
                        GamePanel.houseTime = false;
                    }
                }
                break;
            }

        }
    }




            public void draw(Graphics2D g){

            g.setColor(Color.black);
            g.drawRect(x,y,buttonWidth,buttonHeight);
            g.setFont(new Font("Consoles",Font.PLAIN, 12));
            g.drawString(s,x+4,y+20);

    }


}
