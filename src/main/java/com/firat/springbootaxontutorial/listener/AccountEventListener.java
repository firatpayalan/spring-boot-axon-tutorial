package com.firat.springbootaxontutorial.listener;

import com.firat.springbootaxontutorial.AccountCreatedEvent;
import com.firat.springbootaxontutorial.projection.AccountEntry;
import com.firat.springbootaxontutorial.query.FindByAccountIdQuery;
import com.firat.springbootaxontutorial.repository.DefaultRepository;
import com.firat.springbootaxontutorial.entity.Account;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ProcessingGroup("account")
public class AccountEventListener {

    private final DefaultRepository repository;

    public AccountEventListener(DefaultRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event){
        final Account s = new Account();
        s.setName(event.getName());
        s.setBalance(BigDecimal.ZERO);
        s.setUuid(event.getId());
        repository.save(s);
    }

    @QueryHandler
    public AccountEntry query(FindByAccountIdQuery query){
        return repository.getByUuid(query.getAccountId())
                .map(account -> new AccountEntry(account.getUuid(),account.getName(),account.getBalance()))
                .orElseThrow(NullPointerException::new);
    }
}
