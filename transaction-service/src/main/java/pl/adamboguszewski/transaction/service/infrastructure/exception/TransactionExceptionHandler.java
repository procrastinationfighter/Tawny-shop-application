package pl.adamboguszewski.transaction.service.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.adamboguszewski.transaction.service.api.exception.IllegalCurrencyArgumentException;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionFailureResponse;
import pl.adamboguszewski.transaction.service.api.transaction.CreateTransactionResponse;
import pl.adamboguszewski.transaction.service.api.transaction.GetTransactionFailureResponse;
import pl.adamboguszewski.transaction.service.api.transaction.GetTransactionResponse;
import pl.adamboguszewski.transaction.service.application.TransactionNotFoundException;

@Slf4j
@ControllerAdvice
public class TransactionExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<GetTransactionResponse> handle(TransactionNotFoundException exception) {
        log.info("Transaction with id " + exception.getTransactionId() + " could not be found in the database.");
        return new ResponseEntity<>(
                new GetTransactionFailureResponse(exception.getTransactionId()),
                HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(IllegalCurrencyArgumentException.class)
    public ResponseEntity<CreateTransactionResponse> handle(IllegalCurrencyArgumentException exception) {
        log.info(exception.getMessage());
        //[TODO] Handle error code
        return new ResponseEntity<>(
                new CreateTransactionFailureResponse(exception.getMessage(), 2137L),
                HttpStatus.NO_CONTENT);
    }
}
