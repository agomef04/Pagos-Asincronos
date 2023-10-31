package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    boolean existsById(int id);

    BankAccount findById(int id);
}
