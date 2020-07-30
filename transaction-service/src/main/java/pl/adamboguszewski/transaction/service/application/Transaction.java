package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
public class Transaction {

    Long id;

    UUID transactionId;

    TransactionInformation transactionInformation;

    Long totalPrice;

    List<TransactionProduct> products;

    private Transaction(UUID transactionId, Long totalPrice,
                        CreateTransactionRequest.TransactionInfo transactionInfoRequest) {
        // [TODO]: Temporary solution for assigning id.
        this.id = -1L;
        this.products = new ArrayList<>();
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.transactionInformation = TransactionInformation.fromRequest(transactionInfoRequest);
    }

    private void createProductsFromRequest(List<CreateTransactionRequest.TransactionProduct> productsRequest) {
        for(CreateTransactionRequest.TransactionProduct productRequest : productsRequest) {
            this.products.add(new TransactionProduct(productRequest));
        }
    }

    public static Transaction fromRequest(CreateTransactionRequest request) {
        Transaction transaction = new Transaction(request.getTransactionId(),
                request.getTotalPrice(), request.getTransactionInfo());
        transaction.createProductsFromRequest(request.getProducts());
        return transaction;
    }
}
