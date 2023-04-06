import dao.impl.DoctorDaoImpl;
import dao.impl.HospitalDaoImpl;
import database.Database;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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
    }
}