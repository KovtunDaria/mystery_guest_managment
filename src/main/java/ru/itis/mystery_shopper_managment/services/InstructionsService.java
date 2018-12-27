package ru.itis.mystery_shopper_managment.services;

import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.models.Instructions;
import ru.itis.mystery_shopper_managment.models.Status;

import java.util.List;

public interface InstructionsService {
    List<Instructions> getInstructionsForGuest(Guest guest);

    void setStatus(Instructions instructions, Status status);

    Instructions get(Long id);
}
