package dao.impl;

import dao.DoctorDao;
import database.Database;
import model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    private final List<Database> databases = new ArrayList<>();


    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
       return null;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {

        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {

        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return null;
    }
}
