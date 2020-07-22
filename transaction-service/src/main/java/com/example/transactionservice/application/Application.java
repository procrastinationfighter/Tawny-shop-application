package com.example.transactionservice.application;
// [TODO]: Your package should be unique for every project but your group id should be same in every your project
// [TODO]: Package name should be <group.id>.<project.name>.<module.name>.<directory.name>. It helps with trace error stack, recognise your projects/modules etc
// [TODO]: Click PPM on package and select refactor > Rename... (shift+F6)

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
