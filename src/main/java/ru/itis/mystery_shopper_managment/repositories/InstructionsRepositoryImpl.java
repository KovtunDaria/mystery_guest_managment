package ru.itis.mystery_shopper_managment.repositories;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.mystery_shopper_managment.models.*;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class InstructionsRepositoryImpl implements InstructionsRepository {
    private JdbcTemplate template;

    @SneakyThrows
    public InstructionsRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);

    }

    //language=sql
    private final String SQL_UPDATE_STATUS =
            "UPDATE instructions " +
                    "SET status=? " +
                    "WHERE id=?";

    //language=sql
    private final String SQL_GET_INSTRUCTIONS_FOR_GUEST =
            "SELECT * " +
                    "FROM (SELECT i.id, i.date, d.name, c.id as cs_id, c.address, i.status " +
                    "      FROM instructions i " +
                    "             JOIN drink d ON i.drink_id = d.id " +
                    "             JOIN coffeeshop c on i.coffeeshop_id = c.id " +
                    "      WHERE i.guest_id=?) t " +
                    "ORDER BY CASE " +
                    "           WHEN status = 'free' THEN 1 " +
                    "           WHEN status = 'taken' THEN 2 " +
                    "           WHEN status = 'awaiting' THEN 3 " +
                    "           WHEN status = 'completed' THEN 4 " +
                    "           WHEN status = 'failed' THEN 5 " +
                    "           ELSE 6 " +
                    "           END;";

    //language=sql
    private final String SQL_GET_INSTRUCTIONS =
            "SELECT i.id, i.date, d.name, c.id as cs_id, c.address, i.status " +
                    "FROM instructions i " +
                    "JOIN drink d on i.drink_id = d.id " +
                    "JOIN coffeeshop c on i.coffeeshop_id = c.id " +
                    "WHERE i.id=?;";

    private RowMapper<Instructions> instructionsRowMapper =
            (rs, i) -> Instructions.builder()
                    .id(rs.getLong("id"))
                    .drink(Drink.builder().name(rs.getString("name")).build())
                    .coffeeshop(Coffeeshop.builder().id(rs.getLong("cs_id")).address(rs.getString("address")).build())
                    .status(Status.valueOf(rs.getString("status")))
                    .build();

    @Override
    public void save(Instructions model) {

    }

    @Override
    public Instructions findOne(Long id) {
        return template.queryForObject(
                SQL_GET_INSTRUCTIONS,
                instructionsRowMapper,
                id
        );
    }

    @Override
    public void update(Instructions model) {
        template.update(
                SQL_UPDATE_STATUS,
                model.getStatus().name(),
                model.getId()
        );
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Instructions> findAll() {
        return null;
    }

    @Override
    public List<Instructions> findAllForGuest(Guest guest) {
        return template.query(
                SQL_GET_INSTRUCTIONS_FOR_GUEST,
                instructionsRowMapper,
                guest.getId()
        );
    }
}
