package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.api.Currency;
import pl.adamboguszewski.transaction.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

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

    public static PaymentInformation fromDto(TransactionDto.TransactionInformationDto.PaymentInformationDto dto) {
        return new PaymentInformation(
                dto.getAmountPaid(),
                dto.getMultiplier(),
                Currency.fromString(dto.getCurrency().getValue()),
                PaymentType.fromString(dto.getPaymentType().getValue())
        );
    }

}
