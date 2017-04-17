import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaBot extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Yarik: AlcoBot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialogue;
    JCheckBox ai;
    JTextField message;
    Bot bot;

    public static void main(String[] args) {
        new JavaBot();
    }

    JavaBot(){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION,START_LOCATION,WINDOW_WIDTH,WINDOW_HEIGHT);

        dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(dialogue);

        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox("Ai");
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.SOUTH, bp);
        add(BorderLayout.CENTER, scrollPane);
        setVisible(true);
        bot = new Bot();
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(message.getText().trim().length() > 0){
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0,7) +
            bot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}
