package com.WebSocket.model.documentElastic;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.State;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "transfer_trace")
public class TransferTrace {

    @Id
    private String id;
    private int transferId;
    private double amount;
    private State state;
    String concept;
    private BankAccount accountOrigin;
    private BankAccount accountDestination;
    private Date loginTime;

    public TransferTrace() {

    }

    public TransferTrace(int transferId, double amount, State state, String concept, BankAccount accountOrigin, BankAccount accountDestination, Date loginTime) {
        this.transferId = transferId;
        this.amount = amount;
        this.state = state;
        this.concept = concept;
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
        this.loginTime = loginTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
