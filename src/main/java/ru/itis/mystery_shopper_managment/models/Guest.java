package ru.itis.mystery_shopper_managment.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Guest {
    private Long id;
    private String email;
    private String passHash;
    private String name;
    private Integer age;
    private String city;
    private Card card;
    private List<Instructions> instructions;
    private List<Report> reports;
}
