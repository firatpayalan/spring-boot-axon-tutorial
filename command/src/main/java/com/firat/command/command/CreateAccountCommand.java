package com.firat.command.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
public class CreateAccountCommand {
    @TargetAggregateIdentifier
    private String id;

    private String name;

    public CreateAccountCommand(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
