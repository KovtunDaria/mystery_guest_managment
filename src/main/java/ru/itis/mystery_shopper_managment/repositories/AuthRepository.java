package ru.itis.mystery_shopper_managment.repositories;

import ru.itis.mystery_shopper_managment.models.Auth;

public interface AuthRepository extends CrudRepository<Auth, Long> {
    Auth generateCookieForUser(Long userId);

    void deleteByValue(String value);
}
