package pl.adamboguszewski.transaction.service.infrastructure.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TransactionJpaRepositoryFactoryBean {

    @Bean
    TransactionJpaRepository transactionJpaRepository(TransactionJpaRepositoryDao transactionJpaRepositoryDao) {
        return new TransactionJpaRepository(transactionJpaRepositoryDao);
    }
}
