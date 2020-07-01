package com.firat.springbootaxontutorial;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AccountCreatedEvent {

    private String id;
    private String name;

    public AccountCreatedEvent(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
