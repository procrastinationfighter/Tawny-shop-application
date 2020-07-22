package com.example.transactionservice.service;
// [TODO]: Your package should be unique for every project but your group id should be same in every your project
// [TODO]: Package name should be <group.id>.<project.name>.<module.name>.<directory.name>. It helps with trace error stack, recognise your projects/modules etc
// [TODO]: Click PPM on package and select refactor > Rename... (shift+F6)


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
// [TODO]: Remove unused imports, also you can press alt+enter and select option 'Enable optimize imports on the fly to make Intellij do it automatically'
import org.springframework.stereotype.Service;

@Service
public class TransactionRequest {

    private final String id;

    private final String name;

    public TransactionRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
