package pl.adamboguszewski.transaction.service.service.api.transaction;

import lombok.Value;

@Value
public class CreateTransactionSuccessResponse implements CreateTransactionResponse {

    Long id;
}
