package pl.adamboguszewski.transactionservice.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamboguszewski.transactionservice.service.api.transaction.CreateTransactionRequest;

@RestController
@RequestMapping
public class ApplicationController {

    @GetMapping("/")
    public String printRequest(CreateTransactionRequest request) {
        return "Request of total price: " + request.getTotalPrice() + " received successfully.";
    }
}
