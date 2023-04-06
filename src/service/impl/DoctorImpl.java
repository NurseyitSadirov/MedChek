package service.impl;

import dao.impl.DoctorDaoImpl;
import service.Doctor;

import java.util.List;

public class DoctorImpl implements Doctor {
    DoctorDaoImpl doctorDao = new DoctorDaoImpl();
    @Override
    public String addDoctorToHospital(Long id, model.Doctor doctor) {
        return doctorDao.addDoctorToHospital(id,doctor);
    }
    @Override
    public model.Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }
    @Override
    public String updateDoctor(Long id, model.Doctor doctor) {
        return doctorDao.updateDoctor(id,doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorDao.deleteDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<model.Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<model.Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }
}
