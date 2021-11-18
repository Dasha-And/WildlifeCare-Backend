package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.model.Worker;
import wildlife.care.service.WorkerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping(path = "/worker_all")
    public List<Worker> findAll() {
        return workerService.findAll();
    }

    @GetMapping(path = "/workers/{position}")
    public List<Worker> findAll(@PathVariable String position) {
        return workerService.findAllByPosition(position);
    }

    @PostMapping(path = "/create_worker")
    public ResponseEntity<Worker> insert(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerService.insertWorker(worker), HttpStatus.CREATED);
    }

    @GetMapping(path = "/worker")
    public ResponseEntity<Worker> findById(@RequestParam int id) {
        return new ResponseEntity<>(workerService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update_worker")
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerService.updateWorker(worker), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_worker")
    public void deleteWorker(@RequestParam int id) {
        workerService.deleteWorker(id);
    }

    @GetMapping(path = "/shortest_distance")
    public double getShortestDistance(@RequestParam double lat, @RequestParam double lon) {
        Map<Double, Double> coodrinates = new HashMap<>();
        coodrinates.put(50.013179230930724, 36.22686706427211);
        coodrinates.put(50.03690272382028, 36.23191758161718);
        return this.workerService.theShortestDistance(lat, lon, coodrinates);
    }
}

