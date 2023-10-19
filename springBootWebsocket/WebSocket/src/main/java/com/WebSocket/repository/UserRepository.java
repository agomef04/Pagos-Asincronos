package com.WebSocket.repository;

import com.WebSocket.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    // definir cmetodos personalizados si queremos insertar, buscar, eliminar....

    List<User> findByName(String name);

}
