package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Animal findById(int id);
    List<Animal> findAnimalsByNationalParkId(int nationalParkId);
}
