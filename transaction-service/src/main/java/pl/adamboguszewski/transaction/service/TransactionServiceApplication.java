package pl.adamboguszewski.transaction.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.adamboguszewski.transaction.service.infrastructure.config.EmptyConfig;

@SpringBootApplication
@EnableConfigurationProperties(EmptyConfig.class)
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }
}