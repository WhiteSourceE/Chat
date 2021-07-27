package chat.configs;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");

        initDB();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }

    private void initDB() {
        String username = "sa";
        String password = "";
        String url = "jdbc:h2:mem:testdb";
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS banned_ip");
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            statement.execute("CREATE TABLE banned_ip (id varchar (50), ip varchar(50), PRIMARY KEY (id));");
            statement.execute("CREATE TABLE users (id varchar (50), name varchar(50), admin bit not null, ip varchar (50), PRIMARY KEY (id));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
