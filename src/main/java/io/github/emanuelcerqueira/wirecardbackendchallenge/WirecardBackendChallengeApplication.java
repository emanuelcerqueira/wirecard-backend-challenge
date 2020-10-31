package io.github.emanuelcerqueira.wirecardbackendchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class WirecardBackendChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WirecardBackendChallengeApplication.class, args);
    }

}
