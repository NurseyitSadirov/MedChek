package model;

import enums.Gender;
import lombok.Data;

@Data

public class Patient {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
}
