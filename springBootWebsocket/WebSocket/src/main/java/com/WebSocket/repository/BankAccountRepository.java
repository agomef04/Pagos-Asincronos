package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    boolean existsById(int id);

    BankAccount findById(int id);

}
