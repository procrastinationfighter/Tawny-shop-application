package pl.adamboguszewski.transactionservice.service.api;

import org.springframework.stereotype.Service;

// [TODO]: This is a create transaction request, implement info needed to create a transaction
// [TODO]: Also look for a more proper class name, the hint is above
@Service
public class TransactionRequest {

    private final String id;

    private final String name;

    public TransactionRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
