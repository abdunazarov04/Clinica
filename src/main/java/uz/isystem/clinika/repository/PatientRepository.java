package uz.isystem.clinika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.clinika.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
