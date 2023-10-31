package com.WebSocket.controller;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.Transfer;
import com.WebSocket.service.BankAccountService;
import com.WebSocket.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
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


        // comprobar que la cuenta destino existe -> account
        // comprobar que la cuenta origen existe -> account
        // comprobar que la cantidad a mover existe -> account
            // es decir si me restas a mi esa cantiad si la tengo
        // realizar movimiento --> transfer
    }
}
