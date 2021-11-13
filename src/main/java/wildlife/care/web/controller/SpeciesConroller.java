package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.model.Species;
import wildlife.care.service.SpeciesService;

import java.util.List;

@RestController
public class SpeciesConroller {

    @Autowired
    SpeciesService speciesService;

    @GetMapping(path = "/species_all")
    public List<Species> findAll() {
        return speciesService.findAll();
    }

    @PostMapping(path = "/create_species")
    public ResponseEntity<Species> insert(@RequestBody Species species) {
        return new ResponseEntity<>(speciesService.insertSpecies(species), HttpStatus.CREATED);
    }

    @GetMapping(path = "/species")
    public ResponseEntity<Species> findById(@RequestParam int id) {
        return new ResponseEntity<>(speciesService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update_species")
    public ResponseEntity<Species> updateSpecies(@RequestBody Species species) {
        return new ResponseEntity<>(speciesService.updateSpecies(species), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_species")
    public void deleteSpecies(@RequestParam int id) {
        speciesService.deleteSpecies(id);
    }
}
