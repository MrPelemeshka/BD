import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBase {
    private static String DB_URL = "jdbc:postgresql://localhost:5432/Cakes";
    private static boolean isCreated = false;
    private static Connection connection;

    public static Connection getConnection() {
        if (isCreated == true) {
            return connection;
        } else {
            String login = new String("postgres");
            String pass = "1811";
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
            }
            connection = null;
            try {
                connection = DriverManager.getConnection(DB_URL, login, pass);
            } catch (SQLException e) {
            }
            isCreated = true;
            return connection;
        }
    }
}
