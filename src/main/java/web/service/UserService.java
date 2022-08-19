package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> allUsers ();
    User getUserById (long id);
    void addUser (User user);
    void deleteUserById (long id);
    void updateUser (User user);
    User passwordCoder(User user);
}