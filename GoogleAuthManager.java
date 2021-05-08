package googleAuth;

public class GoogleAuthManager {
    public boolean isValid(String eMail, String password){
        if(eMail.endsWith("gmail.com")){

            return true;
        }
        else{
            return false;
        }

    }
}
