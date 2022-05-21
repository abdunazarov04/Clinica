package uz.isystem.clinika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.clinika.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}


