package pl.adamboguszewski.transaction.service.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class TransactionProduct {

    @Id
    @SequenceGenerator(name = "product_gen", allocationSize = 1)
    @GeneratedValue(generator = "product_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne
    Transaction transaction;

    @Column
    UUID productId;
    @Column
    String name;
    @Column
    Long price;
    @Column
    Long quantity;
    @Column
    Long priceMultiplier;
    @Column
    String description;
    @Column
    String category;

    public TransactionProduct(CreateTransactionDto.TransactionProductDto dto, Transaction transaction) {
        this.productId = dto.getProductId();
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
        this.priceMultiplier = dto.getPriceMultiplier();
        this.description = dto.getDescription();
        this.category = dto.getCategory();
        this.transaction = transaction;
    }

}
