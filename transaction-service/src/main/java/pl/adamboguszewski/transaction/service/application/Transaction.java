package pl.adamboguszewski.transaction.service.application;

import lombok.Data;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column
    UUID transactionId;
    @Column
    Long totalPrice;
    @Column
    LocalDateTime transactionDateTime;

//    @Column
    @OneToOne(
        mappedBy = "transaction",
        orphanRemoval = true,
        cascade = CascadeType.ALL)
    TransactionInformation transactionInformation;

    @OneToMany(
            mappedBy = "transaction",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    Set<TransactionProduct> products;

    public Transaction() {
    }

    private Transaction(UUID transactionId,
                        Long totalPrice,
                        TransactionInformation transactionInformation,
                        Set<TransactionProduct> products,
                        LocalDateTime transactionDateTime) {
        // [TODO]: Temporary solution for assigning id.
        this.id = -1L;
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.products = products;
        this.transactionInformation = transactionInformation;
        this.transactionDateTime = transactionDateTime;
    }

    public static Transaction fromDto(TransactionDto dto) {
        TransactionInformation transactionInformation =
                TransactionInformation.fromDto(dto.getTransactionInformationDto());

        Set<TransactionProduct> products = dto.getProducts()
                .stream()
                .map(TransactionProduct::fromDto)
                .collect(Collectors.toSet());

        return new Transaction(
                dto.getTransactionId(),
                dto.getTotalPrice(),
                transactionInformation,
                products,
                dto.getTransactionDateTime()
        );
    }
}
