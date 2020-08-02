package pl.adamboguszewski.transaction.service.application.dto;

import lombok.Value;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionInformation;
import pl.adamboguszewski.transaction.service.application.TransactionProduct;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class TransactionDto {

    UUID transactionId;

    Long totalPrice;

    TransactionInformation transactionInformation;

    List<TransactionProduct> products;

    private TransactionDto(UUID transactionId,
                           Long totalPrice,
                           TransactionInformation transactionInformation,
                           List<TransactionProduct> products) {
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.transactionInformation = transactionInformation;
        this.products = products;
    }

    public static TransactionDto fromRequest(CreateTransactionRequest request) {
        TransactionInformation transactionInformation = TransactionInformation.fromRequest(request.getTransactionInformation());

        List<TransactionProduct> products = request.getProducts()
                .stream()
                .map(TransactionProduct::fromRequest)
                .collect(Collectors.toList());

        return new TransactionDto(
                request.getTransactionId(),
                request.getTotalPrice(),
                transactionInformation,
                products
        );
    }
}
