package pl.adamboguszewski.transaction.service.infrastructure.repository;

import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransactionJpaRepository implements TransactionRepository<Transaction> {

    private final TransactionJpaRepositoryDao transactionJpaRepositoryDao;


    public TransactionJpaRepository(TransactionJpaRepositoryDao transactionJpaRepositoryDao) {
        this.transactionJpaRepositoryDao = transactionJpaRepositoryDao;
    }

    public List<Transaction> getAll() {
        return transactionJpaRepositoryDao.findAll();
    }

    public Optional<Transaction> getById(Long id) {
        return transactionJpaRepositoryDao.findById(id);
    }

    public Optional<Transaction> getByTransactionId(UUID transactionId) {
        return transactionJpaRepositoryDao.findByTransactionId(transactionId);
    }

    public Transaction save(Transaction transaction) {
        return transactionJpaRepositoryDao.save(transaction);
    }

    public void deleteByTransactionId(UUID id) {
        transactionJpaRepositoryDao.deleteByTransactionId(id);
    }

    public void deleteByTransactionDateTimeBefore(LocalDateTime date) {
        transactionJpaRepositoryDao.deleteByTransactionDateTimeBefore(date);
    }
}
