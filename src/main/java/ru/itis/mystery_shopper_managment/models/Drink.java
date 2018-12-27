package ru.itis.mystery_shopper_managment.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Drink {
    private Long id;
    private String name;
}
