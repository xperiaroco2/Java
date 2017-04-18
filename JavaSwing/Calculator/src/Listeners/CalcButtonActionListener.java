package Listeners;

import Gui.MyJTextField;
import calc.CalcOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by h on 18.04.2017.
 */
public class CalcButtonActionListener implements ActionListener{

    private MyJTextField jtxt1;
    private MyJTextField jtxt2;
    private MyJTextField jtxtResult;

    public CalcButtonActionListener(MyJTextField jtxt1, MyJTextField jtxt2, MyJTextField jtxtResult){
        this.jtxt1 = jtxt1;
        this.jtxt2 = jtxt2;
        this.jtxtResult = jtxtResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)){
            return;
        }
        JButton button = (JButton) e.getSource();

        final double a = Double.parseDouble(jtxt1.getText());
        final double b = Double.parseDouble(jtxt2.getText());

        if(button.getActionCommand().equals("Сложение")){
            jtxtResult.setText(String.valueOf(CalcOperations.add(a,b)));
        }else if(button.getActionCommand().equals("Деление")){
            jtxtResult.setText(String.valueOf(CalcOperations.divide(a,b)));
        }else if(button.getActionCommand().equals("Вычитание")){
            jtxtResult.setText(String.valueOf(CalcOperations.subtract(a,b)));
        }else if(button.getActionCommand().equals("Умножение")){
            jtxtResult.setText(String.valueOf(CalcOperations.multiply(a,b)));
        }

    }
}
