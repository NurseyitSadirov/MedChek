package dao.impl;

import dao.HospitalDao;
import database.Database;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HospitalDaoImpl implements HospitalDao {
    Database databases = new Database();

    @Override
    public String addHospital(Hospital hospital) {
        boolean stream = databases.getHospitals().stream().anyMatch(x -> x.getId().equals(hospital.getId()));
        if (stream) {
            return "Hospital already exists";
        } else {
            databases.getHospitals().add(hospital);
            return "Hospital added successfully";
        }
    }

    @Override
    public Hospital findHospitalById(Long id) {
        Optional<Hospital> d = databases.getHospitals().stream().filter(x -> x.getId().equals(id)).findFirst();
        return d.orElse(null);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return databases.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        Optional<Hospital> hospital = databases.getHospitals().stream().filter(x -> x.getId().equals(id)).findFirst();
        if (hospital.isPresent()) {
            return hospital.get().getPatients();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public String deleteHospitalById(Long id) {
        boolean success = databases.getHospitals().removeIf(x -> x.getId().equals(id));
        if (success) {
            return "Hospital with ID " + id + " has been deleted.";
        } else {
            return "Failed to delete hospital with ID " + id;
        }
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return databases.getHospitals()
                .stream()
                .filter(x -> x.getAddress().equals(address))
                .collect(Collectors.toMap(Hospital::getHospitalName, hospital -> hospital));
    }
}
