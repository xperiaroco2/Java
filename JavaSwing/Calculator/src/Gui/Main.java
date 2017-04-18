package Gui;

import Listeners.ButtonListener;
import com.jtattoo.plaf.smart.SmartLookAndFeel;

import javax.swing.*;
import java.awt.*;


public class Main {


    private MyJButton buttonAdd;
    private MyJButton buttonSubtract;
    private MyJButton buttonDivide;
    private MyJButton buttonMultiply;

    private JLabel label1;
    private JLabel label2;
    private JLabel labelResult;

    private MyJTextField jtxt1;
    private MyJTextField jtxt2;
    private MyJTextField jtxtResult;

    private MyJPanel panel1;
    private MyJPanel panel2;
    private MyJPanel panel3;

    private MyJFrame frame;

    public static void main(String[] args){

        try{
            UIManager.setLookAndFeel(new SmartLookAndFeel());
        }catch (UnsupportedLookAndFeelException e){e.printStackTrace();}

        JFrame.setDefaultLookAndFeelDecorated(true);

        Main main = new Main();

        main.createLabels();
        main.createTextFields();
        main.createButtons();
        main.createPanels();
        main.createFrame();

    }

    private void createButtons(){
        buttonAdd = new MyJButton("Сложение");
        buttonSubtract = new MyJButton("Вычитание");
        buttonDivide = new MyJButton("Деление");
        buttonMultiply = new MyJButton("Умножение");
        buttonAdd.addActionListener(new ButtonListener(panel2));

    }

    private void createLabels(){
        label1 = new JLabel("Число 1");
        label2 = new JLabel("Число 2");
        labelResult = new JLabel("Результат");
    }

    private void createTextFields(){
        jtxt1 = new MyJTextField(10);
        jtxt2 = new MyJTextField(10);

        jtxtResult = new MyJTextField(15, Color.red);
        jtxtResult.setEditable(false);
        jtxtResult.setFocusable(false);
    }

    private void createPanels(){
        panel1 = new MyJPanel("panel1",100,100);
        panel1.setPreferredSize(new Dimension(200,50));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel2 = new MyJPanel("panel2", 100,100);
        panel2.setPreferredSize(new Dimension(200,50));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel3 = new MyJPanel("panel3", 100,100);
        panel3.setPreferredSize(new Dimension(200,50));
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel1.add(label1);
        panel1.add(jtxt1);
        panel1.add(label2);
        panel1.add(jtxt2);

        panel2.add(buttonAdd);
        panel2.add(buttonSubtract);
        panel2.add(buttonMultiply);
        panel2.add(buttonDivide);

        panel3.add(labelResult);
        panel3.add(jtxtResult);
    }

    private void createFrame(){
        frame = new MyJFrame("Калькулятор",430,200, new BorderLayout(2,2));
        frame.setResizable(false);

        frame.getContentPane().add(panel1,BorderLayout.NORTH);
        frame.getContentPane().add(panel2,BorderLayout.CENTER);
        frame.getContentPane().add(panel3,BorderLayout.SOUTH);

        frame.setVisible(true);
    }





}
