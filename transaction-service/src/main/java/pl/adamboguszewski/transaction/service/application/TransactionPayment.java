package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.Currency;
import pl.adamboguszewski.transaction.service.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

@Value
public class TransactionPayment {

    Long amountPaid;
    Long multiplier;
    Currency currency;
    PaymentType paymentType;

    public TransactionPayment(Long amountPaid, Long multiplier, Currency currency,
                              PaymentType paymentType) {
        this.amountPaid = amountPaid;
        this.multiplier = multiplier;
        this.currency = currency;
        this.paymentType = paymentType;
    }

    public static TransactionPayment fromRequest(CreateTransactionRequest.TransactionInfo.TransactionPayment request) {
        return new TransactionPayment(
                request.getAmountPaid(),
                request.getMultiplier(),
                Currency.fromString(request.getCurrency().getValue()),
                PaymentType.fromString(request.getPaymentType().getValue())
        );
    }

}
