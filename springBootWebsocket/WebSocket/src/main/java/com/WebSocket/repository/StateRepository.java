package com.WebSocket.repository;

import com.WebSocket.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

    public State findByNameState(String name);
}
