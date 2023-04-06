package service;

import java.util.List;

public interface Department {

    String addDepartmentToHospital(Long id, model.Department department);
    List<model.Department> getAllDepartmentByHospital(Long id);
    model.Department findDepartmentByName(String name);
    void deleteDepartmentById(Long id);
    String updateDepartmentById(Long id, model.Department department);
}
