package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class CreateUnsuccessfulTransactionResponse extends CreateTransactionResponse {

    ErrorType errorType;

    public enum ErrorType {
        UNSUCCESSFUL_PAYMENT,
        DATABASE_CONNECTION_FAILED
    }
}
