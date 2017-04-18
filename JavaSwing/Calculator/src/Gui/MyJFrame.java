package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h on 17.04.2017.
 */
public class MyJFrame extends JFrame {

    public MyJFrame(String title, int width, int height){
        super(title);
        super.setSize(width,height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        super.setVisible(true);
    }

    public MyJFrame(String title, int width,int height,Component comp){
        this(title, width, height);
        super.getContentPane().add(comp);
    }

    public MyJFrame(String title,int width,int height,LayoutManager layout){
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(layout);
    }
}

