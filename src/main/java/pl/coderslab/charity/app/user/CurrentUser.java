//package pl.coderslab.charity.app.user;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//
//import java.util.Collection;
//
//public class CurrentUser extends User {
//
//    private final pl.coderslab.charity.app.user.User user;
//
//
//    public CurrentUser(String firstName,String lastName, String username, String email, String password,
//                       Collection<? extends GrantedAuthority> authorities,
//                       pl.coderslab.charity.app.user.User user)
//    {
//        super(username, password, authorities);
//        this.user = user;
//    }
//    public pl.coderslab.charity.app.user.User getUser() {
//        return user;
//    }
//
//}
