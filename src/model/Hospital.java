package model;

import lombok.Data;

import java.util.List;

@Data

public class Hospital {

    private Long id;
    private String hospitalName;
    private String address;
    private List<Department> departments;
    private List<Doctor> doctors;
    private List<Patient> patients;
}
