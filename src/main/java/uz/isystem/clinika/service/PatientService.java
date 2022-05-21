package uz.isystem.clinika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.clinika.model.Patient;
import uz.isystem.clinika.repository.PatientRepository;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient create(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    public Patient get(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public Patient update(Integer id, Patient patient) {
        Patient old = get(id);
        old.setName(patient.getName());
        old.setContact(patient.getContact());
        old.setBirthday(patient.getBirthday());
        old.setAge(patient.getAge());
        old.setSurname(patient.getSurname());
        patientRepository.save(old);
        return old;
    }

    public Boolean delete(Integer id) {
       Patient patient = get(id);
       patientRepository.delete(patient);
       return true;
    }
}
