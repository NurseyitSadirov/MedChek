package model;

import lombok.Data;

import java.util.List;

@Data
public class Department {

    private Long id;
    private String departmentName;
    private List<Doctor> doctors;
}
