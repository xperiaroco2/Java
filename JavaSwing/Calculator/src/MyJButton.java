import javax.swing.*;

/**
 * Created by h on 17.04.2017.
 */
public class MyJButton extends JButton {

    public MyJButton(String title) {
        super.setText(title);
    }

    public MyJButton(String title,int width, int height) {
        this(title);
        super.setSize(width, height);
    }
}
