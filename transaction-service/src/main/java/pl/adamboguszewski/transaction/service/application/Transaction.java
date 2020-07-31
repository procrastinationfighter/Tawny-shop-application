package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class Transaction {

    Long id;

    UUID transactionId;

    Long totalPrice;

    TransactionInformation transactionInformation;
    List<TransactionProduct> products;

    private Transaction(UUID transactionId,
                        Long totalPrice,
                        TransactionInformation transactionInformation,
                        List<TransactionProduct> products) {
        // [TODO]: Temporary solution for assigning id.
        this.id = -1L;
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.products = products;
        this.transactionInformation = transactionInformation;
    }

    public static Transaction fromRequest(CreateTransactionRequest request) {
        TransactionInformation transactionInformation = TransactionInformation.fromRequest(request.getTransactionInformation());

        List<TransactionProduct> products = request.getProducts()
                .stream()
                .map(TransactionProduct::fromRequest)
                .collect(Collectors.toList());

        return new Transaction(
                request.getTransactionId(),
                request.getTotalPrice(),
                transactionInformation,
                products
        );
    }
}
