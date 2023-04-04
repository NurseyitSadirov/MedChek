package model;

import enums.Gender;
import lombok.Data;

@Data
public class Doctor {

    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int experienceYear;

}
