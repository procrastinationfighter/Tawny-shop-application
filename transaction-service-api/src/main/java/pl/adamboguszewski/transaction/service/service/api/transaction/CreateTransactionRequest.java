package pl.adamboguszewski.transaction.service.service.api.transaction;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.Currency;
import pl.adamboguszewski.transaction.service.service.api.PaymentType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class CreateTransactionRequest {

    @NotNull
    UUID transactionId;
    @NotNull
    Long totalPrice;

    @NotNull
    CreateTransactionRequest.TransactionInformation transactionInformation;
    @NotNull
    List<TransactionProduct> products;

    @Value
    public static class TransactionProduct {

        @NotNull
        UUID productId;
        @NotNull
        String name;

        @NotNull
        Long price;
        @NotNull
        Long quantity;
        @NotNull
        Long priceMultiplier;
        @NotNull
        String description;
        @NotNull
        String category;
    }

    @Value
    public static class TransactionInformation {

        @NotNull
        LocalDateTime transactionDateTime;
        @NotNull
        String checkoutId;

        @NotNull
        List<PaymentInformation> paymentInformations;

        @Value
        public static class PaymentInformation {
            @NotNull
            Long amountPaid;
            @NotNull
            Long multiplier;
            @NotNull
            Currency currency;
            @NotNull
            PaymentType paymentType;
        }
    }

}



















