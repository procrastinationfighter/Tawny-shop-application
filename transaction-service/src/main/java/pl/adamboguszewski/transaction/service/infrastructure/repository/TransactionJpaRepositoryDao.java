package pl.adamboguszewski.transaction.service.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adamboguszewski.transaction.service.application.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionJpaRepositoryDao extends JpaRepository<Transaction, Long>{

    Optional<Transaction> findById(Long id);

    Optional<Transaction> findByTransactionId(UUID transactionId);

    List<Transaction> findByTransactionDateTimeBefore(LocalDateTime date);
}
