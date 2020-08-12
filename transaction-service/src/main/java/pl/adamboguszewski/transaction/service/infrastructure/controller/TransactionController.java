package pl.adamboguszewski.transaction.service.infrastructure.controller;

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

    @GetMapping("/{id}")
    public ResponseEntity<GetTransactionResponse> getTransactionByTransactionId(@PathVariable UUID id) {
        Optional<GetTransactionDto> dto = transactionService.getByTransactionId(id);
        if(dto.isPresent()) {
            List<GetTransactionSuccessResponse.TransactionProduct> products = dto.get().getProducts()
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

            GetTransactionSuccessResponse response =  new GetTransactionSuccessResponse(
                    dto.get().getTransactionId(),
                    dto.get().getTotalPrice(),
                    products,
                    dto.get().getTransactionDateTime());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<CreateTransactionResponse> createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        Optional<Transaction> transaction = transactionService.createTransaction(CreateTransactionDto.fromRequest(request));
        CreateTransactionResponse response;
        if(transaction.isPresent()) {
            response = new CreateTransactionSuccessResponse(transaction.get().getId());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else {
            // [TODO]: Create method for processing errors (exceptions?)
            response = new CreateTransactionFailureResponse("Creating was not successful.", 2137L);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> replaceTransaction(@PathVariable UUID id, CreateTransactionDto dto) {
        Optional<Transaction> transaction = transactionService.updateTransaction(id, dto);
        if(transaction.isPresent()) {
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteOldTransactions(Long months) {
        transactionService.deleteOldTransactions(months);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
