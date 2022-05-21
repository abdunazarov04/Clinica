package uz.isystem.clinika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.clinika.model.Patient;
import uz.isystem.clinika.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Patient patient){
        Patient result = patientService.create(patient);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Patient result = patientService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable ("id")Integer id,
                                    @RequestBody Patient patient){
        Patient result = patientService.update(id,patient);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Integer id){
        Boolean result = patientService.delete(id);
        return ResponseEntity.ok(result);
    }
}
