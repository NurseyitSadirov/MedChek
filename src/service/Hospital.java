package service;

import model.Patient;

import java.util.List;
import java.util.Map;

public interface Hospital {

    String addHospital(model.Hospital hospital);
    model.Hospital findHospitalById(Long id);
    List<model.Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, model.Hospital> getAllHospitalByAddress(String address);
}
