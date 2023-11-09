package com.example.RabbitMQ.repository;


import com.example.RabbitMQ.model.BankAccount;
import com.example.RabbitMQ.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    boolean existsById(int id);

    BankAccount findById(int id);

    BankAccount findByUser(User user);
}
