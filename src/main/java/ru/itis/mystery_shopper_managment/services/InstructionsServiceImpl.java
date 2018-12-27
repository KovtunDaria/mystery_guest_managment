package ru.itis.mystery_shopper_managment.services;

import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.models.Instructions;
import ru.itis.mystery_shopper_managment.models.Status;
import ru.itis.mystery_shopper_managment.repositories.InstructionsRepository;

import java.util.List;

public class InstructionsServiceImpl implements InstructionsService {
    private InstructionsRepository instructionsRepository;

    public InstructionsServiceImpl(InstructionsRepository instructionsRepository) {
        this.instructionsRepository = instructionsRepository;
    }

    @Override
    public List<Instructions> getInstructionsForGuest(Guest guest) {
        return instructionsRepository.findAllForGuest(guest);
    }

    @Override
    public void setStatus(Instructions instructions, Status status) {
        instructions.setStatus(status);
        instructionsRepository.update(instructions);
    }

    @Override
    public Instructions get(Long id) {
        return instructionsRepository.findOne(id);
    }
}
