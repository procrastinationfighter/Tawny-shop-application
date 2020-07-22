package com.example.transactionservice.application;
// [TODO]: Your package should be unique for every project but your group id should be same in every your project
// [TODO]: Package name should be <group.id>.<project.name>.<module.name>.<directory.name>. It helps with trace error stack, recognise your projects/modules etc
// [TODO]: Click PPM on package and select refactor > Rename... (shift+F6)

import com.example.transactionservice.service.TransactionRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
