package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.model.NationalPark;
import wildlife.care.service.NationalParkService;

import java.util.List;

@RestController
public class NationalParkController {

    @Autowired
    NationalParkService nationalParkService;

    @GetMapping(path = "/nationalParks")
    public List<NationalPark> findAll() {
        return nationalParkService.findAll();
    }

    @PostMapping(path = "/create_nationalPark")
    public ResponseEntity<NationalPark> insert(@RequestBody NationalPark nationalPark) {
        return new ResponseEntity<>(nationalParkService.insertNationalPark(nationalPark), HttpStatus.CREATED);
    }

    @GetMapping(path = "/nationalPark")
    public ResponseEntity<NationalPark> findById(@RequestParam int id) {
        return new ResponseEntity<>(nationalParkService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update_nationalPark")
    public ResponseEntity<NationalPark> updateNationalPark(@RequestBody NationalPark nationalPark) {
        return new ResponseEntity<>(nationalParkService.updateNationalPark(nationalPark), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_nationalPark")
    public void deleteNationalPark(@RequestParam int id) {
        nationalParkService.deleteNationalPark(id);
    }
}
