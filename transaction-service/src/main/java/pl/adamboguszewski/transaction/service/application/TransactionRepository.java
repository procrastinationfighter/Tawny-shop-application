package pl.adamboguszewski.transaction.service.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository<Transaction> {

    List<Transaction> getAll();
    Optional<Transaction> getById(Long id);
    Optional<Transaction> getByTransactionId(UUID transactionId);
    Transaction save(Transaction fromDto);
    void deleteById(Long id);

    //[TODO]: Test and check if deleting works.
    void deleteByTransactionDateTimeBefore(LocalDateTime boundaryDate);
}
