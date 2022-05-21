package uz.isystem.clinika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.clinika.model.Visit;
import uz.isystem.clinika.service.VisitService;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<?> creare(@RequestBody Visit visit){
        Visit result = visitService.create(visit);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Visit result = visitService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Integer id,
                                     @RequestBody Visit visit){
        Visit result = visitService.update(id,visit);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Boolean result = visitService.delete(id);
        return ResponseEntity.ok(result);
    }

}
