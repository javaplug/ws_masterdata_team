package com.spark.masterdata.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories // (basePackages = "com.spark.masterdata.team.repository")
// @EntityScan(basePackages = "com.spark.masterdata.team.entity")
@SpringBootApplication
public class MasterdataTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterdataTeamApplication.class, args);
    }
}
