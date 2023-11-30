package com.example.RabbitMQ.service;

import com.example.RabbitMQ.MessageSender;
import com.example.RabbitMQ.model.BankAccount;
import com.example.RabbitMQ.model.State;
import com.example.RabbitMQ.model.Transfer;
import com.example.RabbitMQ.repository.BankAccountRepository;
import com.example.RabbitMQ.repository.StateRepository;
import com.example.RabbitMQ.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferValidationService {

    /**
     * 1 - Ir cogiendo cada 30s todas las transferencias pendientes
     * 2 - Ver si se pueden validar cada una
     *   2.1 - Si se puede validar, cambiar estado a Denegada o Aceptado
     * 3 - Notificar al cliente
     *
     */

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private MessageSender messageSender;

    String queueName = "spring-boot";


    @Scheduled(fixedRate = 30000)
    // 30000 para 30s
    public void validacionTransferencias() {

        State statePendiente = stateRepository.findByNameState("Pendiente");
        List<Transfer> listTransfer = transferRepository.findByState(statePendiente);

        for(Transfer t : listTransfer) {
            System.out.println(t.toString());
            if(validarSaldoCuenta(t)) {
                aceptarPago(t);
            }else {
                denegarPago(t);
            }
        }
    }

    // FALTA CAMBIAR EL SALGO AL ACEPTARLA

    public boolean validarSaldoCuenta(Transfer transfer) {
        BankAccount cuentaOrigen = bankAccountRepository.findById(transfer.getAccountOrigin().getId());

        return cuentaOrigen.getAmount() >= transfer.getAmount();

    }


    public void aceptarPago(Transfer t) {

        BankAccount accountOrigin = bankAccountRepository.findById(t.getAccountOrigin().getId());
        BankAccount accountDest = bankAccountRepository.findById(t.getAccountDestination().getId());


        State aceptadoState = stateRepository.findByNameState("Aceptada");

        accountOrigin.setAmount(accountOrigin.getAmount() - t.getAmount());
        accountDest.setAmount(accountDest.getAmount() + t.getAmount());
        t.setState(aceptadoState);

        transferRepository.save(t);
        bankAccountRepository.save(accountOrigin);
        bankAccountRepository.save(accountDest);

        messageSender.sendMessage(queueName, "Aceptado", t.getId(), t.getIdConexion());
    }

    public void denegarPago(Transfer t) {

        State rechazadoState = stateRepository.findByNameState("Rechazada");
        t.setState(rechazadoState);
        transferRepository.save(t);

        messageSender.sendMessage(queueName, "Rechazada", t.getId(), t.getIdConexion());
    }

}
