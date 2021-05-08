package core;

import core.abstracts.OutLoginAdapterService;
import entities.concretes.User;
import googleAuth.GoogleAuthManager;

public class GoogleLoginAdapterManager implements OutLoginAdapterService {

boolean result= false;




    @Override
    public void isValid(User user) {
        GoogleAuthManager googleAuthManager= new GoogleAuthManager();
        this.result=googleAuthManager.isValid(user.geteMail(), user.getPassword());


    }
    public boolean isResult() {
        return result;
    }
}
