package com.WebSocket.repository;

import com.WebSocket.model.documentElastic.LoginTrace;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticsearchLoginRepository extends ElasticsearchRepository<LoginTrace, String> {
}
