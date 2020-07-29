package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Data;

import javax.validation.constraints.NotNull;

import java.util.UUID;

@Data
public abstract class CreateTransactionResponse {

    @NotNull
    private final UUID transactionId;

}
