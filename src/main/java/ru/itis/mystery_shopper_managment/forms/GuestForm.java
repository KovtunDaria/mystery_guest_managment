package ru.itis.mystery_shopper_managment.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestForm {
    private String name;
    private String email;
    private String city;
}
