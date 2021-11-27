package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
    Vaccine findById(int id);
    Vaccine findByName(String name);
}
