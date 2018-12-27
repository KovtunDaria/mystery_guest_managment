package ru.itis.mystery_shopper_managment.models;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Auth {
    private Long id;
    private UUID value;
    private Guest guest;
}
