import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Wave {

    private String WaveText;
    private int WaveCount;
    private long WaveTimer;
    private long WaveDelay;
    private long WaveTimerDiff;
    private int WaveMulti;
    private int WaveNumber;



    public Wave(){

        WaveNumber = 1;
        WaveCount = 1;
        WaveMulti = 5;
        WaveTimer = 0;
        WaveDelay = 5000;
        WaveTimerDiff = 0;




    }

    public int GetWaveNumber(){
        return WaveNumber;
    }

    public void update() {
        WaveText = "Wave " + WaveNumber;
        if(WaveNumber > 5)
            WaveText = "The end!";

        if(GamePanel.enemies.size() == 0 && WaveTimer == 0){

            WaveTimer = System.nanoTime();


        }

        if(WaveTimer > 0){
            WaveTimerDiff += (System.nanoTime() - WaveTimer)/1000000;
            WaveTimer = System.nanoTime();
        }

        if(WaveTimerDiff > WaveDelay){
            createWave();
            WaveTimer = 0;
            WaveTimerDiff = 0;
        }
    }

    public void draw(Graphics2D graphics2D) {
        double divider = WaveDelay / 180;
        double alpha = WaveTimerDiff/divider;
        alpha = 255 * Math.sin(Math.toRadians(alpha));

        if(alpha<0)
            alpha = 0;
        if(alpha<255)
            alpha = 255;


        graphics2D.setColor(new Color(255,255,255,(int)alpha));
        graphics2D.setFont(new Font("Consoles",Font.BOLD, 12));
        long length = (int) graphics2D.getFontMetrics().getStringBounds(WaveText,graphics2D).getWidth();
        graphics2D.drawString(WaveText, GamePanel.WIDTH/2 - (int)length+25,GamePanel.HEIGHT/2);

    }



    public void createWave(){

        int EnemyCount = WaveNumber * WaveMulti;
        if(WaveNumber < 6){
            while (EnemyCount > 0){
                int type = 1;
                int rank = 1;
                GamePanel.enemies.add(new Enemy(1,1));
                EnemyCount -= type * rank;
            }

        }
        if(WaveNumber > 5)
            System.exit(0);
        WaveNumber++;}

    public boolean ShowWave(){
        if(WaveTimer != 0)
            return true;

        return false;
    }

}
