package pl.adamboguszewski.transaction.service.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.adamboguszewski.transaction.service.api.exception.IllegalCurrencyArgumentException;
import pl.adamboguszewski.transaction.service.api.exception.IllegalPaymentTypeArgumentException;
import pl.adamboguszewski.transaction.service.api.exception.LoggingMessageException;
import pl.adamboguszewski.transaction.service.api.transaction.*;
import pl.adamboguszewski.transaction.service.application.TransactionNotFoundException;

import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class TransactionExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<GetTransactionResponse> handle(TransactionNotFoundException exception) {
        log.info("Transaction with id " + exception.getTransactionId() + " could not be found in the database.");
        logException(exception);
        return new ResponseEntity<>(
                new GetTransactionFailureResponse(exception.getTransactionId()),
                HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalCurrencyArgumentException.class)
    public ResponseEntity<CreateTransactionResponse> handle(IllegalCurrencyArgumentException exception) {
        log.info("Currency " + exception.getCurrency() + " not recognized.");
        logException(exception);
        //[TODO] Handle error code
        return new ResponseEntity<>(
                new CreateTransactionFailureResponse(exception.getMessage(), 2137L),
                HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalPaymentTypeArgumentException.class)
    public ResponseEntity<CreateTransactionResponse> handle(IllegalPaymentTypeArgumentException exception) {
        log.info("Payment type " + exception.getPaymentType() + " not recognized.");
        logException(exception);
        //[TODO] Handle error code
        return new ResponseEntity<>(
                new CreateTransactionFailureResponse(exception.getMessage(), 2137L),
                HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<TransactionServiceFailureResponse> handleUnexpectedExceptions(Exception exception) {
        log.info("Unexpected error occurred.");
        log.info(exception.getLocalizedMessage());
        log.info(Arrays.toString(exception.getStackTrace()));
        //[TODO] Handle error code
        return new ResponseEntity<>(
                new TransactionServiceFailureResponse(exception.getMessage(), exception.getLocalizedMessage(), 2137L),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logException(LoggingMessageException exception) {
        log.info(exception.getCustomizedMessage());
        log.info(exception.getLocalizedMessage());
        log.info(Arrays.toString(exception.getStackTrace()));
    }
}
