package pl.adamboguszewski.transaction.service.application;

import lombok.Data;
import pl.adamboguszewski.transaction.service.api.Currency;
import pl.adamboguszewski.transaction.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;

@Entity
@Data
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne
    TransactionInformation transactionInformation;

    @Column
    Long amountPaid;
    @Column
    Long multiplier;
    @Column
    Currency currency;
    @Column
    PaymentType paymentType;

    private PaymentInformation(Long amountPaid, Long multiplier, Currency currency,
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
