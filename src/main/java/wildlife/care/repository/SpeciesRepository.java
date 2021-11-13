package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findById(int id);
    Species findByName(String name);
}
