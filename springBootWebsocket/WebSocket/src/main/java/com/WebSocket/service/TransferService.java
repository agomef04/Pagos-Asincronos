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


    public Transfer createTransfer(double amount, String concept, BankAccount accountOrigin, BankAccount accountDestination, String idConexion) {
        State pendentState = stateRepository.findByNameState("Pendiente");
        Transfer transferNuevo = new Transfer(amount, concept, new Date(), pendentState, accountOrigin , accountDestination, idConexion);

        TransferTrace newTransfer = new TransferTrace();
        newTransfer.setAmount(amount);
        newTransfer.setConcept(concept);
        newTransfer.setLoginTime(new Date());
        newTransfer.setAccountOrigin(accountOrigin);
        newTransfer.setAccountDestination(accountDestination);
        newTransfer.setState(pendentState);
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
