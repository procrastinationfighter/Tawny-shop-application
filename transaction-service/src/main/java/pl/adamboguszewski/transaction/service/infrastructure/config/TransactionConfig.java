package pl.adamboguszewski.transaction.service.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "transaction")
@Data
public class TransactionConfig {

    Long months;
}
