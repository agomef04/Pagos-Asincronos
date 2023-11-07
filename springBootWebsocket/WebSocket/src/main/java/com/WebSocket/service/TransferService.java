package com.WebSocket.service;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.State;
import com.WebSocket.model.Transfer;
import com.WebSocket.model.documentElastic.TransferTrace;
import com.WebSocket.repository.ElasticTransferRepository;
import com.WebSocket.repository.StateRepository;
import com.WebSocket.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        TransferTrace newTransfer = new TransferTrace();
        newTransfer.setAmount(transfer.getAmount());
        newTransfer.setConcept(transfer.getConcept());
        newTransfer.setLoginTime(new Date());
        newTransfer.setAccountOrigin(transfer.getAccountOrigin());
        newTransfer.setAccountDestination(transfer.getAccountDestination());
        newTransfer.setState(transfer.getState());
        elasticTransferRepository.save(newTransfer);

        return transferRepository.save(transferNuevo);
    }


    public List<Transfer> listarTransfer (BankAccount bankAccount) {
        List<Transfer> listTransfer = new ArrayList<>();
        listTransfer.addAll(transferRepository.findByAccountOrigin(bankAccount));
        listTransfer.addAll(transferRepository.findByAccountDestination(bankAccount));
        return listTransfer;
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
