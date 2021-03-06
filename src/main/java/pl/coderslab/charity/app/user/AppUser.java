package pl.coderslab.charity.app.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "AppUser")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 12, message = "Imię musi posiadać od 3 do 12 znaków!")
    private String firstName;
    @Size(min = 3, max = 12, message = "Nazwisko musi posiadać od 3 do 12 znaków!")
    private String lastName;
    @Size(min = 3, max = 12, message = "Login musi posiadać od 3 do 12 znaków!")
    private String username;
    @Email
    private String email;

    private String password;
    private String passwordConfirm;

    private boolean locked = false;
    private boolean enabled = false;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;



    public AppUser (String firstName, String lastName, String username, String email, String password, AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    public AppUser() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.toString());
        return Collections.singletonList(authority);

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public AppUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AppUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AppUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AppUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AppUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public AppUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public AppUser setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
        return this;
    }

    public boolean isLocked() {
        return locked;
    }

    public AppUser setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public AppUser setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public AppUser setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
        return this;
    }
}
