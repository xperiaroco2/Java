package Listeners;

import Gui.Main;
import Gui.MyJTextField;
import com.sun.prism.paint.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by h on 18.04.2017.
 */
public class CalcTextFieldFocusListener implements FocusListener{

    private MyJTextField field;

    public CalcTextFieldFocusListener(MyJTextField field) {
        this.field = field;
    }


    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().equals(Main.INPUT_INT)){
            field.setText("");
            //field.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(field.getText().equals("")){
            field.setText(Main.INPUT_INT);

        }
    }
}
