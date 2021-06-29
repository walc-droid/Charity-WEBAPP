package pl.coderslab.charity.app.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "%s not found";

    private final AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return this.appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,username)));

    }




    public void registerAppUser(AppUser user) {

        boolean userExists = appUserRepository.findByUsername(user.getUsername()).isPresent();


        if (userExists) {
            throw new IllegalStateException("username already taken");
        }


        user.setAppUserRole(AppUserRole.ROLE_USER);
        user.setEnabled(true);

        this.appUserRepository.save(user);
    }



    public void save (AppUser appUser) {
        this.appUserRepository.save(appUser);
    }


    public void enableAppUser(String username) {
        AppUser appUser = this.appUserRepository.findByUsername(username).orElseThrow(null);
        appUser.setEnabled(true);
        this.appUserRepository.save(appUser);
    }


    public boolean existByUsername(String username) {
        return this.appUserRepository.existsByUsername(username);
    }

    public boolean existByEmail(String email) {
        return this.appUserRepository.existsByEmail(email);
    }

    public List<AppUser> findAll() {
        return this.appUserRepository.findAll();
    }

}
