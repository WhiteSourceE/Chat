package chat.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConfiguration  {
    private static String username = "sa";
    private static String password = "";
    private static String url = "jdbc:h2:mem:testdb";

    private static Connection JDBCConnection;

    public static Connection getJDBCConnection() {

        if (JDBCConnection == null) {
            try {
                Class.forName ("org.h2.Driver");
                JDBCConnection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JDBCConnection;
    }


}
