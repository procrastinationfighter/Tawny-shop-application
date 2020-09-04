package pl.adamboguszewski.transaction.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionRepository;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;
import pl.adamboguszewski.transaction.service.infrastructure.config.TransactionConfig;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @MockBean
    TransactionRepository<Transaction> repository;

    @MockBean
    TransactionConfig config;

    @InjectMocks
    TransactionService service;

    @Test
    public void givenCreateDto_whenCreateTransaction_thenReturnTransaction() {
        CreateTransactionDto dto = createSampleCreateDto();
        Transaction transaction = new Transaction(dto);

        when(repository.save(any(Transaction.class))).thenReturn(new Transaction(dto));

        assertEquals(transaction.getTransactionId(), service.createTransaction(dto).getTransactionId());
    }

    private CreateTransactionDto createSampleCreateDto() {
        return CreateTransactionDto.fromRequest(createSampleCreateRequest());
    }

    private CreateTransactionRequest createSampleCreateRequest() {
        return new CreateTransactionRequest(
                UUID.randomUUID(),
                10000L,
                new CreateTransactionRequest.TransactionInformation(
                        "checkout no. 15",
                        Collections.singletonList(new CreateTransactionRequest.TransactionInformation.PaymentInformation(
                                10000L, 1L, "eur", "card"
                        ))
                ),
                Collections.singletonList(new CreateTransactionRequest.TransactionProduct(
                        UUID.randomUUID(),
                        "kubek",
                        10000L,
                        1L,
                        1L,
                        "do picia",
                        "naczynie"
                )),
                LocalDateTime.now()
        );
    }
}
