package pl.adamboguszewski.transaction.service.service.api.transaction;

import lombok.Value;

@Value
public class CreateTransactionFailureResponse implements CreateTransactionResponse {

    ErrorType errorType;

    public enum ErrorType {
        UNSUCCESSFUL_PAYMENT,
        DATABASE_CONNECTION_FAILED
    }
}
