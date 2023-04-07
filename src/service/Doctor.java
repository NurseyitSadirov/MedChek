package service;

import java.util.List;

public interface Doctor {
    String addDoctorToHospital(Long id, model.Doctor doctor);
    model.Doctor findDoctorById(Long id);
    String updateDoctor(Long id, model.Doctor doctor);
    void deleteDoctorById(Long id);
    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган
    // Department'ге табылган Doctor'лорду кошуп коюнунуз
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<model.Doctor> getAllDoctorsByHospitalId(Long id);
    List<model.Doctor> getAllDoctorsByDepartmentId(Long id);
}
