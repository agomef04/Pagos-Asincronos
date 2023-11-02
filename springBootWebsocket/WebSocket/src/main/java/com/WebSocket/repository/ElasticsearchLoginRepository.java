package com.WebSocket.repository;

import com.WebSocket.model.documentElastic.LoginTrace;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticsearchLoginRepository extends ElasticsearchRepository<LoginTrace, Long> {
}
