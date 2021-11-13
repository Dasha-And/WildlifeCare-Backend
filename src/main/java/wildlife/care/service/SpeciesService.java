package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Species;
import wildlife.care.repository.SpeciesRepository;

import java.util.List;

@Service
public class SpeciesService {

    @Autowired
    SpeciesRepository speciesRepository;

    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    public Species findById(int id) {
        return speciesRepository.findById(id);
    }

    public Species insertSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public Species updateSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public void deleteSpecies(int id) {
        speciesRepository.deleteById(id);
    }

    public String getNameById(int id) {
        return speciesRepository.findById(id).getName();
    }

    public int getIdByName(String name) {
        return speciesRepository.findByName(name).getId();
    }

    public String getIconUrlByName(String name) {
        return speciesRepository.findByName(name).getIcon_url();
    }
}
