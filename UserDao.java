package dataAccess.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserDao
{
    void register(User user);
    void login(User user);
    void logout(User user);
    void getByMail(User user);
    List<User> getAll();
    boolean loginByCheck(User user);
    boolean password(String password);

}
