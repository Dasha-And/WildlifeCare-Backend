package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.model.AnimalVaccination;
import wildlife.care.service.AnimalVaccinationService;

import java.sql.Date;
import java.util.List;

@RestController
public class AnimalVaccinationController {

    @Autowired
    AnimalVaccinationService animalVaccinationService;

    @GetMapping(path = "/next_vaccination")
    public Date getNextVaccinationDate(@RequestParam int vaccineId, @RequestParam Date lastVaccination) {
        return this.animalVaccinationService.nextVaccinationDate(lastVaccination, vaccineId);
    }

    @GetMapping(path = "/animalVaccinations")
    public List<AnimalVaccination> findAll() {
        return animalVaccinationService.findAll();
    }

    @PostMapping(path = "/create_animalVaccination")
    public ResponseEntity<AnimalVaccination> insert(@RequestBody AnimalVaccination animalVaccination) {
        return new ResponseEntity<>(animalVaccinationService.insertAnimalVaccination(animalVaccination), HttpStatus.CREATED);
    }

    @GetMapping(path = "/animalVaccination")
    public ResponseEntity<AnimalVaccination> findById(@RequestParam int id) {
        return new ResponseEntity<>(animalVaccinationService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update_animalVaccination")
    public ResponseEntity<AnimalVaccination> updateAnimalVaccination(@RequestBody AnimalVaccination animalVaccination) {
        return new ResponseEntity<>(animalVaccinationService.updateAnimalVaccination(animalVaccination), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_animalVaccination")
    public void deleteAnimalVaccination(@RequestParam int id) {
        animalVaccinationService.deleteAnimalVaccination(id);
    }


}
