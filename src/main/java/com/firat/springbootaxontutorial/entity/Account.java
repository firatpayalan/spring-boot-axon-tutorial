package com.firat.springbootaxontutorial.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String uuid;
    @Column
    private String name;
    @Column
    private BigDecimal balance;

}
