package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Worker;
import wildlife.care.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public List<Worker> findAll() {
        return workerRepository.findAll();
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
}
