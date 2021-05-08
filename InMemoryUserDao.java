package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class InMemoryUserDao implements UserDao {

    private List<User> users;

public InMemoryUserDao(List<User> users){
    this.users = users;

}


    @Override
    public void register(User user) {
    users.add(user);
        System.out.println(user.getName() + " isimli kullanıcı sisteme kayıt edildi..." );
    }

    @Override
    public void login(User user) {
        System.out.println("** Sisteme giriş yapıldı **" );
        System.out.println("HOŞ GELDİN");
        System.out.println(user.getName() +" "+ user.getLastName());

    }

    @Override
    public void logout(User user) {
        System.out.println("** Sistemden çıkış yapıldı **");

    }

    @Override
    public void getByMail(User user) {

        System.out.println("Email kontrol yapıldı...");

    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public boolean loginByCheck(User user) {


            return true;

    }

    @Override
    public boolean password(String password) {
        if(password.length()<5){
            return false;
        }
        return true;
    }
}
