package com.WebSocket.service;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.State;
import com.WebSocket.model.Transfer;
import com.WebSocket.repository.ElasticTransferRepository;
import com.WebSocket.repository.StateRepository;
import com.WebSocket.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private ElasticTransferRepository elasticTransferRepository;


    public Transfer createTransfer(Transfer transfer, BankAccount accountOrigin, BankAccount accountDestination) {
        State pendentState = stateRepository.findByNameState("PENDIENTE");
        Transfer transferNuevo = new Transfer(transfer.getAmount(), transfer.getConcept(), new Date(), pendentState, accountOrigin , accountDestination);

        bankAccountService.moverDinero(accountOrigin, -transfer.getAmount());
        bankAccountService.moverDinero(accountDestination, transfer.getAmount());

        return transferRepository.save(transferNuevo);
    }


    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public boolean accountExists(BankAccount bankAccount) {
        // comprobar si existe esta cuenta
        return false;
    }


    public List<Transfer> findByAccountOrigin(Transfer transfer) {
        return transferRepository.findByAccountOrigin(transfer.getAccountOrigin());
    }
}
