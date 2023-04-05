package service.impl;

import database.Database;
import service.Department;
import service.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl implements Department {
    private Database database;
    public DepartmentImpl(Database database) {
        this.database = database;
    }
    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {


    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return null;
    }
}
