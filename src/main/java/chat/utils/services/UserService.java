package chat.utils.services;

import chat.UserData;
import chat.utils.repositories.IUserRepository;
import chat.utils.repositories.UserRepository;
import chat.utils.repositories.UserRepositorySafe;

public class UserService {
    private final IUserRepository userRepository = new UserRepository();
    private final IUserRepository userRepositorySafe = new UserRepositorySafe();

    public UserData loadUser(String name){

        if (name.charAt(0) == 'a') {
            return userRepository.getUser(name);
        } else {
            return userRepositorySafe.getUser(name);
        }

    }

    public void saveUser(UserData data){
        if (data.isAdmin()) {
            userRepository.saveUser(data);
        } else {
            userRepositorySafe.saveUser(data);
        }
    }
}
