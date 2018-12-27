package ru.itis.mystery_shopper_managment.servlets;

import ru.itis.mystery_shopper_managment.Data;
import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.repositories.*;
import ru.itis.mystery_shopper_managment.services.GuestService;
import ru.itis.mystery_shopper_managment.services.GuestServiceImpl;
import ru.itis.mystery_shopper_managment.services.InstructionsService;
import ru.itis.mystery_shopper_managment.services.InstructionsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet {
    private GuestService guestService;
    private InstructionsService instructionsService;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = Data.getDefaultDataSource();
        GuestRepository guestRepository = new GuestRepositoryImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        InstructionsRepository instructionsRepository = new InstructionsRepositoryImpl(dataSource);
        guestService = new GuestServiceImpl(guestRepository, authRepository);
        instructionsService = new InstructionsServiceImpl(instructionsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Guest guest = Data.getGuest(req, guestService);

        if (guest == null) {
            resp.sendRedirect("/login");
        } else {
            guest.setInstructions(instructionsService.getInstructionsForGuest(guest));
            req.setAttribute("guest", guest);
            req.getRequestDispatcher("/ftl/cabinet.ftl").forward(req, resp);
        }
    }
}
