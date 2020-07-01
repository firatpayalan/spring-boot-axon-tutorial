package com.firat.springbootaxontutorial.aggregate;

import com.firat.springbootaxontutorial.AccountCreatedEvent;
import com.firat.springbootaxontutorial.command.CreateAccountCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;
import java.util.Objects;


@NoArgsConstructor
@Aggregate
public class Account {

    @AggregateIdentifier
    private String uuid;
    private String name;
    private BigDecimal balance;

    @CommandHandler
    public Account(CreateAccountCommand command){
        Objects.requireNonNull(command.getName());

        AggregateLifecycle.apply(new AccountCreatedEvent(command.getName(),command.getId()));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.uuid=event.getId();
        this.name=event.getName();
        this.balance = BigDecimal.ZERO;
    }
}
