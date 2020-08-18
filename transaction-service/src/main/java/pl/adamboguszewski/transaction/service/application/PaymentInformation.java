package pl.adamboguszewski.transaction.service.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.adamboguszewski.transaction.service.api.transaction.Currency;
import pl.adamboguszewski.transaction.service.api.transaction.PaymentType;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PaymentInformation {

    @Id
    @SequenceGenerator(name = "payment_gen", allocationSize = 1)
    @GeneratedValue(generator = "payment_gen", strategy = GenerationType.SEQUENCE)
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

    public PaymentInformation(CreateTransactionDto.TransactionInformationDto.PaymentInformationDto dto,
                              TransactionInformation transactionInformation) {
        this.amountPaid = dto.getAmountPaid();
        this.multiplier = dto.getMultiplier();
        this.currency = dto.getCurrency();
        this.paymentType = dto.getPaymentType();
        this.transactionInformation = transactionInformation;
    }
}
