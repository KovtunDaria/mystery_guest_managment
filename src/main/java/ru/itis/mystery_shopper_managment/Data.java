package ru.itis.mystery_shopper_managment;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.mystery_shopper_managment.models.Guest;
import ru.itis.mystery_shopper_managment.services.GuestService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Data {
    public static DriverManagerDataSource getDefaultDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("QWERTY007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/db_11_702");
        return dataSource;
    }

    public static Guest getGuest(HttpServletRequest req, GuestService guestService) {
        Cookie[] cookies = req.getCookies();
        String cookieValue = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("skuratov")) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }

            if (cookieValue != null) {
                return guestService.getByCookie(cookieValue);
            }
        }

        return null;
    }
}
