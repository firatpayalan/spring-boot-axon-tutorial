package com.firat.springbootaxontutorial;

import com.firat.springbootaxontutorial.projection.AccountEntry;
import com.firat.springbootaxontutorial.query.FindByAccountIdQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AccountRetrieveService {

    private QueryGateway queryGateway;

    public AccountRetrieveService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public CompletableFuture<AccountEntry> retrieve(String accountId){
        return queryGateway.query(new FindByAccountIdQuery(accountId), AccountEntry.class);
    }
}
