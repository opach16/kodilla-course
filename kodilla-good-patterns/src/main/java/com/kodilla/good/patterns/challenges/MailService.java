package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println(String.format("An e-mail has been sent to %s", user.getName()));
    }
}
