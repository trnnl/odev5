package business.concretes;

import business.abstracts.UserService;
import core.GoogleLoginAdapterManager;
import core.abstracts.InputVerificationService;
import core.abstracts.MailValidatorService;
import core.abstracts.OutLoginAdapterService;
import core.concretes.MailValidatorManager;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class UseManager implements UserService {

    private UserDao userDao;
    private InputVerificationService inputVerificationService;
    private MailValidatorService mailValidatorService;
    private GoogleLoginAdapterManager googleLoginAdapterManager;

    public UseManager(UserDao userDao, InputVerificationService inputVerificationService, MailValidatorService mailValidatorService, GoogleLoginAdapterManager googleLoginAdapterManager) {
        this.userDao = userDao;
        this.inputVerificationService = inputVerificationService;
        this.mailValidatorService = mailValidatorService;
        this.googleLoginAdapterManager = googleLoginAdapterManager;
    }

    @Override
    public void register(User user) {
        if(googleLoginAdapterManager.isResult() ==true &&userDao.password(user.getPassword())==true){
            System.out.println(user.geteMail() +" ile google ile kayıt olundu...");
            userDao.register(user);
            mailValidatorService.sendVarificationMail();

        }
        else if(inputVerificationService.isValid(user)==true && userDao.password(user.getPassword())==true){
            System.out.println(user.geteMail() + " ile kayıt olundu");
            userDao.register(user);
            mailValidatorService.sendVarificationMail();
        }
        else if(inputVerificationService.isValid(user) == false){
            userDao.getByMail(user);
            System.out.println("Hatalı email girdiniz...");
        }

        else if(userDao.password(user.getPassword())==false){
            System.out.println("Şifreniz en az 6 karakterli olmalıdır...");

        }
        else{
            userDao.register(user);
        }

    }

    @Override
    public void login(User user) {
        if(userDao.loginByCheck(user)){
            userDao.login(user);
        }
        else{
            System.out.println("false");
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
