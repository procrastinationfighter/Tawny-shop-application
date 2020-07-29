package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// [TODO]: This is a create transaction request, implement info needed to create a transaction
@Value
public class CreateTransactionRequest {

    @NonNull
    Long totalPrice;

    @NonNull
    List<Product> products;

    @NonNull
    Info transactionInfo;

    @Value
    public static class Info {

        @NonNull
        LocalDateTime transactionTime;

        @NonNull
        UUID checkoutId;

        @NonNull
        List<PaymentInfo> paymentsInfo;

        @Value
        public static class PaymentInfo {

            @NonNull
            Long amount;

            @NonNull
            Long multiplier;
        }
    }

    @Value
    public static class Product {

        @NonNull
        UUID productId;

        @NonNull
        Long quantity;
    }

}
