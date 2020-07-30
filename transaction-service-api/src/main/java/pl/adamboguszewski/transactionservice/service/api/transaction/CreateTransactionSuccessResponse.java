package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;

@Value
public class CreateTransactionSuccessResponse implements CreateTransactionResponse {

    Long transactionIdInDatabase;
}
