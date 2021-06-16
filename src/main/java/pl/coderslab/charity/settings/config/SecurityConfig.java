package pl.coderslab.charity.settings.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.app.user.AppUserService;

//import pl.coderslab.charity.service.SpringSecurity;
//import pl.coderslab.charity.app.user.SpringDataUserDetailsService;




@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final PasswordEncoder encoder;

    public SecurityConfig(AppUserService appUserService, PasswordEncoder encoder) {
        this.appUserService = appUserService;
        this.encoder = encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/donation/add").hasAnyRole("USER")
                .antMatchers("/").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
//                .failureUrl("/login?error")
                .and().logout()
                .logoutSuccessUrl("/")
                .and().exceptionHandling()
                .accessDeniedPage("/403");
    }

    @Override
    public void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserService);
        provider.setPasswordEncoder(encoder);
        return provider;
    }








}



