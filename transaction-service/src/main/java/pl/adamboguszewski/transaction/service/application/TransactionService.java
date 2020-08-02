package pl.adamboguszewski.transaction.service.application;

import org.springframework.stereotype.Service;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionResponse;

import java.util.ArrayList;
import java.util.List;

// [TODO] Fill the details of this class.
@Service
public class TransactionService {

    public List<Transaction> getAll() {
        return new ArrayList<>();
    }

    public Transaction getById(Long id) {
        return null;
    }

    public Transaction createTransaction(CreateTransactionRequest request) {
        return null;
    }

    public void replaceTransaction(Long id) {

    }

    public void deleteTransaction(Long id) {

    }
}
