package pl.adamboguszewski.transaction.service.application;

import lombok.Data;

import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class Transaction {

    @Id
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

    public static Transaction fromDto(TransactionDto dto) {
        TransactionInformation transactionInformation =
                TransactionInformation.fromDto(dto.getTransactionInformationDto());

        List<TransactionProduct> products = dto.getProducts()
                .stream()
                .map(TransactionProduct::fromDto)
                .collect(Collectors.toList());

        return new Transaction(
                dto.getTransactionId(),
                dto.getTotalPrice(),
                transactionInformation,
                products
        );
    }
}
