package pl.adamboguszewski.transaction.service.application;

import lombok.Data;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
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

    private TransactionProduct(UUID productId, String name, Long price, Long quantity, Long priceMultiplier, String description, String category) {
        // [TODO] Temporary solution for assigning id.
        this.id = -1L;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.priceMultiplier = priceMultiplier;
        this.description = description;
        this.category = category;
    }

    public static TransactionProduct fromDto(TransactionDto.TransactionProductDto dto) {
        return new TransactionProduct(
                dto.getProductId(),
                dto.getName(),
                dto.getPrice(),
                dto.getQuantity(),
                dto.getPriceMultiplier(),
                dto.getDescription(),
                dto.getCategory()
        );
    }
}
