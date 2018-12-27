package ru.itis.mystery_shopper_managment.servlets;

import ru.itis.mystery_shopper_managment.Data;
import ru.itis.mystery_shopper_managment.forms.GuestForm;
import ru.itis.mystery_shopper_managment.repositories.AuthRepositoryImpl;
import ru.itis.mystery_shopper_managment.repositories.GuestRepositoryImpl;
import ru.itis.mystery_shopper_managment.services.GuestService;
import ru.itis.mystery_shopper_managment.services.GuestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private GuestService guestService;

    @Override
    public void init() {
        DataSource dataSource = Data.getDefaultDataSource();
        GuestRepositoryImpl guestRepository = new GuestRepositoryImpl(dataSource);
        AuthRepositoryImpl authRepository = new AuthRepositoryImpl(dataSource);
        guestService = new GuestServiceImpl(guestRepository, authRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        GuestForm guestForm = GuestForm.builder()
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .city(req.getParameter("city")).build();

        guestService.register(guestForm);

        resp.sendRedirect("/index");
    }
}