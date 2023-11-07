package com.WebSocket.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private State state;
    private String concept;
    private Date date;
    @Lob // Anotación para indicar un campo Large Object (LOB)
    @Column(columnDefinition = "MEDIUMBLOB")
    private BankAccount accountOrigin;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private BankAccount accountDestination;

    public Transfer() {

    }

    public Transfer(int id, double amount, String concept, Date date, State state, BankAccount accountOrigin, BankAccount accountDestination) {
        this.id = id;
        this.amount = amount;
        this.concept = concept;
        this.date = date;
        this.state = state;
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
    }

    public Transfer(double amount, String concept, Date date, State state, BankAccount accountOrigin, BankAccount accountDestination) {

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
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
