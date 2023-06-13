package com.rest.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	System.out.println("configured succefully");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Add the appropriate origin URL(s) here
                .allowedMethods("*") // Add the allowed HTTP methods
                .allowedHeaders("*") // Add the allowed headers
                .allowCredentials(true); // Allow credentials (e.g., cookies, authorization headers) 
    }
}
