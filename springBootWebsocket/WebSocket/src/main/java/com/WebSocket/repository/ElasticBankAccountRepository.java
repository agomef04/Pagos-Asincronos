package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticBankAccountRepository extends CrudRepository<BankAccount, Long> {
}
