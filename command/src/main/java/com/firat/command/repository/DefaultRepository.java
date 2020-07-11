package com.firat.command.repository;

import com.firat.command.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DefaultRepository extends JpaRepository<Account,String> {
    Optional<Account> getByUuid(String uuid);
}
