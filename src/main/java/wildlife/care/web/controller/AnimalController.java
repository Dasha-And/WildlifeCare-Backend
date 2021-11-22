package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.converter.AnimalConverter;
import wildlife.care.model.Animal;
import wildlife.care.service.AnimalService;
import wildlife.care.service.SpeciesService;
import wildlife.care.web.model.AnimalDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @Autowired
    SpeciesService speciesService;

    @Autowired
    AnimalConverter animalConverter;

    @GetMapping(path = "{nationalParkId}/animals")
    public List<AnimalDto> findAll(@PathVariable int nationalParkId) {
        return animalService.findAllFromNationalPark(nationalParkId).stream().map(el -> animalConverter.toDto(el)).collect(Collectors.toList());
    }

    @PostMapping(path = "/create_animal")
    public ResponseEntity<AnimalDto> insert(@RequestBody Animal animal) {
        return new ResponseEntity<>(animalConverter.toDto(animalService.insertAnimal(animal)), HttpStatus.CREATED);
    }

    @GetMapping(path = "/animal")
    public ResponseEntity<AnimalDto> findById(@RequestParam int id) {
        return new ResponseEntity<>(animalConverter.toDto(animalService.findById(id)), HttpStatus.OK);
    }

    @PutMapping(path = "/update_animal")
    public ResponseEntity<AnimalDto> updateAnimal(@RequestBody AnimalDto animalDto) {
        return new ResponseEntity<>(animalConverter.toDto(animalService.updateAnimal(animalConverter.toDomainModel(animalDto))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_animal")
    public void deleteAnimal(@RequestParam int id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping(path = "/get_icon_url")
    public ResponseEntity<String> getIconUrl(@RequestParam int id) {
        System.out.println(animalService.findById(id).getSpecies());
        System.out.println(animalConverter
                .toDto(animalService
                        .findById(id))
                .getSpecies());
        System.out.println();
        return new ResponseEntity<>(speciesService
                        .getIconUrlByName(animalConverter
                                .toDto(animalService
                                        .findById(id))
                                .getSpecies()), HttpStatus.OK);
    }
}
