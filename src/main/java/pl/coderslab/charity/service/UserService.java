package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

public interface UserService {

    User findByUsername(String username);
    void saveUser (User user);

    boolean existsByName(String username);

    boolean existsByEmail(String email);

}
