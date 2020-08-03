package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class TransactionInformation {

    LocalDateTime transactionDateTime;
    String checkoutId;

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
