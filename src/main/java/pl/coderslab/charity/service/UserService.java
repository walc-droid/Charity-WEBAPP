package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    public User findByid (Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findByLogin (String login) {
        return this.userRepository.findByLogin(login);
    }

    public User findByEmail (String email) {
        return this.userRepository.findByEmail(email);
    }

    public boolean existsByLogin (String login) {
        return this.userRepository.existsByLogin(login);
    }

    public boolean existsByEmail (String email) {
        return this.userRepository.existsUserByEmail(email);
    }

}
