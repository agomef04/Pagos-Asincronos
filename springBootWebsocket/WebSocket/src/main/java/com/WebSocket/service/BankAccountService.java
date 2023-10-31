package com.WebSocket.service;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.User;
import com.WebSocket.repository.BankAccountRepository;
import com.WebSocket.repository.ElasticBankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private ElasticBankAccountRepository elasticBankAccountRepository;


    // comprobar que la cuenta destino existe -> account
    // comprobar que la cuenta origen existe -> account
    // comprobar que la cantidad a mover existe -> account
    // es decir si me restas a mi esa cantiad si la tengo
    // realizar movimiento --> transfer

    public BankAccount create(User user) {
        return bankAccountRepository.save(new BankAccount(100.00, user));
    }

    public void moverDinero(BankAccount bankAccount, double amount) {
        bankAccount.setAmount(bankAccount.getAmount() + amount);
        System.out.println("Dinero nuevo de la guenta -> " + (bankAccount.getAmount() + amount));
        bankAccountRepository.save(bankAccount);
    }

    public boolean heHasThisAmount(BankAccount account, double amount) {
        return account.getAmount() >= amount;

    }

    public boolean existsById(BankAccount bankAccount) {
        return bankAccountRepository.existsById(bankAccount.getId());
    }

    public BankAccount findById(int id) {
        return bankAccountRepository.findById(id);
    }
}
