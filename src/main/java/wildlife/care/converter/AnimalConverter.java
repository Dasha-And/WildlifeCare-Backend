package wildlife.care.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wildlife.care.model.Animal;
import wildlife.care.service.SpeciesService;
import wildlife.care.web.model.AnimalDto;

@Component
public class AnimalConverter {

    @Autowired
    SpeciesService speciesService;

    public Animal toDomainModel(AnimalDto animalDto) {
        int speciesId = speciesService.getIdByName(animalDto.getSpecies());
        return new Animal(animalDto.getId(), animalDto.getName(), animalDto.getDate_of_birth(), speciesId, animalDto.getNational_park_id());
    }

    public AnimalDto toDto(Animal animal) {
        String speciesName = speciesService.getNameById(animal.getSpecies());
        return new AnimalDto(animal.getId(), animal.getName(), animal.getDate_of_birth(), speciesName, animal.getNational_park_id());
    }
}
