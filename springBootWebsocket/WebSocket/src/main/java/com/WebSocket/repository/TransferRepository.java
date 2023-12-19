package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

    List<Transfer> findByAccountOrigin(BankAccount bankAccount);

    List<Transfer> findByAccountDestination(BankAccount bankAccount);

    Transfer findByIdConexion(String idConexion);

}
