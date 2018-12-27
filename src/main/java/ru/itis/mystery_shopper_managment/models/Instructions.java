package ru.itis.mystery_shopper_managment.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Instructions {
    private Long id;
    private Guest guest;
    private Long date;
    private Drink drink;
    private Coffeeshop coffeeshop;
    private Status status;
}
