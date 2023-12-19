package com.WebSocket.repository;

import com.WebSocket.model.User;
import com.WebSocket.model.documentElastic.UserElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ElasticsearchUserRepository extends ElasticsearchRepository<UserElastic, String> {
    List<UserElastic> findByName(String name);
}
