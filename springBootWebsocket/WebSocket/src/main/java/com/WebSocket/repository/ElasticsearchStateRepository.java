package com.WebSocket.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.WebSocket.model.documentElastic.UserElastic;

public interface ElasticsearchStateRepository extends ElasticsearchRepository<UserElastic, Long>  {
    List<UserElastic> findByName(String name);
    
}
