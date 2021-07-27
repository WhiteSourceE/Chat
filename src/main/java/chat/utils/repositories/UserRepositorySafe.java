package chat.utils.repositories;

import chat.UserData;
import chat.configs.DataBaseConfiguration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import static chat.utils.SqlSanitizer.escapeSQLApache;

public class UserRepositorySafe implements IUserRepository{
    public UserData getUser(String name){
        try (Statement statement = DataBaseConfiguration.getJDBCConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name,ip,admin from users where name='"+escapeSQLApache(name)+"'");
            if(resultSet.next()){
                UserData userData = new UserData();
                userData.setName(resultSet.getString("name"));
                userData.setIp(resultSet.getString("ip"));
                if (resultSet.getBoolean("admin")) {
                    userData.setAdmin();
                } else {
                    userData.unsetAdmin();
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveUser(UserData userData) {
        String sql = "INSERT INTO users(id, name, ip, admin) value ('%s','%s','%s',%d)";
        try (Statement statement = DataBaseConfiguration.getJDBCConnection().createStatement()) {
            statement.execute(String.format(sql, UUID.randomUUID().toString(), escapeSQLApache(userData.getName()), escapeSQLApache(userData.getIp()), userData.isAdmin()));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
