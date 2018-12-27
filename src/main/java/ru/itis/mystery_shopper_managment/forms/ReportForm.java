package ru.itis.mystery_shopper_managment.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportForm {
    private Integer minutesInQueue;
    private Integer minutesWaitingForDrink;
    private String baristaComment;
    private String toiletComment;
    private String roomComment;
    private String drinkComment;
    private Long instructionsId;
}
