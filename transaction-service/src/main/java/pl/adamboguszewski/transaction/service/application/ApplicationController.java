package pl.adamboguszewski.transaction.service.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

@RestController
@RequestMapping
public class ApplicationController {

    @GetMapping("/")
    public String printRequest(CreateTransactionRequest request) {
        return "Request of total price: " + request.getTotalPrice() +
                " and products: " + request.getProducts().toString() + " received successfully.";
    }
}
