import dao.impl.HospitalDaoImpl;
import dao.impl.PatientDaoImpl;
import enums.Gender;
import model.Hospital;
import model.Patient;
import service.impl.PatientImpl;

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
    }
}