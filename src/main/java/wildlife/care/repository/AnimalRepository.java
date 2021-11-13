package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Animal findById(int id);
}
