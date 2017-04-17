//import javax.swing.*;
//import javax.swing.event.TableModelEvent;
//import javax.swing.event.TableModelListener;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Created by h on 16.04.2017.
// */
//public class Start {
//public static final String TABLE_NAME = "topcar";
//    public static void main(String[] args) {
//        try {
//            Connection connection = SQLiteConnection.getConnection();
//
//            final MyTableModel mod = new MyTableModel(connection, TABLE_NAME);
//
//            JTable jTable = new JTable(mod);
//
//            TableRowSorter<TableModel> sorter = new TableRowSorter<>(mod);
//            jTable.setRowSorter(sorter);
//            //sorter.setComparator(2, new MyComparator());
//            MyTableRenderer cellRenderer = new MyTableRenderer();
//            jTable.setDefaultRenderer(Object.class,cellRenderer);
//
//            JScrollPane scrollPane = new JScrollPane(jTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
//                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//            JFrame frame = new JFrame("Загрузка данных");
//            frame.setSize(500,400);
//            frame.setLocationRelativeTo(null);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            JButton refreshButton = new JButton("Загрузить в базу данных");
//
//            JPanel panel = new JPanel();
//            panel.add(refreshButton);
//            panel.add(scrollPane);
//
//            frame.getContentPane().add(panel);
//
//            frame.addWindowStateListener(new WindowAdapter() {
//                @Override
//                public void windowClosed(WindowEvent e) {
//                    if(connection!=null)try {
//                        connection.close();
//                    }catch (SQLException ex){
//                        Logger.getLogger(JTableEdit.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
//
//            refreshButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if(mod.updateDB(TABLE_NAME)) JOptionPane.showMessageDialog(null, "Данные успешно обновлены!");
//                    else JOptionPane.showMessageDialog(null,"Ошибка при обновлении данных!");
//
//                }
//            });
//
//            jTable.getModel().addTableModelListener(new TableModelListener() {
//                @Override
//                public void tableChanged(TableModelEvent e) {
//                    int row = e.getFirstRow();
//
//                    int column = e.getColumn();
//
//                    System.out.println(row+" "+column);
//
//                    TableModel model = (TableModel) e.getSource();
//                    String columnName = model.getColumnName(column);
//                    Object data = model.getValueAt(row,column);
//                }
//            });
//            frame.pack();
//            frame.setVisible(true);
//
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
