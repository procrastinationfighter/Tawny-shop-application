package pl.adamboguszewski.transaction.service.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
public class TransactionInformation {

    @Id
    @SequenceGenerator(name = "transaction_info_gen", allocationSize = 1)
    @GeneratedValue(generator = "transaction_info_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    @OneToOne
    Transaction transaction;

    @Column
    String checkoutId;

    @OneToMany(
            mappedBy = "transactionInformation",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    Set<PaymentInformation> payments;

    public TransactionInformation(CreateTransactionDto.TransactionInformationDto dto, Transaction transaction) {
        this.checkoutId = dto.getCheckoutId();
        this.payments = getPayments(dto);
        this.transaction = transaction;
    }

    private Set<PaymentInformation> getPayments(CreateTransactionDto.TransactionInformationDto dto) {
        return dto.getPaymentInformationDtos()
                .stream()
                .map(payment -> new PaymentInformation(payment, this))
                .collect(Collectors.toSet());
    }
}
