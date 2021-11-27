package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.converter.AnimalVaccinationConverter;
import wildlife.care.model.Animal;
import wildlife.care.model.AnimalVaccination;
import wildlife.care.service.AnimalService;
import wildlife.care.service.AnimalVaccinationService;
import wildlife.care.web.model.AnimalVaccinationDto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnimalVaccinationController {

    @Autowired
    AnimalVaccinationService animalVaccinationService;

    @Autowired
    AnimalVaccinationConverter animalVaccinationConverter;

    @Autowired
    AnimalService animalService;

    @GetMapping(path = "/next_vaccination")
    public Date getNextVaccinationDate(@RequestParam int vaccineId, @RequestParam Date lastVaccination) {
        return this.animalVaccinationService.nextVaccinationDate(lastVaccination, vaccineId);
    }

    @GetMapping(path = "{id}/animalVaccinations")
    public List<AnimalVaccinationDto> findAll(@PathVariable int id) {
        List<Animal> animals = animalService.findAllFromNationalPark(id);
        return animalVaccinationService.findAll().stream()
                .map(el -> animalVaccinationConverter.toDto(el)).filter(el -> animals.contains(animalService.findById(animalVaccinationConverter.toDomainModel(el).getAnimal()))).collect(Collectors.toList());
    }

    @PostMapping(path = "/create_animalVaccination")
    public ResponseEntity<AnimalVaccinationDto> insert(@RequestBody AnimalVaccinationDto animalVaccination) {
        return new ResponseEntity<>(animalVaccinationConverter.toDto(animalVaccinationService.insertAnimalVaccination(animalVaccinationConverter.toDomainModel(animalVaccination))), HttpStatus.CREATED);
    }

    @GetMapping(path = "/animalVaccination")
    public ResponseEntity<AnimalVaccinationDto> findById(@RequestParam int id) {
        return new ResponseEntity<>(animalVaccinationConverter.toDto(animalVaccinationService.findById(id)), HttpStatus.OK);
    }

    @PutMapping(path = "/update_animalVaccination")
    public ResponseEntity<AnimalVaccinationDto> updateAnimalVaccination(@RequestBody AnimalVaccinationDto animalVaccination) {
        return new ResponseEntity<>(animalVaccinationConverter.toDto(animalVaccinationService.updateAnimalVaccination(animalVaccinationConverter.toDomainModel(animalVaccination))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_animalVaccination")
    public void deleteAnimalVaccination(@RequestParam int id) {
        animalVaccinationService.deleteAnimalVaccination(id);
    }


}
