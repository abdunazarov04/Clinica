package uz.isystem.clinika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.clinika.model.Doctor;
import uz.isystem.clinika.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
   @Autowired
    private DoctorService doctorService;

   @PostMapping
    public ResponseEntity<?> create(@RequestBody Doctor doctor){
       Doctor result = doctorService.create(doctor);
       return ResponseEntity.ok(result);
   }

   @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
       Doctor result = doctorService.get(id);
       return ResponseEntity.ok(result);
   }

   @PutMapping("/{id}")
    public ResponseEntity<?>  update(@PathVariable("id") Integer id,
                                     @RequestBody Doctor doctor){
       Doctor result = doctorService.update(id, doctor);
       return ResponseEntity.ok(result);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Integer id){
       Boolean result = doctorService.delete(id);
      return ResponseEntity.ok(result);
   }

}
