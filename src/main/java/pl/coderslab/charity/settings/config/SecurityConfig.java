package pl.coderslab.charity.settings.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.charity.app.user.SpringDataUserDetailsService;

//import pl.coderslab.charity.service.SpringSecurity;
//import pl.coderslab.charity.app.user.SpringDataUserDetailsService;




@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/donation/add").hasAnyRole("USER")
                .antMatchers("/").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and().logout().logoutSuccessUrl("/")
                .permitAll();
//                .failureUrl("/login?error")
//                .and().logout()
//                .logoutSuccessUrl("/")
//                .and().exceptionHandling()
//                .accessDeniedPage("/403");
    }



    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }




}



