package com.digitalinnovationone.springboot.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter @Setter @NoArgsConstructor
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("marco") @Bean
    public String marcoDBConnection() {
        System.out.println("DB Connection Marco");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for Marco";
    }

    @Profile("outro") @Bean
    public String outroDBConnection() {
        System.out.println("DB Connection Outro");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for Outro";
    }

}
