package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public void save(User user) {
        this.userRepository.save(user);
    }
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    public User findByid (Long id) {
        return this.userRepository.findById(id).orElse(null);
    }




}
