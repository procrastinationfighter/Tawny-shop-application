package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class CreateTransactionRequest {

    @NotNull
    Long totalPrice;

    @NotNull
    List<Product> products;

    @NotNull
    Info transactionInfo;

    @Value
    public static class Info {

        @NotNull
        LocalDateTime transactionTime;

        @NotNull
        UUID checkoutId;

        @NotNull
        List<PaymentInfo> paymentsInfo;

        @Value
        public static class PaymentInfo {

            @NotNull
            Long amount;

            @NotNull
            Long multiplier;
        }
    }

    @Value
    public static class Product {

        @NotNull
        UUID productId;

        @NotNull
        Long quantity;
    }

}
