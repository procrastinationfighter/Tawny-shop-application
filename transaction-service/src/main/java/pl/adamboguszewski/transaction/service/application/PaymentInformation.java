package pl.adamboguszewski.transaction.service.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.adamboguszewski.transaction.service.api.Currency;
import pl.adamboguszewski.transaction.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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

    public PaymentInformation(TransactionDto.TransactionInformationDto.PaymentInformationDto dto,
                               TransactionInformation transactionInformation) {
        this.amountPaid = dto.getAmountPaid();
        this.multiplier = dto.getMultiplier();
        this.currency = dto.getCurrency();
        this.paymentType = dto.getPaymentType();
        this.transactionInformation = transactionInformation;
    }
}
