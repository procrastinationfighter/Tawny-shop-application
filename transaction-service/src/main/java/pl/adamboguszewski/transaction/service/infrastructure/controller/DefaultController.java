package pl.adamboguszewski.transaction.service.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction-service")
public class DefaultController {

    @GetMapping("")
    public ResponseEntity<Void> getModuleInfo() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/api")
    public ResponseEntity<Void> getApiInfo() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
