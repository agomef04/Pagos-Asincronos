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
import java.util.Map;

@Controller
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private BankAccountService bankAccountService;

    @MessageMapping("/createdTransfer")
    @SendTo("/topic/newTransfer")
    @RequestMapping("/newTransfer")
    public ResponseEntity<?> createTransfer(@RequestBody Map<String, Object> transferData) {
        System.out.println(" METODO POST TRANSFERENCIA -> " + transferData);

        BankAccount accountOrigin = bankAccountService.findById((Integer) transferData.get("bankAccountOrigin"));

        if(accountOrigin == null) {
            return ResponseEntity.badRequest().body("La cuenta origen no existe");
        }
        BankAccount accountDestination = bankAccountService.findByNumberPhone((String) transferData.get("numberPhone"));
        if(accountDestination == null) {
            return ResponseEntity.badRequest().body("La cuenta destino no existe");
        }
        double amount = (double) transferData.get("amount");
        if(!bankAccountService.heHasThisAmount(accountOrigin, amount)) {
            return ResponseEntity.badRequest().body("La cantidad no esta disponible");
        }


        String idConexion = "idConexion";

        Transfer createTransfer = transferService.createTransfer(amount, (String) transferData.get("concept"), accountOrigin, accountDestination , idConexion);
        return new ResponseEntity<>(createTransfer, HttpStatus.OK);
    }



    @RequestMapping("/listTransfer")
    @GetMapping
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
