package pl.adamboguszewski.transaction.service.application;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

// [TODO]:
@EqualsAndHashCode(callSuper = true)
@Value
public class TransactionNotFoundException extends RuntimeException {

    UUID id;

    public TransactionNotFoundException(UUID id) {
        super("Transaction with id: " + id + " not found.");
        this.id = id;
    }
}
