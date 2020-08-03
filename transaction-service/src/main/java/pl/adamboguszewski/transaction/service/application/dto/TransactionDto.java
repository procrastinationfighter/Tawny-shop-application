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

        private TransactionProductDto(UUID productId,
                                      String name,
                                      Long price,
                                      Long quantity,
                                      Long priceMultiplier,
                                      String description,
                                      String category) {
            this.productId = productId;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.priceMultiplier = priceMultiplier;
            this.description = description;
            this.category = category;
        }

        public static TransactionProductDto fromRequest(CreateTransactionRequest.TransactionProduct request) {
            return new TransactionProductDto(
                    request.getProductId(),
                    request.getName(),
                    request.getPrice(),
                    request.getQuantity(),
                    request.getPriceMultiplier(),
                    request.getDescription(),
                    request.getCategory());
        }
    }
    
    @Value
    public static class TransactionInformationDto {
        
        LocalDateTime transactionDateTime;
        
        String checkoutId;
        
        List<PaymentInformationDto> paymentInformationDtos;

        private TransactionInformationDto(LocalDateTime transactionDateTime,
                                          String checkoutId,
                                          List<PaymentInformationDto> paymentInformationDtos) {
            this.transactionDateTime = transactionDateTime;
            this.checkoutId = checkoutId;
            this.paymentInformationDtos = paymentInformationDtos;
        }

        public static TransactionInformationDto fromRequest(CreateTransactionRequest.TransactionInformation request) {
            List<PaymentInformationDto> payments = request.getPaymentInformations()
                    .stream()
                    .map(PaymentInformationDto::fromRequest)
                    .collect(Collectors.toList());
            return new TransactionInformationDto(
                    request.getTransactionDateTime(),
                    request.getCheckoutId(),
                    payments);
        }

        @Value
        public static class PaymentInformationDto {
            
            Long amountPaid;
            
            Long multiplier;
            
            Currency currency;
            
            PaymentType paymentType;

            public static PaymentInformationDto fromRequest(
                    CreateTransactionRequest.TransactionInformation.PaymentInformation request) {
                return new PaymentInformationDto(
                        request.getAmountPaid(),
                        request.getMultiplier(),
                        Currency.fromString(request.getCurrency().getValue()),
                        PaymentType.fromString(request.getPaymentType().getValue()));
            }
        }
    }
}
