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

@Slf4j
@ControllerAdvice
public class IllegalCurrencyArgumentExceptionHandler {

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
