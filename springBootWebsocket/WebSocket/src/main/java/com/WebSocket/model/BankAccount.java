package com.WebSocket.model;

public class BankAccount {

    private int id;
    private double Amount;
    private User user;

    public BankAccount() {

    }

    public BankAccount(int id, double amount, User user) {
        this.id = id;
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
