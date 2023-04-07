package service.impl;

import database.Database;
import service.Department;
import service.Hospital;

import java.util.ArrayList;
import java.util.List;

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



    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return null;
    }

        departments.deleteDepartmentById(id);
    }

    @Override
    public String updateDepartmentById(Long id, model.Department department) {
        return departments.updateDepartmentById(id,department);
    }


}
