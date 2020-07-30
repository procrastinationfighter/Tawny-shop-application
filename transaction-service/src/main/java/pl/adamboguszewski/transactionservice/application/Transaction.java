package pl.adamboguszewski.transactionservice.application;

import lombok.Value;
import pl.adamboguszewski.transactionservice.service.api.transaction.CreateTransactionRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
public class Transaction {

    Long id;

    UUID transactionId;

    TransactionInfo transactionInfo;

    Long totalPrice;

    List<TransactionProduct> products;

    public Transaction(CreateTransactionRequest request) {
        // [TODO]: Temporary solution for assigning id.
        this.id = -1L;
        this.products = new ArrayList<>();
        for(CreateTransactionRequest.TransactionProduct product : request.getProducts()) {
            this.products.add(new TransactionProduct(product));
        }
        this.transactionId = request.getTransactionId();
        this.totalPrice = request.getTotalPrice();
        this.transactionInfo = new TransactionInfo(request.getTransactionInfo());
    }

}
