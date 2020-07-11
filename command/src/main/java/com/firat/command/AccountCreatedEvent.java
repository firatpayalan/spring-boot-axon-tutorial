package com.firat.command;

import lombok.Getter;

@Getter
public class AccountCreatedEvent {

    private String id;
    private String name;

    public AccountCreatedEvent(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
