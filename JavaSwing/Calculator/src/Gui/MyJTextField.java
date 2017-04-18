package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyJTextField extends JTextField {

    public MyJTextField(String text, int coluumns){
        this(coluumns);
        super.setText(text);

    }

    public MyJTextField(int columns){
        super.setColumns(columns);
        super.setFont(new Font("Courier", Font.ITALIC,12));
        super.setForeground(Color.GRAY);
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                char a = e.getKeyChar();
                if (!Character.isDigit(a)){
                    e.consume();
                }
            }
        });
    }

    public MyJTextField(int columns, Color textColor){
        this(columns);
        super.setForeground(textColor);
    }
}
