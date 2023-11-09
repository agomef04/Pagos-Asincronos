package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    boolean existsById(int id);

    BankAccount findById(int id);

    BankAccount findByUser(User user);
}
