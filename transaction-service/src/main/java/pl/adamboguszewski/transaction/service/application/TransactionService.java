package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    public List<Transaction> getAllTransactions() {
        return Collections.emptyList();
    }

    public Optional<Transaction> getByTransactionId(Long id) {
        return Optional.empty();
    }

    public Optional<Transaction> createTransaction(TransactionDto dto) {
        return Optional.of(Transaction.fromDto(dto));
    }

    public Optional<Transaction> updateTransaction(Long id, TransactionDto dto) {
        Optional<Transaction> transaction = getByTransactionId(id);
        if(transaction.isPresent()) {
            // [TODO]: Method for updating already existing transaction.
            return Optional.empty();
        }
        else {
            return createTransaction(dto);
        }
    }

    public void deleteTransaction(Long id) {

    }
}
