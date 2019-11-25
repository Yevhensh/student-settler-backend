package edu.students.settler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertyConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer getConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
