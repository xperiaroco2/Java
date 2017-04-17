import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by h on 16.04.2017.
 */
public class SQLiteConnection {

    private static Connection connection;

    public static Connection getConnection(){

        try {
            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();

            String url = "jdbc:sqlite:D:/SQLite/MyDataBase.db";

           if(connection == null) connection = DriverManager.getConnection(url);

            return connection;

        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException e) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE,null,e);
        }

        return null;
    }
}
