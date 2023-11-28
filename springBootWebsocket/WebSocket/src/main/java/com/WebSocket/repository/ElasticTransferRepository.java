package com.WebSocket.repository;


import com.WebSocket.model.documentElastic.TransferTrace;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ElasticTransferRepository extends ElasticsearchRepository<TransferTrace, String> {
}
