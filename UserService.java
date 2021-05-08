package business.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserService {
    void register(User user);
    void login(User user);
    List<User> getAll();
}
