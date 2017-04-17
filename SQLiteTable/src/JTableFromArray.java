import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URI;
import java.net.URL;

public class JTableFromArray {

    public static void main(String[] args) {

        Object[] columnHeaders = {"Фамилия", "Имя",  "Отчество","email"};

        Object[][] tableData = {
            {"Иванов", "Иван", "Иванович", "test@mail.ru"},
            {"Олегов", "Олег", "Олегович", "test2@mail.ru"},
            {"Белоусов", "Дмитрий", "Вадимович", "test3@mail.ru"},
            {"Дмитренко", "Данилл", "Олегович", "test4@mail.ru"},
            {"Белоусов", "Тимур", "Вадимович", "test5@mail.ru"}
        };

        JFrame frame = new JFrame("JTableExample");

        frame.getContentPane().setLayout(new FlowLayout());

        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTable jTableFIO = new JTable(tableData, columnHeaders);

        jTableFIO.setRowHeight(30);

        jTableFIO.setDefaultRenderer(Object.class, new MyTableRenderer());

        jTableFIO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1){
                    JTable target = (JTable) e.getSource();
                    String value = target.getValueAt(target.getSelectedRow(), target.getSelectedColumn()).toString();

                    try {
                        if(value.contains("@")) Desktop.getDesktop().mail(new URI("mailto:"+value+"?SUBJECT=Служебное%20письмо&body=Текст%20письма"));


                    }catch (Exception ex){ex.printStackTrace();}
                }
            }
        });

        jTableFIO.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if(target.columnAtPoint(e.getPoint())==3){
                    target.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }else {
                    target.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });

        JScrollPane scroll = new JScrollPane(jTableFIO);

        jTableFIO.setPreferredScrollableViewportSize(new Dimension(400,200));

        frame.getContentPane().add(scroll);

        frame.setVisible(true);
    }
}