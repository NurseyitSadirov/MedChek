package dao.impl;

import dao.DepartmentDao;
import database.Database;
import model.Hospital;

import service.Department;

import model.Department;


import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private Database database;

    public DepartmentDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        Hospital hospital = database.getHospitals().stream().filter(h->h.getId().equals(id)).findFirst().orElse(null);
        if (hospital == null){
            return "Hospital not fount!";
        }
        hospital.getDepartments().add((model.Department) department);
        return "Department added successfully!";
    }
    @Override
    public List<model.Department> getAllDepartmentByHospital(Long id) {
        Hospital hospital = database.getHospitals().stream().filter(h->h.getId().equals(id)).findFirst().orElse(null);
        if (hospital == null){
            return null;
        }
         return  hospital.getDepartments();



    Database database = new Database();
    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        Hospital hospital = database.getHospitals().stream().filter(h->h.getId().equals(id)).findFirst().orElse(null);
        if(hospital == null){
            return "Hospital not found!";
        }
        hospital.getDepartments().add(department);
        return "Department added successfully!!!";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        Hospital hospital = database.getHospitals().stream().filter(h->h.getId().equals(id)).findFirst().orElse(null);
        if(hospital == null){
            return null;
        }
        return hospital.getDepartments();

    }

    @Override
    public Department findDepartmentByName(String name) {

        for(Hospital hospital : database.getHospitals()){
            for(model.Department d : hospital.getDepartments()){
                if(d.getDepartmentName().equals(name)){
                    return (Department) d;

        for(Hospital hospital: database.getHospitals()){
            for(Department department : hospital.getDepartments()){
                if(department.getDepartmentName().equals(name)){
                    return department;

                }
            }
        }
        return null;
    }

    @Override

    public model.Department deleteDepartmentById(Long id) {
         for(Hospital hospital : database.getHospitals()){
             for(model.Department department : hospital.getDepartments()){
                 if(department.getId().equals(id)){
                     hospital.getDepartments().remove(department);
                     return department;
                 }
             }
         }
         return null;
    }

    @Override
    public String updateDepartmentById(Long id, model.Department department) {
        for(Hospital hospital : database.getHospitals()){
            for (model.Department department1 : hospital.getDepartments()){
                if(department1.getId().equals(id)){
                    department1.setDepartmentName(department.getDepartmentName());
                    department1.setDoctors(department.getDoctors());
                    return "Department update successfully!";

    public void deleteDepartmentById(Long id) {
        for(Hospital hospital : database.getHospitals()){
            for(Department department : hospital.getDepartments()){
                if(department.getId().equals(id)){
                    hospital.getDepartments().remove(department);
                    System.out.println(department);
                }else{
                    System.out.println("Department with ID "+ department.getId()+ " not found");
                }
            }
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        for(Hospital hospital : database.getHospitals()){
            for(Department department1 : hospital.getDepartments()){
                if(department1.getId().equals(id)){
                    department1.setDepartmentName(department.getDepartmentName());
                    department1.setDoctors(department.getDoctors());
                    return  "Department update successfully!";

                }
            }
        }
        return "Department not found!!!";
    }
}
