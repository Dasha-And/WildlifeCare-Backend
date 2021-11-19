package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wildlife.care.model.Vaccine;
import wildlife.care.service.VaccineService;

import java.util.List;

@Controller
public class VaccineController {

    @Autowired
    VaccineService vaccineService;

    @GetMapping(path = "/vaccine_all")
    public List<Vaccine> findAll() {
        return vaccineService.findAll();
    }

    @PostMapping(path = "/create_vaccine")
    public ResponseEntity<Vaccine> insert(@RequestBody Vaccine vaccine) {
        return new ResponseEntity<>(vaccineService.insertVaccine(vaccine), HttpStatus.CREATED);
    }

    @GetMapping(path = "/vaccine")
    public ResponseEntity<Vaccine> findById(@RequestParam int id) {
        return new ResponseEntity<>(vaccineService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update_vaccine")
    public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine) {
        return new ResponseEntity<>(vaccineService.updateVaccine(vaccine), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_vaccine")
    public void deleteVaccine(@RequestParam int id) {
        vaccineService.deleteVaccine(id);
    }

}
