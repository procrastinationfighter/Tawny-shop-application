package pl.adamboguszewski.transaction.service.application;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

// [TODO]:
@EqualsAndHashCode(callSuper = true)
@Value
public class TransactionNotFoundException extends RuntimeException {

    UUID transactionId;

    public TransactionNotFoundException(UUID transactionId) {
        super("Transaction with id: " + transactionId + " not found.");
        this.transactionId = transactionId;
    }
}
