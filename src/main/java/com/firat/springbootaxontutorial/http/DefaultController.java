package com.firat.springbootaxontutorial.http;

import com.firat.springbootaxontutorial.AccountCreator;
import com.firat.springbootaxontutorial.AccountRetrieveService;
import com.firat.springbootaxontutorial.projection.AccountEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@RestController
public class DefaultController {

    private final AccountCreator accountCreator;
    private final AccountRetrieveService accountRetrieveService;

    public DefaultController(AccountCreator accountCreator, AccountRetrieveService accountRetrieveService) {
        this.accountCreator = accountCreator;
        this.accountRetrieveService = accountRetrieveService;
    }

    @PostMapping("/create/{accountId}")
    public ResponseEntity accountCreate(@PathVariable String accountId) {
        accountCreator.create(accountId);
        return ResponseEntity.created(URI.create(accountId).normalize()).build();
    }

    @GetMapping("/{accountId}")
    public CompletableFuture<AccountEntry> accountRetrieve(@PathVariable String accountId) {
        final CompletableFuture<AccountEntry> retrieve = accountRetrieveService.retrieve(accountId);
        return retrieve;
    }


}
