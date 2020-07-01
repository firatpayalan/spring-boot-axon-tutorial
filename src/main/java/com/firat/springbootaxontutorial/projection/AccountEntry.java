package com.firat.springbootaxontutorial.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AccountEntry {
    private String uuid;
    private String name;
    private BigDecimal balance;
}
