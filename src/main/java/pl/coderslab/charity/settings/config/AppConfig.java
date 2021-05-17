package pl.coderslab.charity.settings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.charity.settings.converter.CategoryConverter;

@Configuration
@ComponentScan(basePackages = {"pl.coderslab"})
public class AppConfig implements WebMvcConfigurer {


    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(getCategoryConverter());
    }


    @Bean
    public CategoryConverter getCategoryConverter() {
        return new CategoryConverter();
    }

}
