package com.example.almgroupproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AlmGroupProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlmGroupProjectApplication.class, args);
    }

}
