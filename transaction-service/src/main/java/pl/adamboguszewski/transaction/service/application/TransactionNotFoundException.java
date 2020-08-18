package pl.adamboguszewski.transaction.service.application;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Value
public class TransactionNotFoundException extends RuntimeException {

    UUID transactionId;

    String customizedMessage;

    public TransactionNotFoundException(UUID transactionId) {
        //[TODO]: Separate this message and default message.
        super();
        this.transactionId = transactionId;
        this.customizedMessage = "Transaction with id: " + transactionId + " not found.";
    }
}
