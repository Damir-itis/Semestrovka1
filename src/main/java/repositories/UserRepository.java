package repositories;

import model.User;

public interface UserRepository {
    boolean saveUser(String username, String password);
    int getUserId(String username);
    User getUserByID(int id);
    User getUserByName(String username);
}
