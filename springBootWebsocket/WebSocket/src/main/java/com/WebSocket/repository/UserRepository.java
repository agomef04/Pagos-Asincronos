package com.WebSocket.repository;

import com.WebSocket.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // definir cmetodos personalizados si queremos insertar, buscar, eliminar....

    List<User> findByName(String name);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    User findByEmailAndPassword(String email, String password);

    User findByPhoneNumber(String phoneNumber);

}
