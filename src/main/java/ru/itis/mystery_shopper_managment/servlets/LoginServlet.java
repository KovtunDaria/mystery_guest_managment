package ru.itis.mystery_shopper_managment.servlets;

import ru.itis.mystery_shopper_managment.Data;
import ru.itis.mystery_shopper_managment.forms.GuestForm;
import ru.itis.mystery_shopper_managment.forms.LoginForm;
import ru.itis.mystery_shopper_managment.repositories.AuthRepository;
import ru.itis.mystery_shopper_managment.repositories.AuthRepositoryImpl;
import ru.itis.mystery_shopper_managment.repositories.GuestRepositoryImpl;
import ru.itis.mystery_shopper_managment.services.GuestService;
import ru.itis.mystery_shopper_managment.services.GuestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private GuestService guestService;

    @Override
    public void init() throws ServletException {
        DataSource dataSource = Data.getDefaultDataSource();
        GuestRepositoryImpl guestRepository = new GuestRepositoryImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        guestService = new GuestServiceImpl(guestRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ftl/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        LoginForm loginForm = LoginForm.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password")).build();

        String cookie = guestService.authorize(loginForm);

        if (cookie != null) {
            resp.addCookie(new Cookie("skuratov", cookie));
            resp.sendRedirect("/cabinet");
        } else {
            resp.sendRedirect("/login");
        }

    }
}