package service.impl;

import dao.impl.HospitalDaoImpl;
import model.Patient;
import service.Hospital;

import java.util.List;
import java.util.Map;

public class HospitalImpl implements Hospital {
    HospitalDaoImpl hospitalDao = new HospitalDaoImpl();
    @Override
    public String addHospital(model.Hospital hospital) {
        return hospitalDao.addHospital(hospital);
    }

    @Override
    public model.Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<model.Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, model.Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
