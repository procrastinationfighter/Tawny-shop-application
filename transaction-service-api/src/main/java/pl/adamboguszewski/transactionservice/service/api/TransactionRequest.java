package pl.adamboguszewski.transactionservice.service.api;

import lombok.Value;

// [TODO]: This is a create transaction request, implement info needed to create a transaction
// [TODO]: Also look for a more proper class name, the hint is above
@Value
public class TransactionRequest {

    String id;

    String name;

}
