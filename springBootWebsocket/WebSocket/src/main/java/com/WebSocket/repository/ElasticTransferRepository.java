package com.WebSocket.repository;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticTransferRepository extends CrudRepository<Transfer, Long> {
}
