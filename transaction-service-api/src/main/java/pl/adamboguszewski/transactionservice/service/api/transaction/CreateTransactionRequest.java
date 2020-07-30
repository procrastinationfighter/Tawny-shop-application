package pl.adamboguszewski.transactionservice.service.api.transaction;

import lombok.Value;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class CreateTransactionRequest {

    @NotNull
    UUID transactionId;

    @NotNull
    TransactionInfo transactionInfo;

    @Value
    public static class TransactionInfo {

        @NotNull
        String checkoutId;

        @NotNull
        LocalDateTime transactionDateTime;

        @NotNull
        List<TransactionPayment> transactionPayments;

        @Value
        public static class TransactionPayment {

            @NotNull
            Long amountPaid;

            @NotNull
            Currency currency;

            @NotNull
            Long multiplier;

            @NotNull
            PaymentType paymentType;

            public enum Currency {
                PLN,
                USD,
                EUR
            }

            public enum PaymentType {
                CASH,
                CARD,
                GOOGLE_PAY
            }
        }
    }

    @NotNull
    Long totalPrice;

    @NotNull
    List<TransactionProduct> products;

    @Value
    public static class TransactionProduct {

        @NotNull
        UUID productId;

        @NotNull
        Long priceMultiplier;

        @NotNull
        Long quantity;

        @NotNull
        Long totalPrice;

        @NotNull
        String productName;

        @NotNull
        String description;

        @NotNull
        String category;
    }

}
