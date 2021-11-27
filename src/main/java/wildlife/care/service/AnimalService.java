package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Animal;
import wildlife.care.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public List<Animal> findAllFromNationalPark(int nationalParkId) {
        return animalRepository.findAnimalsByNationalParkId(nationalParkId);
    }

    public Animal findById(int id) {
        return animalRepository.findById(id);
    }

    public Animal insertAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public Animal getAnimalByNameAndSpecies(String name) {
        return animalRepository.findAnimalByName(name);
    }
}
