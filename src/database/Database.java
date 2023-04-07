package database;

import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.ArrayList;
import java.util.List;
@Data
public class Database {
    private List<Hospital> hospitals;

    public Database(){
        this.hospitals = new ArrayList<>();

import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Hospital> hospitals = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

    public Database() {
    }

    public Database(List<Hospital> hospitals, List<Doctor> doctors, List<Patient> patients, List<Department> departments) {
        this.hospitals = hospitals;
        this.doctors = doctors;
        this.patients = patients;
        this.departments = departments;

    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }


    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Database{" +
                "hospitals=" + hospitals +
                ", doctors=" + doctors +
                ", patients=" + patients +
                ", departments=" + departments +
                '}';
    }
}
