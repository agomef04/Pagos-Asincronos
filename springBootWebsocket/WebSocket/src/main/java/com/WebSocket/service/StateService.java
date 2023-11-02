package com.WebSocket.service;

import com.WebSocket.model.State;
import org.springframework.beans.factory.annotation.Autowired;

import com.WebSocket.repository.ElasticsearchStateRepository;
import com.WebSocket.repository.StateRepository;

public class StateService {
    
    @Autowired
    private StateRepository stateRepository;
    
    @Autowired
    private  ElasticsearchStateRepository elasticsearchStateRepository;

    public State changeState(State state){
        //Fixear esTO
        return state;
    }

    public State getState(Number id){
        State stateAux = new State();
        return stateAux;
    }

    



}
