package ru.itis.mystery_shopper_managment.repositories;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.mystery_shopper_managment.models.Card;

import javax.sql.DataSource;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {

    private JdbcTemplate template;

    //language=sql
    private static final String SQL_CREATE_ROW =
            "INSERT INTO card (activated) " +
                    "VALUES (?)";

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM card WHERE id = ?";

    //language=sql
    private static final String SQL_FIND_BY_GUEST_ID =
            "SELECT * FROM card WHERE owner = ?";

    @SneakyThrows
    public CardRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);

    }

    @Override
    @SneakyThrows
    public void save(Card model) {
        template.update(SQL_CREATE_ROW, model.getActivated());
    }

    @Override
    @SneakyThrows
    public Card findOne(Long id) {
        return template.queryForObject(
                SQL_FIND_BY_ID,
                (rs, i) -> Card.builder()
                        .id(rs.getLong("id"))
                        .balance(rs.getInt("balance"))
                        .activated(rs.getBoolean("activated"))
                        .build(),
                id);
    }

    @Override
    public void update(Card model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    @Override
    public Card readByGuestId(Long guestId) {
        return template.queryForObject(
                SQL_FIND_BY_GUEST_ID,
                (rs, i) -> Card.builder()
                        .id(rs.getLong("id"))
                        .balance(rs.getInt("balance"))
                        .activated(rs.getBoolean("activated"))
                        .build(),
                guestId);

    }
}
