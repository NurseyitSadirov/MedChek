package dao.impl;

import dao.DoctorDao;
import database.Database;

import model.Department;
import model.Hospital;

import exceptions.MyException;
import model.Department;

import model.Doctor;
import model.Hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class DoctorDaoImpl implements DoctorDao {

import java.util.Optional;

public class DoctorDaoImpl implements DoctorDao {
    Database database = new Database();

    public DoctorDaoImpl(Database database) {
        this.database = database;
    }

    public DoctorDaoImpl() {
    }


    Database database = new Database();
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {

        Hospital hospital = database.getHospitals().stream().filter(d->d.getId().equals(id)).findFirst().orElse(null);
        if(hospital == null){
            return "Hospital not found!";
        }
        hospital.getDoctors().add(doctor);
        return "Doctor added for Hospital successfully!!!";

//        database.getHospitals().stream().anyMatch(x -> x.getId().equals(doctor.getId()));
        database.getDoctors().add(doctor);
        return "Doctor successfully added to the hospital " + doctor;

    }

    @Override
    public Doctor findDoctorById(Long id) {

        Doctor doctor = database.getDoctors().stream().filter(d->d.getId().equals(id)).findFirst().orElse(null);
        if(doctor == null){
            return null;
        }
        return doctor;

        try {
            database.getDoctors();
            boolean isFalse = false;
            for (Doctor doc : database.getDoctors()) {
                if (doc.getId().equals(id)) {
                    isFalse = false;
                    return doc;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new MyException("Doctor by id " + id + " not found");
            }
        } catch (MyException a) {
            System.out.println(a.getMessage());
        }

        return null;

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

        try {
            boolean isFalse = false;
            for (Doctor doc : database.getDoctors()) {
                if (doc.getId().equals(id)) {
                    System.out.println(doc);
                    doc.setFirstName(doctor.getFirstName());
                    doc.setLastName(doctor.getLastName());
                    doc.setExperienceYear(doctor.getExperienceYear());
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new MyException("Doctor by id " + id + " not found\"");
            }
        } catch (MyException a) {
            System.out.println(a.getMessage());
        }
        return "Doctor successfully modified " + doctor;

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

        try {
            System.out.println(database.getDoctors());
            boolean isFalse = false;
            for (Doctor doctor : database.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    database.getDoctors().remove(doctor);
                    System.out.println("doctor by id " + id + " successfully removed");
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new MyException("Doctor by id " + id + " not found");
            }

        } catch (MyException a) {
            System.out.println(a.getMessage());
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

        List<Doctor> doctors = new ArrayList<>();

        try {
            boolean isFalse = false;
            for (Hospital d : database.getHospitals()) {
                for (Doctor doctor : d.getDoctors()) {
                    for (long lon : doctorsId) {
                        if (doctor.getId().equals(lon)) {
                            doctors.add(doctor);
                        }
                    }
                }
            }
            for (Hospital h : database.getHospitals()) {
                for (Doctor de : database.getDoctors()) {
                    if (de.getId().equals(departmentId)) {
                        h.getDoctors().add(de);
                        System.out.println();
                        isFalse = false;
                    } else {
                        isFalse = true;
                    }
                }
            }
            if (isFalse) {
                throw new MyException("No such argument");
            }

        } catch (MyException a) {
            System.out.println(a.getMessage());

        }
        return "Doctor successfully assigned to the department";

    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {

        Hospital hospital = database.getHospitals().stream().filter(r->r.getId().equals(id)).findFirst().orElse(null);
        if(hospital == null){
            return Collections.emptyList();
        }
        return hospital.getDoctors();

        try {
            Hospital hos = database.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).
                    findFirst().orElseThrow(() -> new MyException("Hospital by id " + id + " not found"));
            return hos.getDoctors();
        } catch (MyException a) {
            System.out.println(a.getMessage());
        }
        return null;

    }

    @Override
    public List<Doctor> getAllDoc<<<<<<< Doctor/methods
        Department department = database.getDepartments().stream().filter(a->a.getId().equals(id)).findFirst().orElse(null);
        if(department == null){
            return Collections.emptyList();
        }
        return department.getDoctors();

        try {
            Department dep = database.getDepartments().stream().filter(department -> department.getId().equals(id)).
                    findFirst().orElseThrow(() -> new MyException("Department by id " + id + " not found"));
            return dep.getDoctors();
        } catch (MyException a) {
            System.out.println(a.getMessage());
        }
        return null;

    }
}
