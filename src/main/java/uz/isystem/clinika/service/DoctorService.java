package uz.isystem.clinika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.clinika.model.Doctor;
import uz.isystem.clinika.repository.DoctorRepository;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor create(Doctor doctor) {
      doctorRepository.save(doctor);
      return doctor;
    }

    public Doctor get(Integer id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public Doctor update(Integer id, Doctor doctor) {
        Doctor old = get(id);
        old.setName(doctor.getName());
        old.setSurname(doctor.getSurname());
        old.setContact(doctor.getContact());
        old.setDirection(doctor.getDirection());
        old.setExperience(doctor.getExperience());
        doctorRepository.save(old);
        return old;
    }

    public Boolean delete(Integer id) {
      Doctor doctor = get(id);
      doctorRepository.delete(doctor);
      return true;
    }

}
