package com.example.RabbitMQ.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double Amount;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public BankAccount() {

    }

    public BankAccount(int id, double amount, User user) {
        this.id = id;
        Amount = amount;
        this.user = user;
    }

    public BankAccount(double amount, User user) {
        Amount = amount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
