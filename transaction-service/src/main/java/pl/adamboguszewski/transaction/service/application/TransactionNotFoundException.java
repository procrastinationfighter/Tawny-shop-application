package pl.adamboguszewski.transaction.service.application;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Value
public class TransactionNotFoundException extends RuntimeException {

    UUID transactionId;

    public TransactionNotFoundException(UUID transactionId) {
        //[TODO]: Separate this message and default message.
        super("Transaction with id: " + transactionId + " not found.");
        this.transactionId = transactionId;
    }
}
