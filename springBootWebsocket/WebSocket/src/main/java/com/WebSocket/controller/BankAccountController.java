package com.WebSocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.WebSocket.model.BankAccount;
import com.WebSocket.service.BankAccountService;
import com.WebSocket.service.TransferService;
import com.WebSocket.model.Transfer;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private TransferService transferService;

    @GetMapping
    public ResponseEntity<?> getAccountTransfers(@RequestParam int idBankAccount){
        List<Transfer> listaTransferencias = bankAccountService.getAccountTransfers(idBankAccount);
        if(listaTransferencias.isEmpty()){
            //No se han hecho transferencias aún
        }
        return new ResponseEntity<>(listaTransferencias, HttpStatus.CREATED);
    }    


}
