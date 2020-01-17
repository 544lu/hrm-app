package com.tpl.hrmapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tpl.hrmapp.repository")
@EntityScan("com.tpl.hrmapp.domain")
public class HrmAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmAppApplication.class, args);
    }

}
