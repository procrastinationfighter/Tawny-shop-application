package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.api.Currency;
import pl.adamboguszewski.transaction.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;

@Value
public class PaymentInformation {

    Long amountPaid;
    Long multiplier;
    Currency currency;
    PaymentType paymentType;

    public PaymentInformation(Long amountPaid, Long multiplier, Currency currency,
                              PaymentType paymentType) {
        this.amountPaid = amountPaid;
        this.multiplier = multiplier;
        this.currency = currency;
        this.paymentType = paymentType;
    }

    public static PaymentInformation fromRequest(CreateTransactionRequest.TransactionInformation.PaymentInformation request) {
        return new PaymentInformation(
                request.getAmountPaid(),
                request.getMultiplier(),
                Currency.fromString(request.getCurrency().getValue()),
                PaymentType.fromString(request.getPaymentType().getValue())
        );
    }

}
