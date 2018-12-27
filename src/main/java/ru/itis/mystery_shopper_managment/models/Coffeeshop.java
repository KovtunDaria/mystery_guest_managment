package ru.itis.mystery_shopper_managment.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Coffeeshop {
    private Long id;
    private String city;
    private String address;
}
