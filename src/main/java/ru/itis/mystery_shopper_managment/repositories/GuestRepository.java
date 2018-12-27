package ru.itis.mystery_shopper_managment.repositories;

import ru.itis.mystery_shopper_managment.models.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {
    Guest getByEmail(String email);

    Guest getByCookie(String cookieValue);
}
