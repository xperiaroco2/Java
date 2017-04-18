import javax.swing.*;
import java.awt.*;

/**
 * Created by h on 17.04.2017.
 */
public class MyJPanel extends JPanel {

    public MyJPanel(String name, int width,int height) {
        super.setSize(width,height);
        super.setName(name);
        super.setBorder(BorderFactory.createBevelBorder(0));
    }

    public MyJPanel(String name, int width, int height, Component comp){
        this(name, width, height);
        super.add(comp);
    }

    public MyJPanel(String name, int width, int height, LayoutManager layout){
        this(name, width, height);
        super.setLayout(layout);
    }

    public MyJPanel(String name, int width, int height, LayoutManager layout, Component comp){
        this(name, width, height,layout);
        super.add(comp);
    }
}
