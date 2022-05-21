package uz.isystem.clinika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.clinika.model.Visit;
import uz.isystem.clinika.repository.VisitRepository;

import java.util.Optional;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    public Visit get(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()){
            throw  new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public Visit create(Visit visit) {
       visitRepository.save(visit);
       return visit;
    }

    public Visit update(Integer id, Visit visit) {
      Visit old = get(id);
      old.setDiagnosis(visit.getDiagnosis());
      old.setDoctor_id(visit.getDoctor_id());
      old.setPatient_id(visit.getPatient_id());
      visitRepository.save(old);
      return old;
    }

    public Boolean delete(Integer id) {
       Visit visit = get(id);
       visitRepository.delete(visit);
       return true;
    }
}
