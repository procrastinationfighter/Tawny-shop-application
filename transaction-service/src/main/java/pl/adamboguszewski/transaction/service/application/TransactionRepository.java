package pl.adamboguszewski.transaction.service.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository<Transaction> {

    List<Transaction> getAll();
    Optional<Transaction> getById(Long id);
    Transaction save(Transaction fromDto);
    void deleteById(Long id);

    List<Transaction> findByTransactionDateTimeBefore(LocalDateTime boundaryDate);
}
