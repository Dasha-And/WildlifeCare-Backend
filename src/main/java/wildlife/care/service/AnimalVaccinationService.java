package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Animal;
import wildlife.care.model.AnimalVaccination;
import wildlife.care.repository.AnimalRepository;
import wildlife.care.repository.AnimalVaccinationRepository;
import wildlife.care.repository.VaccineRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalVaccinationService {

    String YEAR = "year";
    String HALFYEAR = "halfyear";

    @Autowired
    VaccineRepository vaccineRepository;

    public Date nextVaccinationDate(Date lastVaccination, int vaccineId) {
        String periodicity = vaccineRepository.findById(vaccineId).getPeriodicity();
        Date nextVaccination;
        LocalDate ld = lastVaccination.toLocalDate();
        if (periodicity.equals(YEAR)) {
            nextVaccination = Date.valueOf(ld.plusYears(1));
        } else if (periodicity.equals(HALFYEAR)) {
            nextVaccination = Date.valueOf(ld.plusMonths(6));
        } else {
            String[] periodicityParsed = periodicity.split(" ");
            int numberOfYears = Integer.parseInt(periodicityParsed[0]);
            nextVaccination = Date.valueOf(ld.plusYears(numberOfYears));
        }
        return nextVaccination;
    }

    @Autowired
    AnimalVaccinationRepository animalVaccinationRepository;

    public List<AnimalVaccination> findAll() {
        return animalVaccinationRepository.findAll();
    }

    public AnimalVaccination findById(int id) {
        return animalVaccinationRepository.findById(id);
    }

    public AnimalVaccination insertAnimalVaccination(AnimalVaccination animalVaccination) {
        return animalVaccinationRepository.save(animalVaccination);
    }

    public AnimalVaccination updateAnimalVaccination(AnimalVaccination animalVaccination) {
        return animalVaccinationRepository.save(animalVaccination);
    }

    public void deleteAnimalVaccination(int id) {
        animalVaccinationRepository.deleteById(id);
    }
}
