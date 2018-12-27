package ru.itis.mystery_shopper_managment.servlets;

import ru.itis.mystery_shopper_managment.Data;
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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

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
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Cookie[] cookies = req.getCookies();
        String oldCookie = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("skuratov")) {
                    oldCookie = cookie.getValue();
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
            }

            if (oldCookie != null) {
                guestService.logout(oldCookie);
            }
        }

        resp.sendRedirect("/index");
    }
}
