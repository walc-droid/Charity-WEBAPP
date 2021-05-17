package pl.coderslab.charity.app.donation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.app.donation.Donation;
import pl.coderslab.charity.app.donation.DonationRepository;

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
        return this.donationRepository.findById(id).orElse(null);
    }

    public List<Donation> findAll() {
        return this.donationRepository.findAll();
    }

    public Long quantityOfBags() {
        return this.donationRepository.quantityOfBags();
    }

    public Long donationsCount() {
        return this.donationRepository.count();
    }

}
