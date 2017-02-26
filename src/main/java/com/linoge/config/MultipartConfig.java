package com.linoge.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created by Timo on 13.02.2017.
 */
@Configuration
public class MultipartConfig {

    private static final String FILE_SIZE = "2048KB";

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(FILE_SIZE);
        factory.setMaxRequestSize(FILE_SIZE);
        return factory.createMultipartConfig();
    }
}
