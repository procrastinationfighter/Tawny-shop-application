package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class CreateSuccessfulTransactionResponse extends CreateTransactionResponse {

    Long transactionIdInDatabase;
}
