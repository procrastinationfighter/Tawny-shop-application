package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

// [TODO]: This is a create transaction request, implement info needed to create a transaction
// [TODO]: Also look for a more proper class name, the hint is above
@Value
public class TransactionRequest {

    @NonNull
    Long totalPrice;

    @NonNull
    List<Product> products;

    @Value
    public static class Product {

        @NonNull
        UUID productId;

        @NonNull
        Long quantity;
    }

}
