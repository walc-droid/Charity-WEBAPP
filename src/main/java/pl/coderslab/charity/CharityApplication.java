package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.coderslab.charity.app.user.UserRepository;

@SpringBootApplication
public class CharityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

}
