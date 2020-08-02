package pl.adamboguszewski.transaction.service.application.dto;

import lombok.Value;
import pl.adamboguszewski.transaction.service.application.TransactionInformation;
import pl.adamboguszewski.transaction.service.application.TransactionProduct;

import java.util.List;
import java.util.UUID;

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
}
