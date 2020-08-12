package pl.adamboguszewski.transaction.service.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
public class Transaction {

    @Id
    @SequenceGenerator(name = "transaction_gen", allocationSize = 1)
    @GeneratedValue(generator = "transaction_gen", strategy = GenerationType.SEQUENCE)
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

    public Transaction(TransactionDto dto) {
        this.transactionId = dto.getTransactionId();
        this.totalPrice = dto.getTotalPrice();
        this.products = getTransactionProducts(dto);
        this.transactionInformation = getTransactionInformation(dto);
        this.transactionDateTime = dto.getTransactionDateTime();
    }

    private TransactionInformation getTransactionInformation(TransactionDto dto) {
        return new TransactionInformation(dto.getTransactionInformationDto(), this);
    }

    private Set<TransactionProduct> getTransactionProducts(TransactionDto dto) {
        return dto.getProducts()
                .stream()
                .map(product -> new TransactionProduct(product, this))
                .collect(Collectors.toSet());
    }
}
