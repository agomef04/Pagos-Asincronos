package com.WebSocket.service;

import com.WebSocket.model.State;
import com.WebSocket.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StateInitializationService {


    private final StateRepository stateRepository;


    public StateInitializationService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @PostConstruct
    public void initializeStates() {
        // Verificar si los estados existen en la base de datos
        if (stateRepository.count() == 0) {
            // Si no existen, guardar los estados
            State pendiente = new State(1,"Pendiente", "Movimiento pendiendte de autorizacion bancaria");
            State aceptada = new State(2,"Aceptada", "Movimiento aceptado");
            State rechazada = new State(3,"Rechazada", "Movimiento rechazado por la entidad bancaria");

            stateRepository.save(pendiente);
            stateRepository.save(aceptada);
            stateRepository.save(rechazada);
        }
    }
}
