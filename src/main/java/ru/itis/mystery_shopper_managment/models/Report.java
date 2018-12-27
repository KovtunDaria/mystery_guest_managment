package ru.itis.mystery_shopper_managment.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString

public class Report {
    private Long id;
    private Guest guest;
    private Instructions instruction;
    private Coffeeshop coffeeshop;
    private Long date;
    private Long queueTime;
    private Long waitTime;
    private String baristaComment;
    private String toiletComment;
    private String roomComment;
    private String drinkComment;
}
