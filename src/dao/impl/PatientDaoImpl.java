package dao.impl;

import dao.PatientDao;
import database.Database;
import model.Hospital;
import model.Patient;
import java.util.*;
import java.util.stream.Collectors;

public class PatientDaoImpl implements PatientDao {
    Database database = new Database();
    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        for (Hospital hospital : database.getHospitals()) {
                if (hospital.getId() == id) {
                    hospital.getPatients().add(patient);
                    return "Patient s successfully saved!";
                } else {
                    System.out.println("Not added");
                }
            }
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId() == id) {
                hospital.setPatients(patients);
                return "Patient s successfully saved!";
            } else {
                System.out.println("Not added");
            }
        }
        return null;

    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    patient.setFirstName(patientsNewInfo.getFirstName());
                    patient.setLastName(patientsNewInfo.getLastName());
                    patient.setAge(patientsNewInfo.getAge());
                    patient.setGender(patientsNewInfo.getGender());
                } else {
                    System.out.println("Not update");
                }
            }
        }
        return "Update";

    }

    @Override
    public void removePatientById(Long id) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient p : hospital.getPatients()) {
                if (p.getId() == id) ;
                hospital.getPatients().remove(p);
                System.out.println("removed");
            }
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    return patient;
                } else {
                    System.out.println("Not get");
                }
            }

        }
        return null;

    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer,Patient>patientMap = new HashMap<>();
        List<Hospital>hospitals = database.getHospitals().stream().toList();
        List<List<Patient>>patients= hospitals.stream().map(Hospital::getPatients).toList();
        for (List<Patient> p:patients) {
            for (Patient a:p) {
                patientMap.put(a.getAge(),a);
            }
        }
        return patientMap;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (ascOrDesc.equalsIgnoreCase("asc")) {
                    List<Patient> sortedListAsc = hospital.getPatients().stream()
                            .sorted()
                            .collect(Collectors.toList());

                    return sortedListAsc;
                } else if (ascOrDesc.equalsIgnoreCase("desc"))

                    return hospital.getPatients().stream().sorted(Comparator.comparing(Patient::getAge).
                            reversed()).toList();

            }

        }
        return null;
    }

}
