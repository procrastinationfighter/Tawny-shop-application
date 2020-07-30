package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;

@Value
public class CreateSuccessfulTransactionResponse implements CreateTransactionResponse {

    Long transactionIdInDatabase;
}
