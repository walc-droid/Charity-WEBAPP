package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.entity.User;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService{

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByLogin(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        if(user == null) {
            throw new UsernameNotFoundException(login);
        }
        Set<GrantedAuthority> grantedAuthories = new HashSet<>();
        user.getRoles().forEach(r -> grantedAuthories.add(new SimpleGrantedAuthority(r.getName())));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),grantedAuthories);
    }
}
