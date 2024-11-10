package com.catchout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CatchOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchOutApplication.class, args);
    }

}
