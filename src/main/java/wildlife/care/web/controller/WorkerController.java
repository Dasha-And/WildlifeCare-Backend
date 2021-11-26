package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.converter.WorkerConverter;
import wildlife.care.exceptions.UserIsNotRegistered;
import wildlife.care.exceptions.WrongPasswordException;
import wildlife.care.model.Worker;
import wildlife.care.model.LoginForm;
import wildlife.care.service.RoleService;
import wildlife.care.service.WorkerService;
import wildlife.care.web.model.WorkerDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @Autowired
    RoleService roleService;

    @Autowired
    WorkerConverter workerConverter;

    @GetMapping(path = "{nationalParkId}/workers")
    public List<WorkerDto> findAll(@PathVariable int nationalParkId) {
        return workerService.findAllFromNationalPark(nationalParkId).stream().map(el -> workerConverter.toDto(el)).filter(el -> !el.getRole().equals("ROLE_SUPERADMIN") && !el.getRole().equals("ROLE_ADMIN")).collect(Collectors.toList());
    }

    @PostMapping(path = "/create_worker")
    public ResponseEntity<WorkerDto> insert(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerConverter.toDto(workerService.insertWorker(worker)), HttpStatus.CREATED);
    }

    @GetMapping(path = "/worker")
    public ResponseEntity<WorkerDto> findById(@RequestParam int id) {
        return new ResponseEntity<>(workerConverter.toDto(workerService.findById(id)), HttpStatus.OK);
    }

    @PutMapping(path = "/update_worker")
    public ResponseEntity<WorkerDto> updateWorker(@RequestBody WorkerDto workerDto) {
        return new ResponseEntity<>(workerConverter.toDto(workerService.updateWorker(workerConverter.toDomainModel(workerDto))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_worker")
    public void deleteWorker(@RequestParam int id) {
        workerService.deleteWorker(id);
    }

    @GetMapping(path = "/get_worker_icon_url")
    public ResponseEntity<String> getIconUrl(@RequestParam int id) {
        System.out.println(workerService.findById(id).getRole());
        System.out.println(workerConverter
                .toDto(workerService
                        .findById(id))
                .getRole());
        System.out.println();
        return new ResponseEntity<>(roleService
                .getIconUrlByName(workerConverter
                        .toDto(workerService
                                .findById(id))
                        .getRole()), HttpStatus.OK);
    }

    @GetMapping(path = "/shortest_distance")
    public double getShortestDistance(@RequestParam double lat, @RequestParam double lon) {
        Map<Double, Double> coodrinates = new HashMap<>();
        coodrinates.put(50.013179230930724, 36.22686706427211);
        coodrinates.put(50.03690272382028, 36.23191758161718);
        return this.workerService.theShortestDistance(lat, lon, coodrinates);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<WorkerDto> login(@RequestBody LoginForm userLoginForm) throws WrongPasswordException, UserIsNotRegistered {
        Worker user = workerService.getWorkerDetailsByUsername(userLoginForm.getUsername());
        if (user != null && user.getPassword().equals(userLoginForm.getPassword())) {
            return new ResponseEntity<>(workerConverter.toDto(user), HttpStatus.OK);
        } if (user != null && !user.getPassword().equals(userLoginForm.getPassword())) {
            throw new WrongPasswordException("Wrong password");
        } else {
            throw new UserIsNotRegistered("User with such login does not exist");
        }
    }
}

