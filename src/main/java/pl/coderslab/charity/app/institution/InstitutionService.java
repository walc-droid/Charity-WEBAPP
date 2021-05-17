package pl.coderslab.charity.app.institution;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.app.institution.Institution;
import pl.coderslab.charity.app.institution.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public void save(Institution institution) {
        this.institutionRepository.save(institution);
    }

    public void delete(Long id) {
        this.institutionRepository.deleteById(id);
    }

    public Institution findById(Long id) {
        return this.institutionRepository.findById(id).orElse(null);
    }

    public List<Institution> findAll() {
        return this.institutionRepository.findAll();
    }

    public List<Institution> findTop4() {
        return this.institutionRepository.findTop4By();
    }


}
