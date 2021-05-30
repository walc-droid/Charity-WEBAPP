package pl.coderslab.charity.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername (String username);
    AppUser getByEmail(String email);
    boolean existsByUsername (String username);
    boolean existsByEmail (String email);
}
