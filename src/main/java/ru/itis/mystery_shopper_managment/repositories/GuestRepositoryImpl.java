package ru.itis.mystery_shopper_managment.repositories;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.mystery_shopper_managment.models.Card;
import ru.itis.mystery_shopper_managment.models.Guest;

import javax.sql.DataSource;
import java.util.List;

public class GuestRepositoryImpl implements GuestRepository {

    private JdbcTemplate template;

    //language=sql
    private static final String SQL_CREATE_ROW =
            "INSERT INTO guest (\"name\", email, city, pass_hash) " +
                    "VALUES (?, ?, ?, ?)";

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM guest WHERE id = ?";


    //language=sql
    private static final String SQL_FIND_BY_EMAIL =
            "SELECT * FROM guest WHERE email = ?";

    //language=sql
    private static final String SQL_ASSIGN_CARD =
            "UPDATE guest SET card_id=? WHERE id=?;" +
                    "UPDATE card SET owner=? WHERE id=?;";

    //language=sql
    private static final String SQL_FIND_BY_COOKIE =
            "SELECT g.id, g.name, g.card_id, c.balance, c.activated " +
                    "FROM guest g " +
                    "       JOIN auth a ON g.id = a.guest_id " +
                    "       LEFT OUTER JOIN card c ON c.id = g.card_id " +
                    "WHERE a.cookie_value=?;";

    @SneakyThrows
    public GuestRepositoryImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    @SneakyThrows
    public void save(Guest model) {
        template.update(SQL_CREATE_ROW,
                model.getName(),
                model.getEmail(),
                model.getCity(),
                model.getPassHash());
    }


    @Override
    @SneakyThrows
    public Guest findOne(Long id) {
        return template.queryForObject(
                SQL_FIND_BY_ID,
                (rs, i) -> Guest.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .email(rs.getString("email"))
                        .age(rs.getInt("age"))
                        .city(rs.getString("city"))
                        .card(new CardRepositoryImpl(template.getDataSource()).readByGuestId(id))
                        .build(),
                id
        );
    }

    @Override
    public void update(Guest model) {

    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public List<Guest> findAll() {
        return null;
    }

    @Override
    public Guest getByEmail(String email) {
        return template.queryForObject(
                SQL_FIND_BY_EMAIL,
                (rs, i) -> Guest.builder()
                        .id(rs.getLong("id"))
                        .email(rs.getString("email"))
                        .passHash(rs.getString("pass_hash"))
                        .build(),
                email
        );
    }

    @Override
    public Guest getByCookie(String cookieValue) {
        System.out.println("===============");
        System.out.println(cookieValue);
        System.out.println("===============");
        try {

            return template.queryForObject(
                    SQL_FIND_BY_COOKIE,
                    (rs, i) -> Guest.builder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("name"))
                            .card(
                                    Card.builder()
                                            .id(rs.getLong("card_id"))
                                            .balance(rs.getInt("balance"))
                                            .activated(rs.getBoolean("activated"))
                                            .build()
                            )
                            .build(),
                    cookieValue
            );
        } catch (Exception e){
            return null;
        }
    }
}
