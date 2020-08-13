package pl.adamboguszewski.transaction.service.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.adamboguszewski.transaction.service.api.transaction.GetTransactionFailureResponse;
import pl.adamboguszewski.transaction.service.api.transaction.GetTransactionResponse;
import pl.adamboguszewski.transaction.service.application.TransactionNotFoundException;

@Slf4j
@ControllerAdvice
public class TransactionNotFoundExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<GetTransactionResponse> handle(TransactionNotFoundException exception) {
        log.info("Transaction with id " + exception.getTransactionId() + " could not be found in the database.");
        return new ResponseEntity<>(
                new GetTransactionFailureResponse(exception.getTransactionId()),
                HttpStatus.NOT_FOUND);
    }
}
