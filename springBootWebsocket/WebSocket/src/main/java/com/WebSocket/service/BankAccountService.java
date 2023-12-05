package com.WebSocket.service;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.User;
import com.WebSocket.model.Transfer;
import com.WebSocket.repository.BankAccountRepository;
import com.WebSocket.repository.ElasticBankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private ElasticBankAccountRepository elasticBankAccountRepository;

    // comprobar que la cuenta destino existe -> account
    // comprobar que la cuenta origen existe -> account
    // comprobar que la cantidad a mover existe -> account
    // es decir si me restas a mi esa cantiad si la tengo
    // realizar movimiento --> transfer

    public BankAccount create(User user) {
        BankAccount account = new BankAccount(100.00, user);
        //user.setBankAccount(account);
        return bankAccountRepository.save(account);
    }

    public List<Transfer> getAccountTransfers(int idBankAccount){
        List<Transfer> accountTransfers = new ArrayList<Transfer>();
        
        /*Iterar sobre el conjunto de transferencias y añadir a accountTransfers 
         * aquellas que tengan la cuenta con idBankAccount por cuentaOrigen o por
         * cuenta destino
        */

        return accountTransfers;
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

    public BankAccount findByNumberPhone(String numberPhone) {
        User user = userService.findByNumberPhone(numberPhone);
        return bankAccountRepository.findByUser(user);
    }
}
