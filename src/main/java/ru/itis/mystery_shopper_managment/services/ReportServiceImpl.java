package ru.itis.mystery_shopper_managment.services;

import ru.itis.mystery_shopper_managment.forms.ReportForm;
import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.models.Instructions;
import ru.itis.mystery_shopper_managment.models.Report;
import ru.itis.mystery_shopper_managment.repositories.InstructionsRepository;
import ru.itis.mystery_shopper_managment.repositories.ReportRepository;

public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;
    private InstructionsRepository instructionsRepository;

    public ReportServiceImpl(ReportRepository reportRepository, InstructionsRepository instructionsRepository) {
        this.reportRepository = reportRepository;
        this.instructionsRepository = instructionsRepository;
    }

    @Override
    public void saveReport(ReportForm reportForm, Guest guest) {
        Instructions instructions = instructionsRepository.findOne(reportForm.getInstructionsId());
        Report report = Report.builder()
                .instruction(instructions)
                .coffeeshop(instructions.getCoffeeshop())
                .guest(guest)
                .queueTime(Long.valueOf(reportForm.getMinutesInQueue()))
                .waitTime(Long.valueOf(reportForm.getMinutesWaitingForDrink()))
                .baristaComment(reportForm.getBaristaComment())
                .toiletComment(reportForm.getToiletComment())
                .roomComment(reportForm.getRoomComment())
                .drinkComment(reportForm.getDrinkComment())
                .build();
        reportRepository.save(report);
    }
}
