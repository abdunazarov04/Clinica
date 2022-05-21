package uz.isystem.clinika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.clinika.model.Visit;

public interface VisitRepository extends JpaRepository<Visit,Integer> {
}
