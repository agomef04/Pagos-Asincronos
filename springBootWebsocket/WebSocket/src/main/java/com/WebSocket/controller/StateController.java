package com.WebSocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WebSocket.model.State;

@RestController
@RequestMapping("{transfer.id}")
public class StateController {
    /* 
    @Autowired
    private StateService stateService;

    @GetMapping
    public State getState(@RequestParam Number id){
        State transferState = stateService.getState(id); 
        return transferState;
    }

    @PostMapping
    public ResponseEntity<?> changeState(@RequestParam State state){
       if(!transferService.transferExists(transfer)){ 
            return ResponseEntity.badRequest().body("La transferencia no existe");
        }
        State newState = stateService.changeState(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
