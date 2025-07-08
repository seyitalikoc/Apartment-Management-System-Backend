package com.seyitkoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.seyitkoc")
public class AmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmsApplication.class, args);
    }

}
