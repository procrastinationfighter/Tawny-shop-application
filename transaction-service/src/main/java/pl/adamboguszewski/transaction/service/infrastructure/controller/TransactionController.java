package pl.adamboguszewski.transaction.service.infrastructure.controller;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamboguszewski.transaction.service.api.transaction.*;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.application.dto.CreateTransactionDto;
import pl.adamboguszewski.transaction.service.application.dto.GetTransactionDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction-service/api/v1.0")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("")
    public ResponseEntity<List<Transaction>> getAll() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), (HttpStatus.OK));
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<GetTransactionResponse> getTransactionByTransactionId(@PathVariable UUID id) {
        return new ResponseEntity<>(generateGetTransactionResponse(transactionService.getByTransactionId(id)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CreateTransactionResponse> createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        Optional<Transaction> transaction = transactionService.createTransaction(CreateTransactionDto.fromRequest(request));
        CreateTransactionResponse response;
        if (transaction.isPresent()) {
            response = new CreateTransactionSuccessResponse(transaction.get().getId());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            // [TODO]: Create method for processing errors (exceptions?)
            response = new CreateTransactionFailureResponse("Creating was not successful.", 2137L);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> replaceTransaction(@PathVariable UUID id, CreateTransactionDto dto) {
        Optional<Transaction> transaction = transactionService.updateTransaction(id, dto);
        if (transaction.isPresent()) {
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-old-transactions")
    public ResponseEntity<Void> deleteOldTransactions() {
        transactionService.deleteOldTransactions();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private GetTransactionResponse generateGetTransactionResponse(GetTransactionDto dto) {
        List<GetTransactionSuccessResponse.TransactionProduct> products = dto.getProducts()
                .stream()
                .map(product -> new GetTransactionSuccessResponse.TransactionProduct(
                        product.getProductId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getPriceMultiplier(),
                        product.getDescription(),
                        product.getCategory()))
                .collect(Collectors.toList());

        return new GetTransactionSuccessResponse(
                dto.getTransactionId(),
                dto.getTotalPrice(),
                products,
                dto.getTransactionDateTime());
    }
}
