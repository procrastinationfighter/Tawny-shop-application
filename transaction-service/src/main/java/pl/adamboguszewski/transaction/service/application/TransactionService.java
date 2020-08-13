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

    public GetTransactionDto getByTransactionId(UUID id) {
        return GetTransactionDto.fromTransaction(repository
                .getByTransactionId(id)
                .orElseThrow(TransactionNotFoundException::new));
    }

    public Optional<Transaction> createTransaction(CreateTransactionDto dto) {
        return Optional.of(repository.save(new Transaction(dto)));
    }

    public Optional<Transaction> updateTransaction(UUID id, CreateTransactionDto dto) {
        Optional<Transaction> transaction = repository.getByTransactionId(id);
        if (transaction.isPresent()) {
            // [TODO]: Method for updating already existing transaction.
            return Optional.empty();
        } else {
            return createTransaction(dto);
        }
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }

    public void deleteOldTransactions() {
        long months = 24L; // [TODO]: 010-manage-application-properties
        repository.deleteByTransactionDateTimeBefore(LocalDateTime.now().minusMonths(months));
    }
}
