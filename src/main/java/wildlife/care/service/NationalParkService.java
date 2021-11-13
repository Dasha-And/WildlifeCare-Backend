package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.NationalPark;
import wildlife.care.repository.NationalParkRepository;

import java.util.List;

@Service
public class NationalParkService {

    @Autowired
    NationalParkRepository nationalParkRepository;

    public List<NationalPark> findAll() {
        return nationalParkRepository.findAll();
    }

    public NationalPark findById(int id) {
        return nationalParkRepository.findById(id);
    }

    public NationalPark insertNationalPark(NationalPark nationalPark) {
        return nationalParkRepository.save(nationalPark);
    }

    public NationalPark updateNationalPark(NationalPark nationalPark) {
        return nationalParkRepository.save(nationalPark);
    }

    public void deleteNationalPark(int id) {
        nationalParkRepository.deleteById(id);
    }
}
