package pl.coderslab.charity.app.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.app.donation.Donation;



@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM (q.quantity) FROM Donation q")
    Long quantityOfBags();
}
