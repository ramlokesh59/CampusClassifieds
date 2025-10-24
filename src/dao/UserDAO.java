package dao;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static List<User> users = new ArrayList<>();

    public User login(String username, String password) {
        // Dummy login: just return a user object
        return new User("Demo User");
    }

    public boolean register(User user) {
        users.add(user);
        return true;
    }
}
