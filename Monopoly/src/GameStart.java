
import javax.swing.*;
import java.io.*;


public class GameStart {

    public static void main(String[] args) {




            GamePanel panel = new GamePanel();

            JFrame startFrame = new JFrame("MONOPOLY");
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            startFrame.setResizable(false);
            startFrame.setContentPane(panel);
            startFrame.pack();
            startFrame.setLocationRelativeTo(null);
            startFrame.setVisible(true);
            panel.runThread();



    }
}

