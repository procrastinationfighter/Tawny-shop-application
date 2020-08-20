package pl.adamboguszewski.transaction.service.infrastructure.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adamboguszewski.transaction.service.api.transaction.ModuleInformation;

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
    public ResponseEntity<ModuleInformation> getModuleInfo() {
        return new ResponseEntity<>(
                new ModuleInformation(
                        buildProperties.getName(),
                        buildProperties.getArtifact(),
                        buildProperties.getGroup(),
                        buildProperties.getVersion(),
                        LocalDateTime.ofInstant(buildProperties.getTime(), ZoneOffset.UTC)),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/api")
    public ResponseEntity<Void> getApiInfo() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
