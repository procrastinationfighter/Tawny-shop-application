package pl.adamboguszewski.transaction.service.api.transaction;

import lombok.Value;

@Value
public class CreateTransactionFailureResponse implements CreateTransactionResponse {

    String message;
    Long errorCode;
}
