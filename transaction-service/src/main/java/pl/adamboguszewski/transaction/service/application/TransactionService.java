package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

// [TODO] Fill the details of this class.
@Service
public class TransactionService {

    public List<Transaction> getAll() {
        return Collections.emptyList();
    }

    public Optional<Transaction> getById(Long id) {
        return Optional.empty();
    }

    public Optional<Transaction> createTransaction(TransactionDto dto) {
        return Optional.of(Transaction.fromDto(dto));
    }

    public void replaceTransaction(Long id) {

    }

    public void deleteTransaction(Long id) {

    }
}
