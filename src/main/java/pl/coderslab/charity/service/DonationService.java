package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public void save(Donation donation) {
        this.donationRepository.save(donation);
    }

    public void delete(Long id) {
        this.donationRepository.deleteById(id);
    }

    public Donation findById(Long id) {
        return this.donationRepository.getById(id);
    }

    public List<Donation> findAll() {
        return this.donationRepository.findAll();
    }

}
