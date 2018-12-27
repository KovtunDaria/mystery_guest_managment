package ru.itis.mystery_shopper_managment.repositories;

import org.postgresql.util.PGInterval;
import ru.itis.mystery_shopper_managment.models.Report;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository{
    private JdbcTemplate template;

    @SneakyThrows
    public ReportRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);

    }

    //language=sql
    private final String SQL_INSERT_REPORT =
            "INSERT INTO report(instruction_id, coffeeshop_id, guest_id, queue_time, wait_time, barista_comment, toilet_comment, room_comment, drink_comment) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";

    @Override
    public void save(Report model) {
        template.update(
                SQL_INSERT_REPORT,
                model.getInstruction().getId(),
                model.getCoffeeshop().getId(),
                model.getGuest().getId(),
                new PGInterval(0,0,0,0, Math.toIntExact(model.getQueueTime()),0),
                new PGInterval(0,0,0,0, Math.toIntExact(model.getWaitTime()),0),
                model.getBaristaComment(),
                model.getToiletComment(),
                model.getRoomComment(),
                model.getDrinkComment()
        );
    }

    @Override
    public Report findOne(Long id) {
        return null;
    }

    @Override
    public void update(Report model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Report> findAll() {
        return null;
    }
}
