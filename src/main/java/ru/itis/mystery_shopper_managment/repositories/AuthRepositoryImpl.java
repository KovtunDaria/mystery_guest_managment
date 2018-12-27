package ru.itis.mystery_shopper_managment.repositories;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.mystery_shopper_managment.models.Auth;
import ru.itis.mystery_shopper_managment.models.Guest;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class AuthRepositoryImpl implements AuthRepository {
    private JdbcTemplate template;

    //language=sql
    String SQL_FIND_BY_USER_ID =
            "SELECT * FROM auth WHERE guest_id=?";

    //language=sql
    String SQL_INSERT =
            "INSERT INTO auth(guest_id, cookie_value) VALUES (?, ?)";

    @SneakyThrows
    public AuthRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Auth model) {
        template.update(
                SQL_INSERT,
                model.getGuest().getId(),
                model.getValue().toString()
        );
    }

    @Override
    public Auth findOne(Long id) {
        return null;
    }

    @Override
    public void update(Auth model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Auth generateCookieForUser(Long userId) {
        Auth auth = Auth.builder()
                .value(UUID.randomUUID())
                .guest(Guest.builder().id(userId).build())
                .build();
        save(auth);
        return auth;
    }

    @Override
    public void deleteByValue(String value) {
        template.update(
                "DELETE FROM auth WHERE cookie_value=?",
                value
        );
    }
}
