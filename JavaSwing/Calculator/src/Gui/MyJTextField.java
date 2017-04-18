package Gui;

import javax.swing.*;
import java.awt.*;

public class MyJTextField extends JTextField {

    public MyJTextField(String text, int coluumns){
        this(coluumns);
        super.setText(text);
    }

    public MyJTextField(int columns){
        super.setColumns(columns);
        super.setFont(new Font("Courier", Font.ITALIC,12));
        super.setForeground(Color.GRAY);
    }

    public MyJTextField(int columns, Color textColor){
        super.setColumns(columns);
        super.setFont(new Font("Courier", Font.ITALIC, 12));
        super.setForeground(textColor);
    }
}
