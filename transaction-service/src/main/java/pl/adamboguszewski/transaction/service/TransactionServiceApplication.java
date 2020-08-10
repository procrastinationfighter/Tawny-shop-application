package pl.adamboguszewski.transaction.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.adamboguszewski.transaction.service.api.Currency;
import pl.adamboguszewski.transaction.service.api.PaymentType;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TransactionService transactionService) {
        return args -> {
            Stream.of(
                    UUID.fromString("1234eb1c-a76e-4d74-953e-04838177c24a"),
                    UUID.fromString("2345eb1c-a76e-4d74-953e-04838177c24a"),
                    UUID.fromString("3456eb1c-a76e-4d74-953e-04838177c24a"),
                    UUID.fromString("4567eb1c-a76e-4d74-953e-04838177c24a"),
                    UUID.fromString("5678eb1c-a76e-4d74-953e-04838177c24a")
            ).forEach(name -> {
                List<CreateTransactionRequest.TransactionInformation.PaymentInformation> payments = new ArrayList<>();
                payments.add(new CreateTransactionRequest.TransactionInformation.PaymentInformation(213L, 1L, Currency.EUR, PaymentType.CARD));
                CreateTransactionRequest.TransactionInformation information = new CreateTransactionRequest.TransactionInformation(LocalDateTime.now(), "asd", payments);
                List<CreateTransactionRequest.TransactionProduct> products = new ArrayList<>();
                products.add(new CreateTransactionRequest.TransactionProduct(UUID.randomUUID(), "pr", 1L, 1L, 1L, "des", "cat"));
                TransactionDto createTransactionDto = TransactionDto.fromRequest(new CreateTransactionRequest(UUID.randomUUID(), 2137L, information, products));
                transactionService.createTransaction(createTransactionDto);
            });
            transactionService.getAllTransactions().forEach(System.out::println);
        };
    }
}
