package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;

import javax.validation.constraints.NotNull;

import java.util.UUID;

@Value
public class CreateTransactionResponse {

    @NotNull
    UUID transactionId;

    @NotNull
    boolean paymentSuccessful;

}
