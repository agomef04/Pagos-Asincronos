package com.WebSocket.repository;

import com.WebSocket.model.User;
import com.WebSocket.model.documentElastic.UserElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticsearchUserRepository extends ElasticsearchRepository<UserElastic, Long> {
    List<UserElastic> findByName(String name);
}
