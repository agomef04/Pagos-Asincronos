package com.WebSocket.model;

import java.util.Date;

public class Transfer {

    private int id;
    private double amount;
    private String concept;
    private Date date;
    private String state;
    private BankAccount accountOrigin;
    private BankAccount accountDestination;

    public Transfer() {

    }

    public Transfer(int id, double amount, String concept, Date date, String state, BankAccount accountOrigin, BankAccount accountDestination) {
        this.id = id;
        this.amount = amount;
        this.concept = concept;
        this.date = date;
        this.state = state;
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BankAccount getAccountOrigin() {
        return accountOrigin;
    }

    public void setAccountOrigin(BankAccount accountOrigin) {
        this.accountOrigin = accountOrigin;
    }

    public BankAccount getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(BankAccount accountDestination) {
        this.accountDestination = accountDestination;
    }
}
