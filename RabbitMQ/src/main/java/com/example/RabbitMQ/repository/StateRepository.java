package com.example.RabbitMQ.repository;


import com.example.RabbitMQ.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {

    public State findByNameState(String name);
}
