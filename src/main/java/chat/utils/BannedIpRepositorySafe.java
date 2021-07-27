package chat.utils;

import chat.configs.DataBaseConfiguration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static chat.utils.SqlSanitizer.encodeSQL;

public class BannedIpRepositorySafe {

    public static void save(String ip) {
        try (Statement statement = DataBaseConfiguration.getJDBCConnection().createStatement()) {
            statement.execute("INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + encodeSQL(ip) + "')");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static List<String> load() {
        List<String> ips = new ArrayList<>();
        try (Statement statement = DataBaseConfiguration.getJDBCConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT ip from banned_ip");
            while (resultSet.next()) {
                ips.add(resultSet.getString("ip"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return ips;
    }

    public static boolean isBanned(String ip) {
        List<String> ips = new ArrayList<>();
        try (Statement statement = DataBaseConfiguration.getJDBCConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT ip from banned_ip where ip='" + encodeSQL(ip) + "'");
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static void delete(String ip) {
        String result = null;
        try (Statement statement = DataBaseConfiguration.getJDBCConnection().createStatement()) {
            statement.execute("DELETE FROM banned_ip where ip='" + encodeSQL(ip) + "'");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
