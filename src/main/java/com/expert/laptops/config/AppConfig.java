package com.expert.laptops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

/**
 * Class configuration
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * @return Java8TimeDialect is for date in Thymeleaf
     */
    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }

}
