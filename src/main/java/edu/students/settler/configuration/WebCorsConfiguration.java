package edu.students.settler.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static java.util.Collections.singletonList;

@Configuration
public class WebCorsConfiguration {

    @Bean
    public CorsFilter getCorsFilter(@Value("${server.web.cors.path}") String corsPath) {
        return new CorsFilter(formUrlBasedCorsConfig(corsPath));
    }

    private UrlBasedCorsConfigurationSource formUrlBasedCorsConfig(String corsPath) {
        UrlBasedCorsConfigurationSource urlBasedCorsConfig = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfig.registerCorsConfiguration(corsPath, formCorsConfig());

        return urlBasedCorsConfig;
    }

    private CorsConfiguration formCorsConfig() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(singletonList(CorsConfiguration.ALL));
        corsConfig.setAllowedHeaders(singletonList(CorsConfiguration.ALL));
        corsConfig.setAllowedMethods(singletonList(CorsConfiguration.ALL));
        corsConfig.setAllowCredentials(Boolean.TRUE);

        return corsConfig;
    }
}
