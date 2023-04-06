package service.impl;

import service.Department;

import java.util.List;

public class DepartmentImpl implements Department {



    DepartmentImpl departments = new DepartmentImpl();
    @Override
    public String addDepartmentToHospital(Long id, model.Department department) {
        return departments.addDepartmentToHospital(id,department);
    }

    @Override
    public List<model.Department> getAllDepartmentByHospital(Long id) {
        return departments.getAllDepartmentByHospital(id);
    }

    @Override
    public model.Department findDepartmentByName(String name) {
        return departments.findDepartmentByName(name);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departments.deleteDepartmentById(id);
    }

    @Override
    public String updateDepartmentById(Long id, model.Department department) {
        return departments.updateDepartmentById(id,department);
    }

}
