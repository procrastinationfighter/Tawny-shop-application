package pl.adamboguszewski.transaction.service.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionRepository;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.infrastructure.config.TransactionConfig;

@SpringBootTest
class TransactionServiceTest {

    @MockBean
    TransactionRepository<Transaction> repository;

    @MockBean
    TransactionConfig config;

    @InjectMocks
    TransactionService service;


}
