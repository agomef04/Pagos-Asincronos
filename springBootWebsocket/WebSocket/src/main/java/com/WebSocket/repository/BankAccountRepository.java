package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import org.springframework.data.repository.CrudRepository;



public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

}
