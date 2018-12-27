package ru.itis.mystery_shopper_managment.services;

import ru.itis.mystery_shopper_managment.forms.ReportForm;
import ru.itis.mystery_shopper_managment.models.Guest;

public interface ReportService {
    void saveReport(ReportForm reportForm, Guest guest);
}
