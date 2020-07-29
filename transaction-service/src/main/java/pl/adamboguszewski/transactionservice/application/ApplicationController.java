package pl.adamboguszewski.transactionservice.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamboguszewski.transactionservice.service.api.transaction.TransactionRequest;

@RestController
@RequestMapping
public class ApplicationController {

    @GetMapping("/")
    public String printRequest(TransactionRequest request) {
        return "Request with id: " + request.getId() +
                " and name: " + request.getName() +
                " received successfully.";
    }
}
