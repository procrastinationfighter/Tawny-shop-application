package pl.adamboguszewski.transaction.service.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionFailureResponse;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionRequest;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionResponse;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionSuccessResponse;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionService;
import pl.adamboguszewski.transaction.service.application.dto.TransactionDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Transaction>> getTransactionById(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.getByTransactionId(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CreateTransactionResponse> createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        Optional<Transaction> transaction = transactionService.createTransaction(TransactionDto.fromRequest(request));
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
    public ResponseEntity<Optional<Transaction>> replaceTransaction(@PathVariable Long id, TransactionDto dto) {
        Optional<Transaction> transaction = transactionService.updateTransaction(id, dto);
        if(transaction.isPresent()) {
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(Optional.empty(), HttpStatus.OK);
    }
}
