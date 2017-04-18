import com.jtattoo.plaf.JTattooUtilities;
import com.jtattoo.plaf.smart.SmartLookAndFeel;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {


       UIManager.setLookAndFeel(new SmartLookAndFeel());

       JFrame.setDefaultLookAndFeelDecorated(true);

        MyJButton button1 = new MyJButton("Button_1");

        MyJPanel panel1 = new MyJPanel("Panel", 100,100,button1);

        MyJFrame frame = new MyJFrame("Frame",200,200,panel1);



    }
}
