package dao.impl;

import dao.DoctorDao;
import database.Database;
import exceptions.MyException;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DoctorDaoImpl implements DoctorDao {
    Database database = new Database();

    public DoctorDaoImpl(Database database) {
        this.database = database;
    }

    public DoctorDaoImpl() {
    }

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
//        database.getHospitals().stream().anyMatch(x -> x.getId().equals(doctor.getId()));
        database.getDoctors().add(doctor);
        return "Doctor successfully added to the hospital " + doctor;
    }

    @Override
    public Doctor findDoctorById(Long id) {
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
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
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
