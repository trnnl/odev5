package core.concretes;

import core.abstracts.MailValidatorService;

public class MailValidatorManager implements MailValidatorService {
    @Override
    public void sendVarificationMail() {
        System.out.println("Mail Bilgisi Gönderildi...");
    }
}
