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
    @OneToOne
    @JoinColumn(name = "state")
    private State state;
    private String concept;
    private Date date;

    @OneToOne
    @JoinColumn(name = "bankAccount_origin_id")
    private BankAccount accountOrigin;

    @OneToOne
    @JoinColumn(name = "bank_account_destination_id")
    private BankAccount accountDestination;

    private String idConexion;

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

    public Transfer(double amount, String concept, Date date, State state, BankAccount accountOrigin, BankAccount accountDestination, String idConexion) {

        this.amount = amount;
        this.concept = concept;
        this.date = date;
        this.state = state;
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
        this.idConexion = idConexion;
    }

    public String getIdConexion() {
        return idConexion;
    }

    public void setIdConexion(String idConexion) {
        this.idConexion = idConexion;
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
