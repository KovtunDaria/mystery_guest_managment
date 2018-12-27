package ru.itis.mystery_shopper_managment.repositories;

import ru.itis.mystery_shopper_managment.models.Card;

public interface CardRepository extends CrudRepository<Card, Long> {
    Card readByGuestId(Long guestId);

}
