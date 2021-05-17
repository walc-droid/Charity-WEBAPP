package pl.coderslab.charity.app.user;

import pl.coderslab.charity.app.user.User;

public interface UserService {

    User findByUsername(String username);
    void saveUser (User user);

    boolean existsByName(String username);

    boolean existsByEmail(String email);

}