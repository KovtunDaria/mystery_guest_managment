package ru.itis.mystery_shopper_managment.servlets;

import ru.itis.mystery_shopper_managment.Data;
import ru.itis.mystery_shopper_managment.forms.LoginForm;
import ru.itis.mystery_shopper_managment.forms.ReportForm;
import ru.itis.mystery_shopper_managment.models.Instructions;
import ru.itis.mystery_shopper_managment.models.Status;
import ru.itis.mystery_shopper_managment.repositories.*;
import ru.itis.mystery_shopper_managment.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    private InstructionsService instructionsService;
    private ReportService reportService;
    private GuestService guestService;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = Data.getDefaultDataSource();
        InstructionsRepository instructionsRepository = new InstructionsRepositoryImpl(dataSource);
        ReportRepository reportRepository = new ReportRepositoryImpl(dataSource);
        instructionsService = new InstructionsServiceImpl(instructionsRepository);
        reportService = new ReportServiceImpl(reportRepository, instructionsRepository);
        GuestRepository guestRepository = new GuestRepositoryImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        guestService = new GuestServiceImpl(guestRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String instructionId = req.getParameter("id");

        if (instructionId != null) {
            Instructions instructions = instructionsService.get(Long.parseLong(instructionId));
            req.setAttribute("instructions", instructions);
            req.getRequestDispatcher("/ftl/report.ftl").forward(req, resp);
        } else {
            resp.setStatus(400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        ReportForm reportForm = ReportForm.builder()
                .minutesInQueue(Integer.valueOf(req.getParameter("queue_minutes")))
                .minutesWaitingForDrink(Integer.valueOf(req.getParameter("wait_minutes")))
                .baristaComment(req.getParameter("barista_comment"))
                .toiletComment(req.getParameter("toilet_comment"))
                .roomComment(req.getParameter("room_comment"))
                .drinkComment(req.getParameter("drink_comment"))
                .instructionsId(Long.parseLong(req.getParameter("inst_id")))
                .build();

        reportService.saveReport(reportForm, Data.getGuest(req, guestService));
        instructionsService.setStatus(instructionsService.get(reportForm.getInstructionsId()), Status.awaiting);
        resp.sendRedirect("/cabinet");
    }


}
