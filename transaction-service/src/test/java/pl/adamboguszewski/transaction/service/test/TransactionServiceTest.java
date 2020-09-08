package pl.adamboguszewski.transaction.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionNotFoundException;
import pl.adamboguszewski.transaction.service.application.TransactionRepository;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;
import pl.adamboguszewski.transaction.service.infrastructure.config.TransactionConfig;
import pl.adamboguszewski.transaction.service.infrastructure.repository.TransactionJpaRepository;
import pl.adamboguszewski.transaction.service.infrastructure.repository.TransactionJpaRepositoryDao;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @MockBean
    private TransactionRepository<Transaction> repository;

    @Autowired
    private TransactionService service;

    @Test
    public void givenCreateDto_whenCreateTransaction_thenReturnTransaction() {
        CreateTransactionDto dto = createSampleCreateDto();
        Transaction transaction = new Transaction(dto);

        when(repository.save(any(Transaction.class))).thenReturn(new Transaction(dto));

        assertEquals(transaction.getTransactionId(), service.createTransaction(dto).getTransactionId());
    }

    @Test
    public void givenTransactionId_whenGetByTransactionId_thenReturnTransaction() {
        Transaction transaction = new Transaction(createSampleCreateDto());

        when(repository.getByTransactionId(any(UUID.class))).thenReturn(Optional.of(transaction));

        assertEquals(transaction.getTransactionId(), service.getByTransactionId(transaction.getTransactionId()).getTransactionId());
    }

    @Test
    public void givenTransactionId_whenGetByTransactionId_thenThrowException() {
        when(repository.getByTransactionId(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(TransactionNotFoundException.class, () -> service.getByTransactionId(UUID.randomUUID()));
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
