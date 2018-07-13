package com.spark.masterdata.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MasterdataTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterdataTeamApplication.class, args);
    }
}
