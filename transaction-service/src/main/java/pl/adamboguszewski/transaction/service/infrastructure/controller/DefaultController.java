package pl.adamboguszewski.transaction.service.infrastructure.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/transaction-service")
public class DefaultController {

    BuildProperties buildProperties;

    public DefaultController(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping("")
    public ResponseEntity<String> getModuleInfo() {
        return new ResponseEntity<>(
                "Application " + buildProperties.getName() +
                        ", version " + buildProperties.getVersion() +
                        ", group " + buildProperties.getGroup() +
                        " works properly. Build timestamp: " +
                        LocalDateTime.ofInstant(buildProperties.getTime(), ZoneOffset.UTC) +
                        ". In order to obtain api information, visit transaction-service/api",
                HttpStatus.OK);
    }

    @GetMapping("/api")
    public ResponseEntity<String> getApiInfo() {
        return new ResponseEntity<>(
                "Application " + buildProperties.getName() +
                        ", version " + buildProperties.getVersion() +
                        ", group " + buildProperties.getGroup() +
                        " works properly. Build timestamp: " +
                        LocalDateTime.ofInstant(buildProperties.getTime(), ZoneOffset.UTC) +
                        ". In order to obtain service information, visit parent directory.",
                HttpStatus.OK);
    }
}
