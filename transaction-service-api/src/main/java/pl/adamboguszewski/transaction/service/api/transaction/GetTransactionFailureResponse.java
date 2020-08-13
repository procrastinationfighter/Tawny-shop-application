package pl.adamboguszewski.transaction.service.api.transaction;

import java.util.UUID;

public class GetTransactionFailureResponse implements GetTransactionResponse {

    UUID transactionId;

    public GetTransactionFailureResponse(UUID transactionId) {
        this.transactionId = transactionId;
    }
}
