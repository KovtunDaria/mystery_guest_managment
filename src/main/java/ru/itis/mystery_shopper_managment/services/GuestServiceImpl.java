package ru.itis.mystery_shopper_managment.services;

import org.mindrot.jbcrypt.BCrypt;
import ru.itis.mystery_shopper_managment.forms.GuestForm;
import ru.itis.mystery_shopper_managment.forms.LoginForm;
import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.repositories.AuthRepository;
import ru.itis.mystery_shopper_managment.repositories.GuestRepository;

import java.util.UUID;

public class GuestServiceImpl implements GuestService {
    private GuestRepository guestRepository;
    private AuthRepository authRepository;

    public GuestServiceImpl(GuestRepository guestRepository, AuthRepository authRepository) {
        this.guestRepository = guestRepository;
        this.authRepository = authRepository;
    }

    @Override
    public void register(GuestForm guestForm) {

        String password = String.valueOf(UUID.randomUUID().hashCode());
        System.out.println("====================");
        System.out.println("PASSWORD: "+password);
        System.out.println("====================");

        String hash = BCrypt.hashpw(password, BCrypt.gensalt(10));

        Guest guest = Guest.builder()
                .name(guestForm.getName())
                .email(guestForm.getEmail())
                .city(guestForm.getCity())
                .passHash(hash)
                .build();

        guestRepository.save(guest);
    }

    @Override
    public Guest findById(Long id) {
        return guestRepository.findOne(id);
    }

    @Override
    public String authorize(LoginForm loginForm) {
        try {
            Guest guest = guestRepository.getByEmail(loginForm.getEmail());

            if (guest != null) {
                if (BCrypt.checkpw(loginForm.getPassword(), guest.getPassHash())) {
                    return authRepository.generateCookieForUser(guest.getId()).getValue().toString();
                }
            }
        } catch (Exception ignored) {}
        return null;
    }

    @Override
    public void logout(String cookieValue) {
        authRepository.deleteByValue(cookieValue);
    }

    @Override
    public Guest getByCookie(String cookieValue) {
        return guestRepository.getByCookie(cookieValue);
    }
}
