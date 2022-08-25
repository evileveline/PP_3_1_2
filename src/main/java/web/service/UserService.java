package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> allUsers ();
    User getUserById (int id);
    void addUser (User user);
    void deleteUserById (int id);
    void updateUser (User user);
    User passwordCoder(User user);
}