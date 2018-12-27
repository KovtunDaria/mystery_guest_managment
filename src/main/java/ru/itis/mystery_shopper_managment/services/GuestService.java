package ru.itis.mystery_shopper_managment.services;

import ru.itis.mystery_shopper_managment.forms.GuestForm;
import ru.itis.mystery_shopper_managment.forms.LoginForm;
import ru.itis.mystery_shopper_managment.models.Card;
import ru.itis.mystery_shopper_managment.models.Guest;

public interface GuestService {
    void register(GuestForm guestForm);

    String authorize(LoginForm loginForm);

    void logout(String cookieValue);

    Guest getByCookie(String cookieValue);

    Guest findById(Long id);
}
