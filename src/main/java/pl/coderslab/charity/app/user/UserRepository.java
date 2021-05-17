package pl.coderslab.charity.app.user;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.app.user.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    boolean existsByUsername(String name);

    boolean existsByEmail(String email);
}
