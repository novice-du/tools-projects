package com.uwjx.dbpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbPoolTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbPoolTestingApplication.class, args);
    }

}
