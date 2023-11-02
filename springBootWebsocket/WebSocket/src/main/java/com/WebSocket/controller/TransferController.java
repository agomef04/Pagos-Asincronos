package com.WebSocket.controller;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.Transfer;
import com.WebSocket.service.BankAccountService;
import com.WebSocket.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private BankAccountService bankAccountService;

    @MessageMapping("/createdTransfer")
    @SendTo("/topic/newTransfer")
    public ResponseEntity<?> createTransfer(@RequestBody Transfer transfer) {
        System.out.println(" METODO POST TRANSFERENCIA -> " + transfer);

        BankAccount accountOrigin = bankAccountService.findById(transfer.getAccountOrigin().getId());
        if(accountOrigin == null) {
            return ResponseEntity.badRequest().body("La cuenta origen no existe");
        }
        BankAccount accountDestination = bankAccountService.findById(transfer.getAccountDestination().getId());
        if(accountDestination == null) {
            return ResponseEntity.badRequest().body("La cuenta destino no existe");
        }
        if(!bankAccountService.heHasThisAmount(accountOrigin, transfer.getAmount())) {
            return ResponseEntity.badRequest().body("La cantidad no esta disponible");
        }

        Transfer createTransfer = transferService.createTransfer(transfer, accountOrigin, accountDestination);
        return new ResponseEntity<>(createTransfer, HttpStatus.OK);
    }


    @MessageMapping("/listTransfer")
    @SendTo("/topic/transfers")
    public ResponseEntity<?> listarTransferencias(@RequestParam BankAccount account) {
        System.out.println(" METODO GET LISTAR TRANSFERENCIAS -> " + account.toString());

        BankAccount bankAccount = bankAccountService.findById(account.getId()) ;
        if(bankAccount == null) {
            return ResponseEntity.badRequest().body("La cuenta no existe");
        }

        List<Transfer> listTransference = transferService.listarTransfer(bankAccount);

        return new ResponseEntity<>(listTransference, HttpStatus.OK);
    }
}
