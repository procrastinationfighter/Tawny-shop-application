package pl.adamboguszewski.transaction.service.application;

import lombok.Data;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class TransactionInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public TransactionInformation() {
    }

    private TransactionInformation(String checkoutId, Set<PaymentInformation> payments) {
        this.checkoutId = checkoutId;
        this.payments = payments;
    }

    public static TransactionInformation fromDto(TransactionDto.TransactionInformationDto dto) {
        Set<PaymentInformation> payments = dto.getPaymentInformationDtos()
                .stream()
                .map(PaymentInformation::fromDto)
                .collect(Collectors.toSet());

        return new TransactionInformation(
                dto.getCheckoutId(),
                payments
        );
    }
}
