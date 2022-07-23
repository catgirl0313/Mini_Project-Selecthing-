package com.sparta.selecthing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SelecthingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelecthingApplication.class, args);
    }

}
