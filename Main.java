import business.abstracts.UserService;
import business.concretes.UseManager;
import core.GoogleLoginAdapterManager;
import core.abstracts.InputVerificationService;
import core.concretes.InpuVerificationManager;
import core.concretes.MailValidatorManager;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User turan = new User("1","Can","Turan","canturan@gmail.com","123456");
        User ali = new User("2","Ali","Veli","aliveli@gmal.com","456789");
        User erkan = new User("3","Erkan","Arık","erkanarik@gmail.com","9854");
        User ismet = new User("4","İsmet","Yıldız","ismetyildiz@gmail.com","654321");
        User ahmet = new User("5","Ahmet","Ceylan","ahmetceylanohotmail.com","654321");
        List<User> users = new ArrayList<User>();
        users.add(turan);
        users.add(ali);
        users.add(erkan);
        users.add(ismet);
        //---------------------------------------------------------------------------------------------
                UserDao userDao = new InMemoryUserDao(users);
            UserService userService = new UseManager(userDao,new InpuVerificationManager(),new MailValidatorManager(),new GoogleLoginAdapterManager());


            userService.register(turan);
            System.out.println();
            userService.register(ali);
            System.out.println();
            userService.login(ismet);
            System.out.println();
            userService.register(erkan);
            System.out.println();
            userService.register(ahmet);





    }
}
