package ru.itis.mystery_shopper_managment.servlets;

import ru.itis.mystery_shopper_managment.Data;
import ru.itis.mystery_shopper_managment.models.Instructions;
import ru.itis.mystery_shopper_managment.models.Status;
import ru.itis.mystery_shopper_managment.repositories.*;
import ru.itis.mystery_shopper_managment.services.GuestServiceImpl;
import ru.itis.mystery_shopper_managment.services.InstructionsService;
import ru.itis.mystery_shopper_managment.services.InstructionsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/take")
public class TakeServlet extends HttpServlet {
    private InstructionsService instructionsService;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = Data.getDefaultDataSource();
        InstructionsRepository instructionsRepository = new InstructionsRepositoryImpl(dataSource);
        instructionsService = new InstructionsServiceImpl(instructionsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String instructionId = req.getParameter("id");

        if (instructionId != null) {
            instructionsService.setStatus(
                    Instructions.builder()
                            .id(Long.parseLong(instructionId))
                            .build(),
                    Status.taken
            );
            resp.sendRedirect("/cabinet");
        } else {
            resp.setStatus(400);
        }
    }
}
