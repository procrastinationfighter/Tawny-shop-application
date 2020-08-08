package pl.adamboguszewski.transaction.service.infrastructure.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.adamboguszewski.transaction.service.application.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    Optional<Transaction> findById(Long id);

    List<Transaction> findByTransactionInformation_TransactionDateTime_DateBefore(LocalDate date);
}
