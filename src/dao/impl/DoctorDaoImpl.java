package dao.impl;

import dao.DoctorDao;
import database.Database;
import model.Department;
import model.Hospital;
import model.Doctor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DoctorDaoImpl implements DoctorDao {

    Database database = new Database();
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        Hospital hospital = database.getHospitals().stream().filter(d->d.getId().equals(id)).findFirst().orElse(null);
        if(hospital == null){
            return "Hospital not found!";
        }
        hospital.getDoctors().add(doctor);
        return "Doctor added for Hospital successfully!!!";
    }

    @Override
    public Doctor findDoctorById(Long id) {
        Doctor doctor = database.getDoctors().stream().filter(d->d.getId().equals(id)).findFirst().orElse(null);
        if(doctor == null){
            return null;
        }
        return doctor;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        for(Hospital hospital : database.getHospitals()){
            for(Doctor doctor1 : hospital.getDoctors()){
                if(doctor1.getId().equals(id)){
                    doctor1.setId(doctor.getId());
                    doctor1.setFirstName(doctor.getFirstName());
                    doctor1.setLastName(doctor.getLastName());
                    doctor1.setGender(doctor.getGender());
                    doctor1.setExperienceYear(doctor.getExperienceYear());
                    return "Doctor update successfully!";
                }
            }
        }
        return "Doctor not found!!!";
    }

    @Override
    public void deleteDoctorById(Long id) {
         for(Hospital hospital : database.getHospitals()){
            for(Doctor doctor: hospital.getDoctors()){
                 if(doctor.getId().equals(id)){
                     hospital.getDoctors().remove(doctor);
                     System.out.println(doctor);
                 }else{
                     System.out.println("Doctor with ID "+ doctor.getId() + " not  found!!!");
                 }
             }
         }
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        Department department = database.getDepartments().stream().filter(w->w.getId().equals(departmentId)).findFirst().orElse(null);
        if(department == null){
            return "Department not found!!!";
        }
        List<Doctor> doctors = doctorsId.stream().map(this::findDoctorById)
                .filter(Objects::nonNull)
                .toList();
        department.getDoctors().addAll(doctors);
        return "Doctors assigned to department successfully!!!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        Hospital hospital = database.getHospitals().stream().filter(r->r.getId().equals(id)).findFirst().orElse(null);
        if(hospital == null){
            return Collections.emptyList();
        }
        return hospital.getDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        Department department = database.getDepartments().stream().filter(a->a.getId().equals(id)).findFirst().orElse(null);
        if(department == null){
            return Collections.emptyList();
        }
        return department.getDoctors();
    }
}
