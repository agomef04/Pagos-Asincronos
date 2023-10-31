package com.WebSocket.repository;

import com.WebSocket.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {

    public State findByNameState(String name);
}
