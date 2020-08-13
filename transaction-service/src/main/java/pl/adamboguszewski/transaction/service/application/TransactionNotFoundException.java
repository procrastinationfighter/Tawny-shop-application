package pl.adamboguszewski.transaction.service.application;

import java.util.UUID;

// [TODO]:
public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(UUID id) {
        super("Transaction with id: " + id + " not found.");
    }
}
