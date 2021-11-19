package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.Animal;
import wildlife.care.model.AnimalVaccination;

@Repository
public interface AnimalVaccinationRepository extends JpaRepository<AnimalVaccination, Integer> {
    AnimalVaccination findById(int id);
}
