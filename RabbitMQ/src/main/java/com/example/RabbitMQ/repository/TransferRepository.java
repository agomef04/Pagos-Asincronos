package com.example.RabbitMQ.repository;


import com.example.RabbitMQ.model.BankAccount;
import com.example.RabbitMQ.model.State;
import com.example.RabbitMQ.model.Transfer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransferRepository extends CrudRepository<Transfer, Long> {

    List<Transfer> findByAccountOrigin(BankAccount bankAccount);

    List<Transfer> findByAccountDestination(BankAccount bankAccount);

    List<Transfer> findByState(State state);

}
