import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by h on 16.04.2017.
 */
public class MyTableModel extends AbstractTableModel {

    private static Connection connection;

    private Object[][] contents;
    private String[] columnNames;
    private Class[] columnClasses;

    public MyTableModel(Connection connection, String tableName) throws SQLException{
        super();
        getTableContents(connection, tableName);
    }

    public boolean updateDB(String tableName){
        ArrayList<String> sqlList = new ArrayList<>();
        for(int i = 0; i < contents.length; i++){
            Object[] objects = contents[i];
            sqlList.add("update " + tableName + " set name='" + objects[i] + "'");
        }

        Statement statement = null;

        try{
            statement = connection.createStatement();
            for(String sql: sqlList){
                statement.executeQuery(sql);
            }
        }catch (SQLException ex){
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }finally {
            try{
                if(statement!=null)statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE,null,ex);
            }
        }

        return true;
    }

    private void getTableContents(Connection connection, String tableName) throws SQLException{
        DatabaseMetaData meta = connection.getMetaData();

        ResultSet resultSet = meta.getColumns(null,null,tableName,null);

        ArrayList colNamesList = new ArrayList();
        ArrayList colTypesList = new ArrayList();

        while (resultSet.next()){

            colNamesList.add(resultSet.getString("COLUMN_NAME"));

            int dbType = resultSet.getInt("DATA_TYPE");

            switch (dbType){
                case Types.INTEGER:
                    colTypesList.add(Integer.class);
                    break;
                case Types.FLOAT:
                    colTypesList.add(Float.class);
                    break;
                case Types.DOUBLE:
                case Types.REAL:
                    colTypesList.add(Double.class);
                    break;
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    colTypesList.add(java.sql.Date.class);
                    break;
                default:
                    colTypesList.add(String.class);
                    break;

            }

        }

        columnNames = new String[colNamesList.size()];
        colNamesList.toArray(columnNames);

        columnClasses = new Class[colTypesList.size()];
        colTypesList.toArray(columnClasses);

        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM " + tableName);

        ArrayList rowList = new ArrayList();

        while (resultSet.next()){
            ArrayList cellList = new ArrayList();

            for(int i = 0; i < columnClasses.length;i++){
                Object cellValue = null;

                if(columnClasses[i] == String.class) cellValue = resultSet.getString(columnNames[i]);
                else if(columnClasses[i] == Integer.class) cellValue = resultSet.getInt(columnNames[i]);
                else if(columnClasses[i] == Float.class) cellValue = resultSet.getInt(columnNames[i]);
                else if(columnClasses[i] == Double.class) cellValue = resultSet.getDouble(columnNames[i]);
                else if(columnClasses[i] == java.sql.Date.class) cellValue = resultSet.getDate(columnNames[i]);
                else System.out.println("Не могу определить тип поля" + columnNames[i]);

                cellList.add(cellValue);
            }

            Object[] cells = cellList.toArray();
            rowList.add(cells);
        }

        contents = new Object[rowList.size()][];
        for (int i = 0; i < contents.length ; i++) {
            contents[i] = (Object[]) rowList.get(i);
        }

        resultSet.close();
        statement.close();
    }

    @Override
    public int getRowCount() {
        return contents.length;
    }

    @Override
    public int getColumnCount() {
        if(contents.length == 0)
            return 0;
        else return contents[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return contents[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        contents[rowIndex][columnIndex] = aValue;

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if( columnIndex == 0){
            return false;
        }
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
