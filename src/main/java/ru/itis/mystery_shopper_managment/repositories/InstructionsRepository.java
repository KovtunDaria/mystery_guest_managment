package ru.itis.mystery_shopper_managment.repositories;

import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.models.Instructions;

import java.util.List;

public interface InstructionsRepository extends CrudRepository<Instructions, Long> {
    List<Instructions> findAllForGuest(Guest guest);
}
