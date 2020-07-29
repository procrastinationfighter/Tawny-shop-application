package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

// [TODO]: This is application response, implement info that should be returned to application user after you create and add transaction to database (we don't have db yet but nvm)
// [TODO]: Also look for a more proper class name to fit the request
@Value
public class TransactionResponse {

    @NonNull
    UUID transactionId;

    @NonNull
    boolean paymentSuccessful;

}
