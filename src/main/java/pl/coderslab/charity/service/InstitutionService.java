package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public void save (Institution institution) {
        this.institutionRepository.save(institution);
    }

    public void delete(Long id) {
        this.institutionRepository.deleteById(id);
    }

    public Institution findById(Long id) {
        return this.institutionRepository.getById(id);
    }

    public List<Institution> findAll() {
        return this.institutionRepository.findAll();
    }

}
