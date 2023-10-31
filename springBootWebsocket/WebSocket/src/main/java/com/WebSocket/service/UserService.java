package com.WebSocket.service;

import com.WebSocket.model.BankAccount;
import com.WebSocket.model.User;
import com.WebSocket.model.documentElastic.UserElastic;
import com.WebSocket.repository.BankAccountRepository;
import com.WebSocket.repository.ElasticsearchUserRepository;
import com.WebSocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  ElasticsearchUserRepository elasticsearchUserRepository;


    public User createUser(User user) {

        //userRepository.deleteAll();
        User savedUser = userRepository.save(user);
        //User user = new User("juan@gmail.com","password","juanito","987654321");
        UserElastic userElastic = new UserElastic(savedUser);
        elasticsearchUserRepository.save(userElastic);


        List<UserElastic> retrievedUser =  elasticsearchUserRepository.findByName(user.getName());
        if (retrievedUser != null) {
            System.out.println("El usuario se ha guardado correctamente en Elasticsearch.");
        } else {
            System.err.println("El usuario no se ha guardado en Elasticsearch.");
        }

        return savedUser;
    }
    public User loginUser(String email, String password) {
        User existUser = userRepository.findByEmailAndPassword(email,password);
        if(existUser == null) {
            // excepcion nde no existe
        }
        return existUser;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }


    public boolean userExists(User user) {
        return userRepository.existsByEmail(user.getEmail()) || userRepository.existsByPhoneNumber(user.getPhoneNumber());
    }
}