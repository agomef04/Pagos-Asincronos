package com.example.RabbitMQ.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nameState;
    private  String description;

    public State() {

    }

    public State(int id, String nameState, String description) {
        this.id = id;
        this.nameState = nameState;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getNameState() {
        return nameState;
    }

    public String getDescription() {
        return description;
    }


}
