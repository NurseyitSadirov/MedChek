package dao;


import service.Department;

import model.Department;


import java.util.List;

public interface DepartmentDao {
    String addDepartmentToHospital(Long id, Department department);

    List<model.Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    model.Department deleteDepartmentById(Long id);
    String updateDepartmentById(Long id, model.Department department);

    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    void deleteDepartmentById(Long id);
    String updateDepartmentById(Long id, Department department);

}
