package com.firat.springbootaxontutorial;

import com.firat.springbootaxontutorial.command.CreateAccountCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class AccountCreator {

    private final CommandGateway commandGateway;

    public AccountCreator(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void create(String accountId){
        commandGateway.send(new CreateAccountCommand(accountId));
    }
}
