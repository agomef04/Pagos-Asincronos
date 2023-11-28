package com.WebSocket.controller;

import com.WebSocket.config.WebSocketMessageSender;
import com.WebSocket.model.BankAccount;
import com.WebSocket.model.Transfer;
import com.WebSocket.service.BankAccountService;
import com.WebSocket.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

import java.net.http.WebSocket;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private WebSocketMessageSender messageSender;

    @MessageMapping("/createdTransfer")
    @SendTo("/topic/newTransfer")
    public String createTransfer(Message transferData, SimpMessageHeaderAccessor headerAccessor) {

        //System.out.println(" METODO POST TRANSFERENCIA -> " + transferData.getHeaders());
        String idConexion = headerAccessor.getSessionId();
        Map<String, List<String>> nativeHeaders = (Map<String, List<String>>) transferData.getHeaders().get("nativeHeaders");

        if(Objects.equals((String) getValueFromHeaders(nativeHeaders, "bankAccountOrigin"), (String) getValueFromHeaders(nativeHeaders, "numberPhone"))) {
            return "Cuenta destino y origen es la misma";
        }

        BankAccount accountOrigin = bankAccountService.findByNumberPhone((String) getValueFromHeaders(nativeHeaders, "bankAccountOrigin"));

        if(accountOrigin == null) {
            return "La cuenta origen no existe";
        }
        BankAccount accountDestination = bankAccountService.findByNumberPhone((String) getValueFromHeaders(nativeHeaders, "numberPhone"));
        if(accountDestination == null) {
            return "La cuenta destino no existe";
        }

        double amount = Double.parseDouble(getValueFromHeaders(nativeHeaders, "amount"));
        if(!bankAccountService.heHasThisAmount(accountOrigin, amount) && amount > 0.00) {
            return "La cantidad no esta disponible";
        }

        Transfer createTransfer = transferService.createTransfer(amount, (String) getValueFromHeaders(nativeHeaders, "concept"), accountOrigin, accountDestination , idConexion);
        return "Transferencia pendiente de validación";
    }

    private String getValueFromHeaders(Map<String, List<String>> headers, String key) {
        List<String> values = headers.get(key);
        if (values != null && !values.isEmpty()) {
            return values.get(0);
        }
        return null;
    }


    @RequestMapping("/listTransfer")
    @GetMapping
    public ResponseEntity<?> listarTransferencias(@RequestParam String phoneNumber) {
        System.out.println(" METODO GET LISTAR TRANSFERENCIAS -> " + phoneNumber);

        //BankAccount bankAccount = bankAccountService.findById(account.getId()) ;
        BankAccount bankAccount = bankAccountService.findByNumberPhone(phoneNumber);
        if(bankAccount == null) {
            return ResponseEntity.badRequest().body("La cuenta no existe");
        }

        List<Transfer> listTransference = transferService.listarTransfer(bankAccount);

        return new ResponseEntity<>(listTransference, HttpStatus.OK);
    }
}
