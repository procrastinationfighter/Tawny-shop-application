package pl.adamboguszewski.transaction.service.application.dto;

import lombok.Value;
import pl.adamboguszewski.transaction.service.api.Currency;
import pl.adamboguszewski.transaction.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class TransactionDto {

    UUID transactionId;

    Long totalPrice;

    TransactionInformationDto transactionInformationDto;

    List<TransactionProductDto> products;

    private TransactionDto(UUID transactionId,
                           Long totalPrice,
                           TransactionInformationDto transactionInformationDto,
                           List<TransactionProductDto> products) {
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.transactionInformationDto = transactionInformationDto;
        this.products = products;
    }

    public static TransactionDto fromRequest(CreateTransactionRequest request) {
        TransactionInformationDto transactionInformation = 
                TransactionInformationDto.fromRequest(request.getTransactionInformation());

        List<TransactionProductDto> products = request.getProducts()
                .stream()
                .map(TransactionProductDto::fromRequest)
                .collect(Collectors.toList());

        return new TransactionDto(
                request.getTransactionId(),
                request.getTotalPrice(),
                transactionInformation,
                products
        );
    }

    @Value
    public static class TransactionProductDto {
        
        UUID productId;
        
        String name;
        
        Long price;
        
        Long quantity;
        
        Long priceMultiplier;
        
        String description;
        
        String category;
    }
    
    @Value
    public static class TransactionInformationDto {
        
        LocalDateTime transactionDateTime;
        
        String checkoutId;
        
        List<PaymentInformationDto> paymentInformations;

        @Value
        public static class PaymentInformationDto {
            
            Long amountPaid;
            
            Long multiplier;
            
            Currency currency;
            
            PaymentType paymentType;
        }
    }
}
