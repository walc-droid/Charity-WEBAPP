package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

public interface UserService {

    User findByLogin (String name);
    void saveUser (User user);

}
