package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;
import pl.adamboguszewski.transaction.service.application.dto.GetTransactionDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository<Transaction> repository;

    public TransactionService(TransactionRepository<Transaction> repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAll();
    }

    public Optional<GetTransactionDto> getByTransactionId(UUID id) {
        Optional<Transaction> transaction = repository.getByTransactionId(id);
        // [TODO]: Exception when transaction not found.
        return transaction.map(GetTransactionDto::fromTransaction);
    }

    public Optional<Transaction> createTransaction(CreateTransactionDto dto) {
        return Optional.of(repository.save(new Transaction(dto)));
    }

    public Optional<Transaction> updateTransaction(UUID id, CreateTransactionDto dto) {
        Optional<Transaction> transaction = repository.getByTransactionId(id);
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
