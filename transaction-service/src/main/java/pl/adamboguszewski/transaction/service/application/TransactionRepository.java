package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    Optional<Transaction> findById(Long id);
}
