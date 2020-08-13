package pl.adamboguszewski.transaction.service.api.transaction;

import lombok.Value;

@Value
public class TransactionServiceFailureResponse {

    String message;

    String description;

    Long errorCode;
}
