package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class CreateTransactionResponse {

    @NonNull
    UUID transactionId;

    @NonNull
    boolean paymentSuccessful;

}
