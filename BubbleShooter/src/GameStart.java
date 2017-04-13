
import javazoom.jl.decoder.JavaLayerException;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.*;


public class GameStart {

    public static void main(String[] args)  {


        //Создание потока
        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                File file = new File("D:\\JavaGame\\src\\play.mp3");
                FileInputStream fis = null;
                do{try {
                    fis = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedInputStream bis = new BufferedInputStream(fis);

                javazoom.jl.player.Player player = null;
                try {
                    player = new Player(bis);
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }}while(true);
            }
        });
        myThready.start();


        GamePanel panel = new GamePanel();

        JFrame startFrame = new JFrame("MLG Bubble");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setContentPane(panel);
        startFrame.pack();
        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);
        panel.runThread();
    }


}
