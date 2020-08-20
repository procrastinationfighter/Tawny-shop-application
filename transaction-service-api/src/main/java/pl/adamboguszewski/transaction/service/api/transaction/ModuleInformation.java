package pl.adamboguszewski.transaction.service.api.transaction;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ModuleInformation {

    String name;
    String artifact;
    String group;
    String version;
    LocalDateTime time;
}
