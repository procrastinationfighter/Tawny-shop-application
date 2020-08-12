package pl.adamboguszewski.transaction.service.application;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class TransactionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public TransactionProduct(TransactionDto.TransactionProductDto dto, Transaction transaction) {
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
