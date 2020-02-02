package com.tpl.hrmapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tpl.hrmapp.repository")
@EntityScan("com.tpl.hrmapp.domain")
@EnableTransactionManagement
public class HrmAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmAppApplication.class, args);
    }

}
