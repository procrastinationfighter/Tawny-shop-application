package pl.adamboguszewski.transactionservice.service.api;

import org.springframework.stereotype.Service;

// [TODO]: @Service is not necessary here, we don't need to inject this class anywhere. It's just a normal class
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
