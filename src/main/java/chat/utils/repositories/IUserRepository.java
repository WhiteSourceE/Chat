package chat.utils.repositories;

import chat.UserData;

public interface IUserRepository {
    UserData getUser(String name);
    void saveUser(UserData userData);
}
