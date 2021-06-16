package pl.coderslab.charity.app.user.role;

import pl.coderslab.charity.app.user.AppUser;
import pl.coderslab.charity.app.user.privilege.Privilege;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<AppUser> users;

    @ManyToMany
    private Collection<Privilege> privileges;
}