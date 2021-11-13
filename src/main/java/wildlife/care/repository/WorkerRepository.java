package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.Species;
import wildlife.care.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findById(int id);
}
