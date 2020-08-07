package pl.adamboguszewski.transaction.service.application;

import lombok.Data;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class TransactionInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @OneToOne(mappedBy = "transactionInformation")
    Transaction transaction;

    @Column
    LocalDateTime transactionDateTime;
    @Column
    String checkoutId;

    @OneToMany(mappedBy = "transactionInformation", cascade = CascadeType.ALL)
    List<PaymentInformation> payments;

    private TransactionInformation(LocalDateTime transactionDateTime, String checkoutId, List<PaymentInformation> payments) {
        this.transactionDateTime = transactionDateTime;
        this.checkoutId = checkoutId;
        this.payments = payments;
    }

    public static TransactionInformation fromDto(TransactionDto.TransactionInformationDto dto) {
        List<PaymentInformation> payments;
        payments = dto.getPaymentInformationDtos()
                .stream()
                .map(PaymentInformation::fromDto)
                .collect(Collectors.toList());

        return new TransactionInformation(
                dto.getTransactionDateTime(),
                dto.getCheckoutId(),
                payments
        );
    }
}
