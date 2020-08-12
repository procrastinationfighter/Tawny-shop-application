package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository<Transaction> repository;

    public TransactionService(TransactionRepository<Transaction> repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAll();
    }

    public Optional<Transaction> getById(Long id) {
        return repository.getById(id);
    }

    public Optional<Transaction> createTransaction(TransactionDto dto) {
        return Optional.of(repository.save(new Transaction(dto)));
    }

    public Optional<Transaction> updateTransaction(Long id, TransactionDto dto) {
        Optional<Transaction> transaction = getById(id);
        if(transaction.isPresent()) {
            // [TODO]: Method for updating already existing transaction.
            return Optional.empty();
        }
        else {
            return createTransaction(dto);
        }
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }

    public List<Transaction> getAllOldTransactions(Long months) {
        LocalDateTime date = LocalDateTime.now().minusMonths(months);
        return repository.findByTransactionDateTimeBefore(date);
    }

    public void deleteOldTransactions(Long months) {
        for(Transaction transaction : getAllOldTransactions(months)) {
            deleteTransaction(transaction.getId());
        }
    }
}
