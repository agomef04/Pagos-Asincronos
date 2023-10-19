package com.WebSocket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nameState;
    String description;

    public State() {

    }
    public State(int id, String nameState, String description) {
        this.id = id;
        this.nameState = nameState;
        this.description = description;
    }

    public State(String nameState, String description) {
        this.id = id;
        this.nameState = nameState;
        this.description = description;
    }
}
