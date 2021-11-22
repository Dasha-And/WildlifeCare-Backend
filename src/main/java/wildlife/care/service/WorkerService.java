package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Worker;
import wildlife.care.repository.WorkerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public List<Worker> findAllFromNationalPark(int nationalParkId) {
        return workerRepository.findWorkersByNationalParkId(nationalParkId);
    }

    public List<Worker> findAllByPosition(String role) {
        return workerRepository.getAllByRole(role);
    }

    public Worker findById(int id) {
        return workerRepository.findById(id);
    }

    public Worker insertWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public void deleteWorker(int id) {
        workerRepository.deleteById(id);
    }

    public double theShortestDistance(double latitudeOfAnimal, double longitudeOfAnimal, Map<Double, Double> allRangersCoordinates) {

        final int R = 6371; // Radius of the earth
        ArrayList<Double> distances = new ArrayList<>();
        for (Map.Entry<Double, Double> entry : allRangersCoordinates.entrySet()) {
            double lat = entry.getKey();
            double lon = entry.getValue();
            double latDistance = Math.toRadians(lat - latitudeOfAnimal);
            double lonDistance = Math.toRadians(lon - longitudeOfAnimal);
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(latitudeOfAnimal)) * Math.cos(Math.toRadians(lat))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c * 1000; // convert to meters
            distances.add(distance);
        }
        List<Double> sortedDistances = distances.stream().sorted().collect(Collectors.toList());
        return sortedDistances.get(0);
    }

}
