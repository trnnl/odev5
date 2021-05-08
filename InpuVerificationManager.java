package core.concretes;

import core.abstracts.InputVerificationService;
import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InpuVerificationManager implements InputVerificationService {
    @Override
    public boolean isValid(User user){

        Pattern pattern = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
        Matcher matcher = pattern.matcher(user.geteMail());
        boolean matchFound = matcher.find();
        if(!user.geteMail().isEmpty() && matchFound){
            return true;
        }
        else{
            return false;
        }
    }
}
