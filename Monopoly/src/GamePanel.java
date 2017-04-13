import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class GamePanel extends JPanel implements Runnable{

   public static void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }


    public final static int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static int mouseX;
    public static int mouseY;
    public static boolean LCM;
    public static boolean waitForChoose;
    public static boolean houseTime;
    public static Field area;

    private Thread thread;

    private BufferedImage image;
    public static Graphics2D g;
    private GameBack background;

    public static ArrayList<Field> areas;
    public static Player player1;
    public static Player player2;
    public static ArrayList<MyButton> buttons;
    public static ArrayList<String> history;
    public static Player currentPlayer;
    public static ArrayList<Chance> ChanceList;
    public static ArrayList<String> housesList;

    public enum STATES {
        PLAYERMOVE,
        PLAYERCHOOSE,
        PLAYERENDTURN,
        NEWMOVE,
        HOUSE
    }
    public static STATES state = STATES.NEWMOVE;

    public GamePanel() {
        super(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addMouseListener(new Controler());
        addMouseMotionListener(new Controler());
    }

    public void runThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        waitForChoose = true;
        houseTime = false;
        LCM = false;
        background = new GameBack();

        areas = new ArrayList<Field>();
        buttons = new ArrayList<MyButton>();
        history = new ArrayList<String>();
        ChanceList = new ArrayList<>();
        housesList = new ArrayList<>();


        buttons.add(new MyButton("Drop the dice",1,200,620));
        buttons.add(new MyButton("End turn",2,200,700));
        buttons.add(new MyButton("Yes",3,120,330));
        buttons.add(new MyButton("No",4,280,330));
        buttons.add(new MyButton("Ok",5,220,330));
        buttons.add(new MyButton("Buy a house",6,200,750));
        buttons.add(new MyButton("Ok",7,220,330));


        /***************************************************************************
         *                               BIGAREAS                                   *
         ***************************************************************************/

            areas.add(new BigArea(21));
            areas.add(new BigArea(31));
            areas.add(new BigArea(1));
            areas.add(new BigArea(11));

        /***************************************************************************
         *                               AREAS                                      *
         ***************************************************************************/

            //brown
            areas.add(new Area(Color.getHSBColor(161,120,41),2,60,"Old road",2,"Brown",50));
            areas.add(new Area(Color.getHSBColor(161,120,41),4,60,"Main\nhighway",4,"Brown",50));
            //cyan
            areas.add(new Area(Color.cyan,7,100,"Aquapark",6,"Cyan",50));
            areas.add(new Area(Color.cyan,9,100,"City Park",6,"Cyan",50));
            areas.add(new Area(Color.cyan,10,120,"Ski resort",8,"Cyan",50));
            //purple
            areas.add(new Area(Color.magenta,12,140,"Dormitory\narea",10,"Purple",100));
            areas.add(new Area(Color.magenta,14,140,"Business\ndistrict",10,"Purple",100));
            areas.add(new Area(Color.magenta,15,160,"Trade area",12,"Purple",100));
            //orange
            areas.add(new Area(Color.orange,17,180,"Sherlock\nStreet",14,"Orange",100));
            areas.add(new Area(Color.orange,19,180,"Peace\nAvenue",14,"Orange",100));
            areas.add(new Area(Color.orange,20,200,"Victory\nAvenue",16,"Orange",100));
            //red
            areas.add(new Area(Color.red,22,220,"Bar",18,"Red",150));
            areas.add(new Area(Color.red,24,220,"Night Club",18,"Red",150));
            areas.add(new Area(Color.red,25,240,"Restaurant",20,"Red",150));
            //yellow
            areas.add(new Area(Color.yellow,27,260,"Computers",22,"Yellow",150));
            areas.add(new Area(Color.yellow,28,260,"Internet",22,"Yellow",150));
            areas.add(new Area(Color.yellow,30,280,"Cellular",24,"Yellow",150));
            //green
            areas.add(new Area(Color.green,32,300,"Shipping",26,"Green",200));
            areas.add(new Area(Color.green,33,300,"Railway\nstation",26,"Green",200));
            areas.add(new Area(Color.green,35,320,"Airline",28,"Green",200));
            //blue
            areas.add(new Area(Color.blue,38,350,"Resort area",35,"Blue",200));
            areas.add(new Area(Color.blue,40,400,"Hotel",50,"Blue",200));

         /***************************************************************************
         *                           CHANCE AND CHEST                               *
         ***************************************************************************/

            areas.add(new ChanceAndChest(3));
            areas.add(new ChanceAndChest(8));
            areas.add(new ChanceAndChest(18));
            areas.add(new ChanceAndChest(23));
            areas.add(new ChanceAndChest(34));
            areas.add(new ChanceAndChest(37));



            ChanceList.add(new Chance("Go to the hotel",0,40));
            ChanceList.add(new Chance("Go to the start",0,1));
            ChanceList.add(new Chance("Jail release",1337,0));
            ChanceList.add(new Chance("Street repair fee",-40,0));
            ChanceList.add(new Chance("Go to the restaurant",0,25));
            ChanceList.add(new Chance("Speeding fine",-15,0));
            ChanceList.add(new Chance("Loan repayment",150,0));
            ChanceList.add(new Chance("You were arrested",0,31));
            ChanceList.add(new Chance("Major repairs",-25,0));
            ChanceList.add(new Chance("Go to the northern railway",0,16));
            ChanceList.add(new Chance("Drunk driving",-20,0));
            ChanceList.add(new Chance("Payment of driver's courses",-150,0));
            ChanceList.add(new Chance("You won the chess championship",100,0));
            ChanceList.add(new Chance("Go to the aquapark",-25,7));



        /***************************************************************************
         *                           TRANSPORT                                     *
         ***************************************************************************/

            areas.add(new Transport(6,25,"Western\nRailway",200,"Transport"));
            areas.add(new Transport(16,25,"Northern Railway",200,"Transport"));
            areas.add(new Transport(26,25,"Eastern\nRailway",200,"Transport"));
            areas.add(new Transport(36,25,"Southern Railway",200,"Transport"));

        /***************************************************************************
         *                           TAXATION                                      *
         ***************************************************************************/

            areas.add(new Taxation(5,100));
            areas.add(new Taxation(39,200));

        /***************************************************************************
         *                           COMMUNAL                                      *
         ***************************************************************************/

            areas.add(new Communal(13,"Electric company",200,"Communal"));
            areas.add(new Communal(29,"Water\nworks",200,"Communal"));


        player1 = new Player("Dima",1,Color.red);
        player2 = new Player("Tom",2,Color.green);
        currentPlayer = player1;


        try {
            background.draw(g);
        } catch (IOException e) {
            e.printStackTrace();
        }





        while (true){
            try {
                gameUpdate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                gameRender();
            } catch (IOException e) {
                e.printStackTrace();
            }
            gameDraw();
            if(state.equals(STATES.PLAYERENDTURN)){
            if(currentPlayer == player1)
                currentPlayer = player2;
            else currentPlayer = player1;

            state = STATES.NEWMOVE;}
        }
    }
    public void gameUpdate() throws InterruptedException {

        //Background update
        if (history.size() > 27)
            history.remove(0);

        housesList.clear();

        if(currentPlayer.money < 0){
            g.setColor(Color.gray);
            g.setStroke(new BasicStroke(1));
            g.drawRect(80, 200, 395, 180);
            g.fillRect(80, 200, 395, 180);
            g.setColor(Color.black);
            g.setFont(new Font("Consoles",Font.BOLD,20));
            g.drawString(currentPlayer.name+" lose!!!",200,250);
            gameDraw();
            Thread.sleep(5000);
            System.exit(0);
        }



        for(Map.Entry map : currentPlayer.possessions.entrySet()){
            if((map.getKey().equals("Brown") || map.getKey().equals("Blue")) && map.getValue().equals(2)){
                housesList.add(String.valueOf(map.getKey()));
            }
            else if(map.getValue().equals(3) && !(map.getKey().equals("Transport") || map.getKey().equals("Communal"))){
                housesList.add(String.valueOf(map.getKey()));
            }
        }

        area = Player.check(currentPlayer);

        if(state.equals(STATES.HOUSE)){
            waitForChoose = true;
            while (waitForChoose){
                buttons.get(1).draw(g);
                buttons.get(5).draw(g);
                gameDraw();
                buttons.get(1).update(currentPlayer);
                buttons.get(5).update(currentPlayer);
                }
            while(houseTime){
                g.setColor(Color.gray);
                g.setStroke(new BasicStroke(1));
                g.drawRect(80, 200, 395, 180);
                g.fillRect(80, 200, 395, 180);
                g.setColor(Color.black);
                g.setFont(new Font("Consoles",Font.BOLD,20));
                if(housesList.size() != 0){
                    for(int i = 0; i < housesList.size(); i++)
                        drawString(g,housesList.get(i),200,200+(20*i-1));

                    for(Field area : areas){
                    if (GamePanel.mouseX > area.x && GamePanel.mouseX < area.x + area.width
                            && GamePanel.mouseY > area.y && GamePanel.mouseY < area.y + area.height) {
                        if (GamePanel.LCM) {
                            if(area.houseCount != 5 && area.getClass().equals(Area.class) && currentPlayer.money > area.houseCost-1){
                                Thread.sleep(100);
                                area.houseCount++;
                                currentPlayer.money -= area.houseCost;
                            }
                        }
                    }
                }
                }
                else drawString(g,"You don't have an area",200,200);
                buttons.get(6).draw(g);
                gameDraw();
                buttons.get(6).update(currentPlayer);
            }
        }

        if (state.equals(STATES.PLAYERCHOOSE)) {
            if (area.Purchasedable) {
                if (area.isPurchased) {
                    if(area.getClass().equals(Transport.class)){
                        if(currentPlayer == player1){
                            currentPlayer.money -= (area.rent*player2.transportCount);
                            history.add(currentPlayer.name+" pays rent "+(area.rent*player2.transportCount)+"$");
                    }else if(currentPlayer == player2){
                            currentPlayer.money -= (area.rent*player1.transportCount);
                            history.add(currentPlayer.name+" pays rent "+(area.rent*player2.transportCount)+"$");
                        }
                    }else if(area.getClass().equals(Communal.class)) {
                        if (currentPlayer == player1) {
                            if (player2.communalCount == 1) {
                                currentPlayer.money -= (Player.cube1 + Player.cube2) * 4;
                                history.add(currentPlayer.name+" pays rent "+String.valueOf((Player.cube1 + Player.cube2) * 4)+"$");
                            } else if (player2.communalCount == 2) {
                                currentPlayer.money -= (Player.cube1 + Player.cube2) * 10;
                                history.add(currentPlayer.name+" pays rent "+String.valueOf((Player.cube1 + Player.cube2) * 10)+"$");
                            }
                        } else if (currentPlayer == player2) {
                            if (player1.communalCount == 1) {
                                currentPlayer.money -= (Player.cube1 + Player.cube2) * 4;
                                System.out.println("-" + ((Player.cube1 + Player.cube2) + player1.communalCount));
                            } else if (player1.communalCount == 2) {
                                currentPlayer.money -= (Player.cube1 + Player.cube2) * 10;
                                System.out.println("-" + ((Player.cube1 + Player.cube2) + player1.communalCount));
                            }
                        }
                    }
                    else {
                        currentPlayer.money -= (area.rent)+(area.rent*area.houseCount);
                        history.add(currentPlayer.name+" pays rent "+String.valueOf((area.rent)+(area.rent*area.houseCount))+"$");
                    }
                }
                else{
                    waitForChoose = true;
                    while (waitForChoose) {
                        g.setColor(Color.gray);
                        g.setStroke(new BasicStroke(1));
                        g.drawRect(80, 200, 395, 180);
                        g.fillRect(80, 200, 395, 180);
                        g.setColor(Color.black);
                        g.setFont(new Font("Consoles",Font.BOLD,20));
                        drawString(g,area.name,200,200);
                        drawString(g,"Price "+area.count+"$",200,280);
                        buttons.get(2).draw(g);
                        buttons.get(3).draw(g);
                        gameDraw();
                        buttons.get(2).update(currentPlayer);
                        buttons.get(3).update(currentPlayer);
                    }
                }
            } else if (area.getClass().equals(ChanceAndChest.class)) {
                waitForChoose = true;
                while (waitForChoose) {
                    g.setColor(Color.gray);
                    g.setStroke(new BasicStroke(1));
                    g.drawRect(80, 200, 395, 180);
                    g.fillRect(80, 200, 395, 180);
                    ChanceList.get(0).draw(g);
                    buttons.get(4).draw(g);
                    gameDraw();
                    buttons.get(4).update(currentPlayer);
                }
                ChanceList.get(0).update(currentPlayer);
                currentPlayer.draw(g);
                Chance tmp = ChanceList.get(0);
                ChanceList.remove(0);
                ChanceList.add(ChanceList.size() - 1, tmp);

            } else if (area.getClass().equals(Taxation.class)) {
                waitForChoose = true;
                while (waitForChoose) {
                    g.setColor(Color.gray);
                    g.setStroke(new BasicStroke(1));
                    g.drawRect(80, 200, 395, 180);
                    g.fillRect(80, 200, 395, 180);
                    g.setColor(Color.black);
                    g.setFont(new Font("Plant", Font.ITALIC, 25));
                    g.drawString(currentPlayer.name + " must pay taxation " + area.count + "$", 100, 290);
                    buttons.get(4).draw(g);
                    gameDraw();
                    buttons.get(4).update(currentPlayer);
                }
                currentPlayer.money -= area.count;
            } else if (area.number == 31) {
                waitForChoose = true;
                while (waitForChoose) {
                    g.setColor(Color.gray);
                    g.setStroke(new BasicStroke(1));
                    g.drawRect(80, 200, 395, 180);
                    g.fillRect(80, 200, 395, 180);
                    g.setColor(Color.black);
                    g.setFont(new Font("Plant", Font.ITALIC, 25));
                    g.drawString("Go to the jail!", 100, 290);
                    buttons.get(4).draw(g);
                    gameDraw();
                    buttons.get(4).update(currentPlayer);
                }
                currentPlayer.number = 11;
                currentPlayer.draw(g);
                if (currentPlayer.safeCard) {
                    history.add(currentPlayer.name+" avoids the prison by using the card");
                } else currentPlayer.jailCount = 3;
            }
            else if (area.number == 11 && currentPlayer.jailCount != 0) {
                waitForChoose = true;
                while (waitForChoose) {
                    if(Player.cube1 == Player.cube2){
                        g.setColor(Color.gray);
                        g.setStroke(new BasicStroke(1));
                        g.drawRect(80, 200, 395, 180);
                        g.fillRect(80, 200, 395, 180);
                        g.setColor(Color.black);
                        g.setFont(new Font("Plant", Font.ITALIC, 25));
                        g.drawString("Dropped double dice", 100, 290);
                        currentPlayer.number += Player.cube1 + Player.cube2;
                    }else {
                        g.setColor(Color.gray);
                        g.setStroke(new BasicStroke(1));
                        g.drawRect(80, 200, 395, 180);
                        g.fillRect(80, 200, 395, 180);
                        g.setColor(Color.black);
                        g.setFont(new Font("Plant", Font.ITALIC, 25));
                        g.drawString("On the dice didn't fall a double", 100, 290);
                    }
                    currentPlayer.draw(g);
                    buttons.get(4).draw(g);
                    gameDraw();
                    buttons.get(4).update(currentPlayer);
                }
            }
            state = STATES.HOUSE;
        }

        if (state.equals(STATES.PLAYERMOVE))
            Player.move(currentPlayer);

        if (state.equals(STATES.NEWMOVE))
            buttons.get(0).update(currentPlayer);

    }

    public void gameRender() throws IOException {
        //Background draw
        background.draw(g);

        if(state.equals(STATES.NEWMOVE))
            buttons.get(0).draw(g);

        player1.draw(g);
        player2.draw(g);

    }

    public  void gameDraw() {
        Graphics graphics = this.getGraphics();
        graphics.drawImage(image, 0, 0,null);
        graphics.dispose();
    }

}




