package wildlife.care.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wildlife.care.model.Animal;
import wildlife.care.model.AnimalVaccination;
import wildlife.care.service.AnimalService;
import wildlife.care.service.VaccineService;
import wildlife.care.web.model.AnimalDto;
import wildlife.care.web.model.AnimalVaccinationDto;

@Component
public class AnimalVaccinationConverter {

    @Autowired
    AnimalService animalService;

    @Autowired
    VaccineService vaccineService;

    public AnimalVaccination toDomainModel(AnimalVaccinationDto animalVaccinationDto) {
        int animalId = animalService.getAnimalByNameAndSpecies(animalVaccinationDto.getAnimal()).getId();
        int vaccineId = vaccineService.findByName(animalVaccinationDto.getVaccine()).getId();
        return new AnimalVaccination(animalVaccinationDto.getId(), vaccineId, animalId, animalVaccinationDto.getDate(), animalVaccinationDto.getDoze());
    }

    public AnimalVaccinationDto toDto(AnimalVaccination animalVaccination) {
        String animalName = animalService.findById(animalVaccination.getAnimal()).getName();
        String vaccineName = vaccineService.findById(animalVaccination.getVaccine()).getName();
        return new AnimalVaccinationDto(animalVaccination.getId(), vaccineName, animalName, animalVaccination.getDate(), animalVaccination.getDoze());
    }
}
