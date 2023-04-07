import dao.impl.DoctorDaoImpl;
import dao.impl.HospitalDaoImpl;

import dao.impl.PatientDaoImpl;
import enums.Gender;
import model.Hospital;
import model.Patient;
import service.impl.PatientImpl;

import database.Database;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Patient patient = new Patient(1L, "Madina", "Halikova", 16, Gender.FEMALE);
        Patient patient1 = new Patient(4L, "Alina", "Abdulaiva", 15, Gender.FEMALE);
        Patient patient3 = new Patient(6L, "Kanykei", "Alibekova", 17, Gender.FEMALE);
        List<Patient> patients = new ArrayList<>(List.of(patient, patient1, patient3));

        PatientDaoImpl patient11 = new PatientDaoImpl();
        Patient patient6 = new Patient();
        List<Patient> patientList = new ArrayList<>();
        System.out.println(patients);
        System.out.println(patient11.addPatientToHospital(6L, patient6));
        System.out.println(patient11.addPatientsToHospital(6L, patientList));
        System.out.println(patient11.updatePatientById(1L,patient6));
        patient11.removePatientById(4L);
        System.out.println(patient11.getPatientById(1L));
        System.out.println(patient11.getPatientByAge());
        System.out.println(patient11.sortPatientsByAge("asc"));



        System.out.println("=========DOCTOR=========");
        Database database = new Database();
        HospitalDaoImpl hospitalDao = new HospitalDaoImpl();
        Hospital hospital = new Hospital();

        DoctorDaoImpl doctorDao = new DoctorDaoImpl(database);

        Doctor doctor1 = new Doctor(1L, "Nurseyit", "Sadirov", Gender.MALE, 2021);
        Doctor doctor = new Doctor(2L, "Ernazar", "Tilek uulu", Gender.MALE, 2022);

        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.addDoctorToHospital(1L, doctor1));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.findDoctorById(1L));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.updateDoctor(1L, doctor));
        System.out.println("~~~~~~~~~~~~~");
        doctorDao.deleteDoctorById(1L);
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.assignDoctorToDepartment(1L, List.of(211L, 24352L)));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.getAllDoctorsByHospitalId(1L));
        System.out.println("~~~~~~~~~~~~~");
        System.out.println(doctorDao.getAllDoctorsByDepartmentId(1L));
        System.out.println("~~~~~~~~~~~~~");

        System.out.println("=============HOSPITAL============");
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(22L, "Nurseyit", "Sadirov", Gender.MALE, 2006));
        doctors.add(new Doctor(23L, "Adilet", "Islamber uulu", Gender.MALE, 2001));
        doctors.add(new Doctor(24L, "Aizat", "Dyisheeva", Gender.FEMALE, 2003));
        doctors.add(new Doctor(25L, "Baitik", "Taalaibekov", Gender.MALE, 2002));
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(12L, "Nurseyit", doctors));
        departments.add(new Department(13L, "Khafiz", doctors));
        departments.add(new Department(14L, "Mirbek", doctors));
        departments.add(new Department(15L, "Matmusa", doctors));
        List<Patient> patients1 = new ArrayList<>();
        patients.add(new Patient(33L, "Ernazar", "Tilek uulu", 20, Gender.MALE));
        List<Hospital> hospitals = List.of(
                new Hospital(2L, "Urology", "Vostok 5", departments, doctors, patients1),
                new Hospital(3L, "Urology", "Vostok 5", departments, doctors, patients1),
                new Hospital(4L, "Urology", "Vostok 5", departments, doctors, patients1)
        );

        Hospital hospital1 = new Hospital(1L, "Urology", "Vostok 5", departments, doctors, patients);

        HospitalDaoImpl hospitalDao1 = new HospitalDaoImpl();
        System.out.println(hospitalDao1.addHospital(hospital1));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao1.findHospitalById(34L));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao1.getAllHospital());
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao1.getAllPatientFromHospital(1L));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao1.deleteHospitalById(2L));
        System.out.println("~~~~~~~~");
        System.out.println(hospitalDao1.getAllHospitalByAddress("Vostok 5"));

    }
}