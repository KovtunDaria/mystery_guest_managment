package ru.itis.mystery_shopper_managment.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Card {
    private Long id;
    private Integer balance;
    private Boolean activated;
}
