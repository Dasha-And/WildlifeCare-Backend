package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Vaccine;
import wildlife.care.repository.VaccineRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }

    public Vaccine findById(int id) {
        return vaccineRepository.findById(id);
    }

    public Vaccine insertVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public Vaccine updateVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public void deleteVaccine(int id) {
        vaccineRepository.deleteById(id);

    }

    public Vaccine findByName(String name) {
        return vaccineRepository.findByName(name);
    }
}
