package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildlife.care.model.NationalPark;
import wildlife.care.model.Species;

@Repository
public interface NationalParkRepository extends JpaRepository<NationalPark, Integer> {
    NationalPark findById(int id);
    NationalPark findByName(String name);
}
