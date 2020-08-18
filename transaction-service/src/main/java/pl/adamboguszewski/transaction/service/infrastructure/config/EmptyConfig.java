package pl.adamboguszewski.transaction.service.infrastructure.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("transaction.months")
@Value
public class EmptyConfig {

    Long months;
}
