package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;

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

    public Transaction createTransaction(CreateTransactionRequest request) {
        return Transaction.fromRequest(request);
    }

    public void replaceTransaction(Long id) {

    }

    public void deleteTransaction(Long id) {

    }
}
